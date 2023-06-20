package tgkt.togaform.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import tgkt.togaform.entity.User;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    int insert(User user);
    int deleteById(User user);
    int deleteByName(User user);
    int update(User user);
    User selectById(User user);
    List<User> selectAll(User user);
    User verify(User user);
}
