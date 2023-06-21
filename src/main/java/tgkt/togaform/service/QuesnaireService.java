package tgkt.togaform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tgkt.togaform.entity.Quesnaire;
import tgkt.togaform.repo.QuesnaireRepo;
import tgkt.togaform.request.QuesnaireListRequest;
import tgkt.togaform.response.ListResponse;

@Service
public class QuesnaireService {
    @Autowired
    private QuesnaireRepo repo;

    public int insert(Quesnaire q) {
        return repo.insert(q) == null
                ? 0 : 1;
    }

    public int deleteById(Quesnaire q) {
        try {
            repo.deleteById(q.getId());
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public int update(Quesnaire q) {
        if (repo.existsById(q.getId()))
            return 0;

        repo.save(q);
        return 1;
    }

    public Quesnaire selectById(
            Quesnaire q) {
        var optional = repo.findById(q.getId());
        return optional.orElse(null);
    }

    public ListResponse selectByProject(
            QuesnaireListRequest req) {

        var totalPage = req.getLimit() != 0 ?
                (int) (repo.count()) / req.getLimit() + 1
                : -1;
        var currentPage = req.getLimit() != 0 ?
                req.getStart() / req.getLimit() + 1
                : -1;

        return ListResponse.builder()
                .data(repo.findByProject(req.getProject()))
                .totalPage(totalPage)
                .currentPage(currentPage)
                .build();
    }
}
