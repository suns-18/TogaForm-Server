package tgkt.togaform.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tgkt.togaform.entity.Answer;
import tgkt.togaform.entity.Quesnaire;
import tgkt.togaform.repo.AnswerRepo;
import tgkt.togaform.request.AnswerlistRequest;
import tgkt.togaform.request.QuesnaireListRequest;
import tgkt.togaform.response.ListResponse;
import tgkt.togaform.util.BSONIDUtil;

import java.util.List;

@Service
public class AnswerService {
    @Autowired
    private AnswerRepo repo;

    public int insert(Answer a) {
        a.setId(BSONIDUtil.getOneId());
        return repo.insert(a) == null
                ? 0 : 1;
    }

    public int deleteById(Answer a) {
        try {
            repo.deleteById(a.getId());
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public int update(Answer a) {
        if (repo.existsById(a.getId()))
            return 0;

        repo.save(a);
        return 1;
    }

    public Answer selectById(
            Answer a) {
        var optional = repo.findById(a.getId());
        return optional.orElse(null);
    }

    public ListResponse selectByQuesnaire(
            AnswerlistRequest req) {

        var list = repo.findByQuesnaire(req.getQuesnaire());

        var totalPage = req.getLimit() != 0 ?
                (list.size()) / req.getLimit() + 1
                : -1;
        var currentPage = req.getLimit() != 0 ?
                req.getStart() / req.getLimit() + 1
                : -1;

        return ListResponse.builder()
                .data(list.subList(req.getStart(), req.getLimit()))
                .totalPage(totalPage)
                .currentPage(currentPage)
                .build();
    }

    public List<Answer> selectByUser(
            Answer req) {

        return repo.findAllByUserId(req.getUserId());
    }

    public List<Answer> selectByUser(
            String userId) {

        return repo.findAllByUserId(userId);
    }
}
