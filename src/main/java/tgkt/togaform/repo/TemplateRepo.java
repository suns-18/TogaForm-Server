package tgkt.togaform.repo;

import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import tgkt.togaform.entity.Template;

import java.util.Optional;

public interface TemplateRepo extends MongoRepository<Template,String> {
    @Override
    <S extends Template> S insert(S entity);

    @Override
    <S extends Template> S save(S entity);

    @Override
    Optional<Template> findById(String s);

    @Override
    void deleteById(String s);

    @Override
    boolean existsById(String s);

    @Override
    long count();
}
