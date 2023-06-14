package tgkt.togaform.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import tgkt.togaform.entity.User;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    List<User> queryList(User user);
    List<User> verify(User user);
    int insert(User user);
    int update(User user);
    int deleteById(User user);

	int deleteByName(User user);
}
