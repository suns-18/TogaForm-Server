package tgkt.togaform.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import tgkt.togaform.entity.Quesnaire;
import tgkt.togaform.entity.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionRepo extends MongoRepository<Question,String> {
    @Override
    <S extends Question> S insert(S entity);

    @Override
    <S extends Question> S save(S entity);

    @Override
    Optional<Question> findById(String s);


    @Override
    void deleteById(String s);

    @Override
    boolean existsById(String s);

    @Override
    long count();
}
