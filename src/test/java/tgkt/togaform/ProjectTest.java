package tgkt.togaform;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tgkt.togaform.controller.ProjectController;
import tgkt.togaform.entity.Project;
import tgkt.togaform.request.ProjectListRequest;
import tgkt.togaform.response.ProjectQuesnaireResponse;
import tgkt.togaform.service.ProjectService;
import java.util.List;

@SpringBootTest
class ProjectTest {
    @Autowired
    ProjectController controller;
    @Autowired
    ProjectService service;
    Logger log = Logger.getLogger(ProjectTest.class);

    @Test
    void add() {
        var p = new Project();
        p.setProjectName("test1");
        Assertions.assertEquals(
                controller.add(p).getCode(), 1);
        log.info("Project模块>>添加请求测试1：正常情况，通过");

        p.setProjectName(null);
        Assertions.assertEquals(
                controller.add(p).getCode(), 0);
        log.info("Project模块>>添加请求测试2：工程名为null，通过");

        p.setProjectName("");
        Assertions.assertEquals(
                controller.add(p).getCode(), 0);
        log.info("Project模块>>添加请求测试3：工程名为空字符串，通过");

        log.info("Project模块>>添加请求测试通过");
    }

    @Test
    void modify() {
        var p = new Project();
        p.setId("65cd96b1f3b37f261524509cdf8fa58c");
        p.setProjectName("guagua");
        Assertions.assertEquals(
                controller.modify(p).getCode(), 1);
        log.info("Project模块>>更新请求测试1：正常情况，通过");

        p.setId(null);
        p.setProjectName(null);
        Assertions.assertEquals(
                controller.modify(p).getCode(), 0);
        log.info("Project模块>>更新请求测试2：Id和所修改字段新值均为null，通过");

        p.setId("");
        p.setProjectName(null);
        Assertions.assertEquals(
                controller.modify(p).getCode(), 0);
        log.info("Project模块>>更新请求测试3：Id为空串，所修改字段新值为null，通过");

        p.setId("114514");
        p.setProjectName("niaho");
        Assertions.assertEquals(
                controller.modify(p).getCode(), 0);
        log.info("Project模块>>更新请求测试4：不存在的Id，通过");

        log.info("Project模块>>更新请求测试通过");
    }

    @Test
    void del() {
        var p = new Project();

        p.setId(null);
        Assertions.assertEquals(
                controller.deleteById(p).getCode(), 0);
        log.info("Project模块>>删除请求测试1：Id为null，通过");
        var pr = new ProjectListRequest();
        pr.setStart(1);
        pr.setLimit(10);
        var dataList = (List<ProjectQuesnaireResponse>)
                controller.queryList(pr)
                        .getData();

        p.setId(dataList
                .get(0)
                .getProject()
                .getId());

        p.setProjectName("test");
        Assertions.assertEquals(
                controller.deleteById(p).getCode(), 1);
        log.info("Project模块>>删除请求测试2：正常情况，通过");

        p.setId("oooooooooooooooooooooooooooooooo");
        Assertions.assertEquals(
                controller.deleteById(p).getCode(), 0);
        log.info("Project模块>>删除请求测试3：不存在的Id，通过");

        log.info("Project模块>>删除请求测试通过");
    }

    @Test
    void queryList() {
        var p = new ProjectListRequest();

        Assertions.assertFalse(((List<ProjectQuesnaireResponse>)
                        (controller.queryList(p)
                                .getData()))
                        .isEmpty()
                , "Project模块>>列表请求测试1：返回所有，未通过");
        log.info("Project模块>>列表请求测试1：返回所有，通过");

        p.setId(null);
        p.setProjectName("g");
        Assertions.assertFalse(((List<ProjectQuesnaireResponse>)
                        (controller.queryList(p)
                                .getData()))
                        .isEmpty()
                , "Project模块>>列表请求测试2：根据工程名模糊查询，未通过");
        log.info("Project模块>>列表请求测试2：根据工程名模糊查询，通过");

        log.info("Project模块>>列表请求测试通过");
    }

    @Test
    void querySingle() {
        var p = new Project();
        p.setId(null);
        Assertions.assertEquals(
                controller.queryById(p).getCode(), 0);
        log.info("Project模块>>单个请求测试1：无法查询为null的Id，通过");

        p.setId("3697c089e44f7f29cc42566e5a9a38ce");
        Assertions.assertEquals(
                controller.queryById(p).getCode(), 1);
        log.info("Project模块>>单个请求测试2：存在的Id，通过");

        log.info("Project模块>>单个请求测试通过");
    }
}
