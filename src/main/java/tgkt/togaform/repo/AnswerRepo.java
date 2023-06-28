package tgkt.togaform.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import tgkt.togaform.entity.Answer;
import java.util.List;
import java.util.Optional;

public interface AnswerRepo extends
        MongoRepository<Answer, String> {
    @Override
    <S extends Answer> S insert(S entity);

    @Override
    <S extends Answer> S save(S entity);

    @Override
    boolean existsById(String s);

    @Override
    void deleteById(String s);
    List<Answer> findByQuesnaire(String quesnaireId);

    @Override
    Optional<Answer> findById(String s);

    List<Answer> findAllByUserId(String userId);

    @Override
     long count();
}
