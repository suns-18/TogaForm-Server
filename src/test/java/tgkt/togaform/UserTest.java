package tgkt.togaform;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tgkt.togaform.controller.UserController;
import tgkt.togaform.entity.User;
import tgkt.togaform.request.UserListRequest;
import tgkt.togaform.service.UserService;

import java.util.List;
import java.util.UUID;

@SpringBootTest
@Component
public class UserTest {
    @Autowired
    UserController controller;
    @Autowired
    UserService userService;
    Logger log = Logger.getLogger(UserTest.class);

    @Order(1)
    @Test
    void add() {
        var u = new User();
        u.setId("test");
        u.setUsername("test1");
        u.setRole(1);
        u.setPassword("test1");
        u.setStatus("1");
        Assertions.assertEquals(
                controller.add(u).getCode(), 1);
        log.info("User模块>>添加请求测试1：正常情况，通过");

        var u1 = new User();
        u1.setUsername(null);
        Assertions.assertEquals(
                controller.add(u).getCode(), 0);
        log.info("User模块>>添加请求测试2：用户名为null，通过");

        u1.setUsername("");
        Assertions.assertEquals(
                controller.add(u).getCode(), 0);
        log.info("User模块>>添加请求测试3：工程名为空字符串，通过");

        log.info("User模块>>添加请求测试通过");
    }
    @Order(2)
    @Test
    void queryList() {
        UserListRequest u1 = new UserListRequest();
        u1.setUsername("啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊");
        // 该不会有人叫这个名吧
        Assertions.assertTrue(((List<User>)
                        (controller.queryList(u1)
                                .getData()))
                        .isEmpty()
                , "User模块>>列表请求测试1：未查询到用户列表，未通过");
        log.info("User模块>>列表请求测试1：查询到用户列表，通过");

        u1.setUsername("tes");
        Assertions.assertFalse(((List<User>)
                        (controller.queryList(u1)
                                .getData()))
                        .isEmpty()
                , "User模块>>列表请求测试2：根据用户名模糊查询，未通过");

        log.info("User模块>>列表请求测试2：根据用户名模糊查询，通过");

        u1.setUsername(null);
        Assertions.assertFalse(((List<User>)
                        (controller.queryList(u1)
                                .getData()))
                        .isEmpty()
                , "User模块>>列表请求测试3：用户名为null，未通过");
        log.info("User模块>>列表请求测试3：用户名为null，通过");

        log.info("User模块>>列表请求测试通过");
    }
    @Order(3)
    @Test
    void modify() {
        var u = new User();
        u.setId("test");
        u.setUsername("admin");
        Assertions.assertEquals(
                controller.modify(u).getCode(), 1);
        log.info("User模块>>更新请求测试1：正常情况，通过");

        var u1 = new User();
        u1.setId(null);
        u1.setUsername(null);
        Assertions.assertEquals(
                controller.modify(u1).getCode(), 0);
        log.info("User模块>>更新请求测试2：Id和所修改字段新值均为null，通过");

        u1.setId("");
        u1.setUsername(null);
        Assertions.assertEquals(
                controller.modify(u1).getCode(), 0);
        log.info("User模块>>更新请求测试3：Id为空串，所修改字段新值为null，通过");

        u1.setId("114514");
        u1.setUsername(null);
        Assertions.assertEquals(
                controller.modify(u1).getCode(), 0);
        log.info("User模块>>更新请求测试4：错误的Id，通过");

        log.info("User模块>>更新请求测试通过");
    }
    @Order(4)
    @Test
    void del() {
        var u = new User();
        u.setId("test");

        Assertions.assertEquals(
                controller.deleteById(u).getCode(),1);
        log.info("User模块>>删除请求测试1：正常情况，通过");

        u.setId(null);
        Assertions.assertEquals(
                controller.deleteById(u).getCode(), 0);
        log.info("User模块>>删除请求测试2：Id为null，通过");


        u.setId("adasdasdasdasdassdasdasdasdasdasdasdasdsadasd");
        Assertions.assertEquals(
                controller.deleteById(u).getCode(),0);
        log.info("User模块>>删除请求测试3：不存在的Id，通过");

        log.info("User模块>>删除请求测试通过");
    }

    @Test
    public void login() {
        controller.userLogout();
        log.info("User模块>>登出请求测试：正常情况，通过");

        var u = new User();
        u.setUsername("admin");
        u.setPassword("iLhzRB");
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
    }

    @Test
    public void queryById() {
        var u = new User();
        u.setId("430331db870c632304e5c56c17c0bf63");
        Assertions.assertEquals(controller.queryById(u).getCode(),1,
                "User模块>>根据Id查询请求测试1：存在的Id，未通过");
        log.info("User模块>>根据Id查询请求测试1：存在的Id，通过");

        u.setId("sdsadada");
        Assertions.assertEquals(controller.queryById(u).getCode(),0,
                "User模块>>根据Id查询请求测试2：不存在的Id，未通过");
        log.info("User模块>>根据Id查询请求测试2：不存在的Id，通过");

        u.setId(null);
        Assertions.assertEquals(controller.queryById(u).getCode(),0,
                "User模块>>根据Id查询请求测试3：Id=null，未通过");
        log.info("User模块>>根据Id查询请求测试3：Id=null，通过");

        log.info("User模块>>根据Id查询请求测试，通过");
    }

}
