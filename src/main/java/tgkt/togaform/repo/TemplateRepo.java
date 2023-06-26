package tgkt.togaform.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import tgkt.togaform.entity.Template;

import java.util.Optional;

public interface TemplateRepo extends MongoRepository<Template, String> {
    @Override
    <S extends Template> S insert(S entity);

    @Override
    <S extends Template> S save(S entity);

    @Override
    Optional<Template> findById(String s);

    Page<Template> findAll(Pageable pageable);

    Page<Template> findByTitleLike(Pageable pageable,
                                   String title);

    @Override
    void deleteById(String s);

    @Override
    boolean existsById(String s);

    @Override
    long count();

    long countByTitleLike(String title);

}
