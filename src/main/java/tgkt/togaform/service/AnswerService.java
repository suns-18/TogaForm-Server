package tgkt.togaform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tgkt.togaform.entity.Answer;
import tgkt.togaform.entity.Question;
import tgkt.togaform.repo.AnswerRepo;
import tgkt.togaform.request.AnswerListRequest;
import tgkt.togaform.response.HttpResponse;
import tgkt.togaform.response.ListResponse;
import tgkt.togaform.response.QuestionStatResponse;
import tgkt.togaform.response.StatMap;
import tgkt.togaform.util.BSONIDUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class AnswerService {
    @Autowired
    private AnswerRepo repo;
    @Autowired
    private QuesnaireService quesnaireService;

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

    public List<QuestionStatResponse> statByQuesnaire(
            AnswerListRequest req) {

        var answerUsers = repo.findByQuesnaire(req.getQuesnaire());

        var quesnaire = quesnaireService.selectById(req.getQuesnaire());
        var questions = quesnaire.getQuestions();

        List<QuestionStatResponse> respList = new ArrayList<>();

        for (int i = 0; i < questions.size(); i++) {
            var resp = new QuestionStatResponse();
            var question = questions.get(i);
            resp.setQuestion(question);

            var maps = new ArrayList<StatMap>();
            if (question.getAnswerType() <= 2)
                question.getSelections().forEach(sel -> {
                    var mapItem = new StatMap();
                    mapItem.setName(sel.getKey());
                    mapItem.setValue(0);
                    maps.add(mapItem);
                });

            for (Answer item : answerUsers) {
                var answerForQuestion = item.getAnswers().get(i);
                StatMap map = new StatMap();

                if (question.getAnswerType() == 3) {
                    map.setName(answerForQuestion.get(0));
                    maps.add(map);
                } else if (question.getAnswerType() <= 2) {
                    answerForQuestion.forEach(sel -> {
                        maps.forEach(m -> {
                            if (m.getName().equals(sel))
                                m.setValue(m.getValue() + 1);
                        });
                    });
                }
            }

            resp.setMaps(maps);
            respList.add(resp);
        }
        return respList;
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
