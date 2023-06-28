package tgkt.togaform.service;

import org.bson.codecs.ObjectIdGenerator;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tgkt.togaform.entity.Answer;
import tgkt.togaform.entity.Quesnaire;
import tgkt.togaform.repo.QuesnaireRepo;
import tgkt.togaform.request.QuesnaireListRequest;
import tgkt.togaform.response.ListResponse;
import tgkt.togaform.response.QuesnaireFinishResponse;
import tgkt.togaform.util.BSONIDUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class QuesnaireService {
    @Autowired
    private QuesnaireRepo repo;
    @Autowired
    private AnswerService answerService;

    public int insert(Quesnaire q) {
        q.setId(BSONIDUtil.getOneId());

        if (q.getStartTime() == null)
            q.setStartTime(new Date());

        q.setCreateTime(new Date());

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

    public ListResponse selectByUser(QuesnaireListRequest req, String userId) {

        var allQuesnaireList = repo.findAll();
        var answerList = answerService.selectByUser(userId);

        var finishedList = new ArrayList<String>();
        var unfinishedList = new ArrayList<String>();
        answerList.forEach(item -> {
            finishedList.add(item.getQuesnaire());
        });

        allQuesnaireList.forEach(item -> {
            unfinishedList.add(item.getId());
        });

        unfinishedList.removeAll(finishedList);

        var orderedList = new ArrayList<QuesnaireFinishResponse>();

        unfinishedList.forEach(item -> {
            var q = repo.findById(item);
            q.ifPresent(quesnaire -> {
                orderedList.add(
                        QuesnaireFinishResponse.builder()
                                .finished(false)
                                .quesnaire(quesnaire)
                                .build());

            });
        });

        finishedList.forEach(item -> {
            var q = repo.findById(item);
            q.ifPresent(quesnaire -> {
                orderedList.add(
                        QuesnaireFinishResponse.builder()
                                .finished(true)
                                .quesnaire(quesnaire)
                                .build());

            });
        });

        orderedList.subList(req.getStart(), req.getStart() + req.getLimit());

        var totalPage = req.getLimit() != 0 ?
                (orderedList.size()) / req.getLimit() + 1
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
