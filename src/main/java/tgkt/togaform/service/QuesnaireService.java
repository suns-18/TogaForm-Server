package tgkt.togaform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import tgkt.togaform.entity.Quesnaire;
import tgkt.togaform.mapper.QuesnaireMapper;

import java.util.List;

@Service
public class QuesnaireService {
    @Autowired
    private QuesnaireMapper mapper;

    public int insert(Quesnaire quesnaire) {
        return mapper.insert(quesnaire);
    }

    public int delete(Quesnaire quesnaire) {
        return mapper.deleteById(quesnaire.getId());
    }

    public int update(Quesnaire quesnaire) {
        return mapper.update(quesnaire);
    }

    public Quesnaire selectById(Quesnaire quesnaire) {
        return mapper.selectById(quesnaire.getId());
    }

    public List<Quesnaire> selectByProject(Quesnaire quesnaire) {
        return mapper.selectByProject(quesnaire);
    }
}
