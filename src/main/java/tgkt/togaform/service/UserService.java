package tgkt.togaform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tgkt.togaform.mapper.UserMapper;
import tgkt.togaform.entity.User;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> queryList(User user) {
        return userMapper.queryList(user);
    }

    public List<User> verify(User user) {
        try {
            var result = userMapper.verify(user);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int add(User user) {
        var result = userMapper.insert(user);
        if (result != 0) {
            return 3;
        } else return result;
    }

    public int modify(User user) {
        return userMapper.update(user);
    }

    public int removeById(User user) {
        return userMapper.deleteById(user);
    }

}
