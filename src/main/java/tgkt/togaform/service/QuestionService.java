package tgkt.togaform.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tgkt.togaform.entity.Question;
import tgkt.togaform.repo.QuestionRepo;
import tgkt.togaform.util.BSONIDUtil;


@Service
public class QuestionService {
    @Autowired
    private QuestionRepo repo;
    public int insert(Question q) {
        q.setId(BSONIDUtil.getOneId());
        return repo.insert(q) == null
                ? 0 : 1;
    }
    public int deleteById(Question q) {
        try {
            repo.deleteById(q.getId());
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
    public int update(Question q) {
        if (repo.existsById(q.getId()))
            return 0;

        repo.save(q);
        return 1;
    }
    public Question selectById(
            Question q) {
        var optional = repo.findById(q.getId());
        return optional.orElse(null);
    }


}
