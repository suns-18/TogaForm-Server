package tgkt.togaform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tgkt.togaform.mapper.UserMapper;
import tgkt.togaform.entity.User;
import tgkt.togaform.util.UUIDUtil;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> queryList(User user) {
        return userMapper.selectAll(user);
    }

    public User verify(User user) {
        return userMapper.verify(user);
    }

    public int insert(User user) throws NullPointerException {
        if (user.getUsername().isEmpty())
            return 0;
        user.setId(UUIDUtil.getOneUUID());
        return userMapper.insert(user);
    }

    public int update(User user) {
        return userMapper.update(user);
    }

    public int deleteById(User user) {
        return userMapper.deleteById(user);
    }
}
