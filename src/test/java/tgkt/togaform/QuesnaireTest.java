package tgkt.togaform;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import tgkt.togaform.controller.QuesnaireController;
import tgkt.togaform.entity.Project;
import tgkt.togaform.entity.Quesnaire;
import tgkt.togaform.request.ProjectListRequest;
import tgkt.togaform.request.QuesnaireListRequest;
import tgkt.togaform.service.ProjectService;
import tgkt.togaform.util.BSONIDUtil;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class QuesnaireTest {
    @Autowired
    QuesnaireController controller;
    @Autowired
    ProjectService projectService;

    Logger log = Logger.getLogger(QuesnaireTest.class);

    @Test
    @Order(1)
    void add() {
        var q = new Quesnaire();
        q.setId("test");
        q.setTitle("test1");
        Assertions.assertEquals(
                controller.add(q).getCode(), 1);
        log.info("Quesnaire模块>>添加请求测试1：正常情况，通过");

        var q1 = new Quesnaire();
        q1.setTitle(null);
        Assertions.assertEquals(
                controller.add(q1).getCode(), 0);
        log.info("Quesnaire模块>>添加请求测试2：问卷标题为null，通过");

        q1.setTitle("");
        Assertions.assertEquals(
                controller.add(q1).getCode(), 0);
        log.info("Quesnaire模块>>添加请求测试3：工程名为空字符串，通过");

        log.info("Quesnaire模块>>添加请求测试通过");
    }

    @Test
    void queryById() {
        var q = new Quesnaire();
        q.setId("test");
        Assertions.assertNotNull(controller.queryById(q),
                "Quesnaire模块>>单个请求测试1：存在的ID，未通过");
        log.info("Quesnaire模块>>单个请求测试1：存在的ID，通过");

        var q1 = new Quesnaire();
        q1.setId(null);

        q1.setId("");


    }

    @Test
    void queryByProject() {
        var req = new QuesnaireListRequest();
        req.setStart(0);
        req.setLimit(0);

        var proReq = new ProjectListRequest();
        proReq.setLimit(0);
        proReq.setStart(0);
        var projectList = projectService.selectAll(proReq).getData();
        var project = ((ArrayList<Project>) projectList).get(0);

        req.setProject(project.getId());//已存在
        Assertions.assertNotNull(controller.queryByProject(req)
                        .getData()
                , "Quesnaire模块>>列表请求测试1：返回已存在的问卷，未通过");
        log.info("Quesnaire模块>>列表请求测试1：返回已存在的问卷，通过");

    }


    @Test
    @Order(3)
    void modify() {
        var q = new Quesnaire();
        q.setId("test");
        q.setTitle("guagua");
        Assertions.assertEquals(
                controller.modify(q).getCode(), 1);
        log.info("Quesnaire模块>>更新请求测试5：正常情况，通过");

        q.setId(null);
        q.setTitle(null);
        Assertions.assertEquals(
                controller.modify(q).getCode(), 0);
        log.info("Quesnaire模块>>更新请求测试6：Id和所修改字段新值均为null，通过");

        q.setId("");
        q.setTitle(null);
        Assertions.assertEquals(
                controller.modify(q).getCode(), 0);
        log.info("Quesnaire模块>>更新请求测试7：Id为空串，所修改字段新值为null，通过");

        q.setId("114514");
        q.setTitle(null);
        Assertions.assertEquals(
                controller.modify(q).getCode(), 0);
        log.info("Quesnaire模块>>更新请求测试8：不存在的Id，通过");

        log.info("Quesnaire模块>>更新请求测试通过");
    }

    @Test
    @Order(4)
    void del() {
        var q = new Quesnaire();
        q.setId(null);
        Assertions.assertEquals(
                controller.deleteById(q).getCode(), 0);
        log.info("Quesnaire模块>>删除请求测试1：Id为null，通过");

        q.setId("test");
        Assertions.assertEquals(
                controller.deleteById(q).getCode(), 1);
        log.info("Quesnaire模块>>删除请求测试2：正常情况，通过");

        q.setId("iiiiiiiiiiiiiiiiiiiiiiiii");
        q = (Quesnaire) controller.queryById(q).getData();
        Assertions.assertEquals(
                controller.deleteById(q).getCode(), 0);
        log.info("Quesnaire模块>>删除请求测试3：不存在的Id，通过");

        log.info("Quesnaire模块>>删除请求测试通过");
    }
}
