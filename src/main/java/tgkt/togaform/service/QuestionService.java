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
        if(q.getTitle()==null||q.getTitle().equals("")){
            return 0;
        }
        return repo.insert(q) == null
                ? 0 : 1;
    }
    public int deleteById(Question q) {
            if(q.getId()==null ||
                    !repo.existsById(q.getId()))
                return 0;
            repo.deleteById(q.getId());
            return 1;

    }
    public int update(Question q) {
        if (!repo.existsById(q.getId()))
            return 0;
        if(q.getTitle()==null||q.getTitle().equals("")){
            return 0;
        }
        repo.save(q);
        return 1;
    }
    public Question selectById(
            Question q) {
        var optional = repo.findById(q.getId());
        return optional.orElse(null);
    }

}
