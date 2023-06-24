package tgkt.togaform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tgkt.togaform.entity.Template;
import tgkt.togaform.repo.TemplateRepo;

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

}
