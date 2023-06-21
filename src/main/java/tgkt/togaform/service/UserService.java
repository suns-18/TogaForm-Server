package tgkt.togaform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tgkt.togaform.mapper.UserMapper;
import tgkt.togaform.entity.User;
import tgkt.togaform.request.UserListRequest;
import tgkt.togaform.response.ListResponse;
import tgkt.togaform.util.UUIDUtil;

@Service
public class UserService {
    @Autowired
    private UserMapper mapper;

    public ListResponse selectAll(UserListRequest req) {
        var list = mapper.selectAll(req);
        var totalCount = mapper.countAll(req);
        var newPage = (req.getStart() / 10) + 1;
        return ListResponse.builder()
                .totalPage(totalCount / 10 + 1)
                .data(list)
                .currentPage(newPage)
                .build();
    }

    public User verify(User user) {
        return mapper.verify(user);
    }

    public int insert(User user) throws NullPointerException {
        if (user.getUsername().isEmpty())
            return 0;
        user.setId(UUIDUtil.getOneUUID());
        return mapper.insert(user);
    }

    public int update(User user) {
        return mapper.update(user);
    }

    public int deleteById(User user) {
        return mapper.deleteById(user);
    }
}
