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

    public int insert(User user) throws NullPointerException {
        if (user.getUsername().isEmpty())
            return 0;
        user.setId(UUIDUtil.getOneUUID());
        return mapper.insert(user);
    }
    public int deleteById(User user) {
        return mapper.deleteById(user);
    }
    public int update(User user) {
        if(user.getId()==null||user.getId().equals("")||user.getUsername().equals("")||user.getUsername()==null)
            return 0;
        return mapper.update(user);
    }

    public ListResponse selectAll(UserListRequest req) {

        var totalPage = req.getLimit() == 0 ? -1 :
                mapper.countAll(req) / req.getLimit() + 1;

        var currentPage = req.getLimit() == 0 ? -1 :
                (req.getStart() / req.getLimit()) + 1;

        return ListResponse.builder()
                .totalPage(totalPage)
                .data(mapper.selectAll(req))
                .currentPage(currentPage)
                .build();
    }

    public User selectById(User user) {
        return mapper.selectById(user);
    }

    public User verify(User user) {
        return mapper.verify(user);
    }

}
