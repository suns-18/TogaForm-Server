package tgkt.togaform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import tgkt.togaform.entity.Template;
import tgkt.togaform.repo.TemplateRepo;
import tgkt.togaform.request.TemplateListRequest;
import tgkt.togaform.response.ListResponse;

@Service
public class TemplateService {
    @Autowired
    private TemplateRepo repo;

    public int insert(Template t) {
        return repo.insert(t) == null
                ? 0 : 1;
    }

    public int deleteById(Template t) {
        try {
            repo.deleteById(t.getId());
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public int update(Template t) {
        if (repo.existsById(t.getId()))
            return 0;

        repo.save(t);
        return 1;
    }

    public Template selectById(
            Template t) {
        var optional = repo.findById(t.getId());
        return optional.orElse(null);
    }

    public ListResponse selectAll(
            TemplateListRequest req) {

        var totalPage = req.getSize() != 0 ?
                (int) (repo.count()) / req.getSize() + 1
                : -1;
        var currentPage = req.getPage() > 0 &&
                req.getPage() <= totalPage ? req.getPage() :
                req.getPage() == 0 ? 1 : totalPage;

        return ListResponse.builder()
                .data(repo.findAll(PageRequest.of(
                        req.getPage() - 1,
                        req.getSize())).get().toList())
                .totalPage(totalPage)
                .currentPage(currentPage)
                .build();
    }

    public ListResponse selectByTitleLike(
            TemplateListRequest req) {

        System.out.println(repo.countByTitleLike(req.getTitle()));
        var totalPage = req.getSize() != 0 ?
                (int)(repo.countByTitleLike(req.getTitle())) / req.getSize() + 1
                : -1;
        var currentPage = req.getPage() > 0 &&
                req.getPage() <= totalPage ? req.getPage() :
                req.getPage() == 0 ? 1 : totalPage;

        return ListResponse.builder()
                .data(repo.findByTitleLike(PageRequest.of(
                                req.getPage()-1,
                                req.getSize()),
                        req.getTitle()
                ).get().toList())
                .totalPage(totalPage)
                .currentPage(currentPage)
                .build();
    }
}
