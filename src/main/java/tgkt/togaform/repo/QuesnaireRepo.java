package tgkt.togaform.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tgkt.togaform.entity.Quesnaire;
import java.util.List;
import java.util.Optional;

@Repository
public interface QuesnaireRepo extends
        MongoRepository<Quesnaire, String> {
    @Override
    <S extends Quesnaire> S insert(S entity);
    @Override
    <S extends Quesnaire> S save(S entity);

    Optional<Quesnaire> findById(String Id);

    List<Quesnaire> findByProject(String projectId);

    @Override
    boolean existsById(String s);

    @Override
    long count();

    @Override
    List<Quesnaire> findAll();
}
