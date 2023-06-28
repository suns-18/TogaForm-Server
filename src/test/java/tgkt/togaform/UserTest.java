package tgkt.togaform;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import tgkt.togaform.controller.UserController;
import tgkt.togaform.entity.User;
import tgkt.togaform.request.UserListRequest;
import tgkt.togaform.service.UserService;

import java.util.List;

@SpringBootTest
@Component
public class UserTest {
    @Autowired
    UserController controller;
    @Autowired
    UserService userService;
    Logger log = Logger.getLogger(ProjectTest.class);
/*
    @Test
    void queryList() {
        UserListRequest u = new UserListRequest();
        u.setUsername("啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊");
        // 该不会有人叫这个名吧
        Assertions.assertTrue(((List<User>)
                        (controller.queryList(u)
                                .getData()))
                        .isEmpty()
                , "User模块>>列表请求测试1：未查询到用户列表，未通过");
        log.info("User模块>>列表请求测试1：查询到用户列表，通过");

        u.setUsername("g");
        Assertions.assertFalse(((List<User>)
                        (controller.queryList(u)
                                .getData()))
                        .isEmpty()
                , "User模块>>列表请求测试2：根据用户名模糊查询，未通过");

        log.info("User模块>>列表请求测试2：根据用户名模糊查询，通过");

        u.setUsername(null);
        Assertions.assertFalse(((List<User>)
                        (controller.queryList(u)
                                .getData()))
                        .isEmpty()
                , "User模块>>列表请求测试3：用户名为null，未通过");
        log.info("User模块>>列表请求测试3：用户名为null，通过");

        log.info("User模块>>列表请求测试通过");
    }

    @Test
    void add() {
        var u = new User();
        u.setUsername("test1");
        Assertions.assertEquals(
                controller.add(u).getCode(), "1");
        log.info("User模块>>添加请求测试1：正常情况，通过");

        u.setUsername(null);
        Assertions.assertEquals(
                controller.add(u).getCode(), "0");
        log.info("User模块>>添加请求测试2：用户名为null，通过");

        u.setUsername("");
        Assertions.assertEquals(
                controller.add(u).getCode(), "0");
        log.info("User模块>>添加请求测试3：工程名为空字符串，通过");

        log.info("User模块>>添加请求测试通过");
    }

    @Test
    void modify() {
        var u = new UserListRequest();
        u = (UserListRequest) ((List<?>) (controller.queryList(u).getData())).get(0);
        u.setUsername("admin");
        Assertions.assertEquals(
                controller.modify(u).getCode(), "1");
        log.info("User模块>>更新请求测试1：正常情况，通过");

        u.setId(null);
        u.setUsername(null);
        Assertions.assertEquals(
                controller.modify(u).getCode(), "0");
        log.info("User模块>>更新请求测试2：Id和所修改字段新值均为null，通过");

        u.setId("");
        u.setUsername(null);
        Assertions.assertEquals(
                controller.modify(u).getCode(), "0");
        log.info("User模块>>更新请求测试3：Id为空串，所修改字段新值为null，通过");

        u.setId("114514");
        u.setUsername(null);
        Assertions.assertEquals(
                controller.modify(u).getCode(), "0");
        log.info("User模块>>更新请求测试4：错误的Id，通过");

        log.info("User模块>>更新请求测试通过");
    }

    @Test
    void del() {
        var u = new UserListRequest();
        u.setId(null);
        Assertions.assertEquals(
                controller.deleteById(u).getCode(), 0);
        log.info("User模块>>删除请求测试1：Id为null，通过");

        u.setUsername("test");
        u = (UserListRequest) ((List<User>) controller.queryList(u).getData()).get(0);
        Assertions.assertEquals(1,
                controller.deleteById(u).getCode());
        log.info("User模块>>删除请求测试2：正常情况，通过");

        u.setId("adasdasdasdasdassdasdasdasdasdasdasdasdsadasd");
        Assertions.assertEquals(0,
                controller.deleteById(u).getCode());
        log.info("User模块>>删除请求测试3：不存在的Id，通过");

        log.info("User模块>>删除请求测试通过");
    }

    @Test
    public void login() {
        controller.userLogout();
        log.info("User模块>>登出请求测试：正常情况，通过");

        var u = new User();
        u.setUsername("admin");
        u.setPassword("123");
        Assertions.assertNotNull(controller.login(u),
                "User模块>>登陆请求测试1：正常情况，未通过");
        log.info("User模块>>登陆请求测试1：正常情况，通过");

        u.setUsername("admiwewen");
        u.setPassword("adwdwdmin");
        Assertions.assertNotNull(controller.login(u),
                "User模块>>登陆请求测试2：用户名或密码错误，未通过");
        log.info("User模块>>登陆请求测试2：用户名或密码错误，通过");

        Assertions.assertNotNull(controller.login(null),
                "User模块>>登陆请求测试3：用户为null，未通过");
        log.info("User模块>>登陆请求测试3：用户名或密码错误，通过");

        Assertions.assertNotNull(controller.login(new User()),
                "User模块>>登陆请求测试4：用户名和密码为null，未通过");
        log.info("User模块>>登陆请求测试4：用户名或密码错误，通过");

        log.info("User模块>>删除请求测试通过");
    }*/
}
