package tgkt.togaform;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import tgkt.togaform.controller.TemplateController;
import tgkt.togaform.entity.Template;
import tgkt.togaform.request.TemplateListRequest;
import tgkt.togaform.service.TemplateService;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
@Component
public class TemplateTest {
    @Autowired
    TemplateController controller;
    @Autowired
    TemplateService service;
    Logger log = Logger.getLogger(TemplateTest.class);


    @Test
    void add() {
        var t = new Template();
        t.setTitle("test1");
        Assertions.assertEquals(
                controller.add(t).getCode(), 1);
        log.info("Template模块>>添加请求测试1：正常情况，通过");

        t.setTitle(null);
        Assertions.assertEquals(
                controller.add(t).getCode(), 0);
        log.info("Template模块>>添加请求测试2：模版名为null，通过");

        t.setTitle("");
        Assertions.assertEquals(
                controller.add(t).getCode(), 0);
        log.info("Template模块>>添加请求测试3：模版名为空字符串，通过");

        log.info("Template模块>>添加请求测试通过");
    }

    @Test
    void modify() {
        var t = new Template();
        t.setId("649c0fcb6ed0f56153f575f4");
        t.setTitle("guagua");
        Assertions.assertEquals(
                controller.modify(t).getCode(), 1);
        log.info("Template模块>>更新请求测试1：正常情况，通过");

        t.setId(null);
        t.setTitle(null);
        Assertions.assertEquals(
                controller.modify(t).getCode(), 0);
        log.info("Template模块>>更新请求测试2：Id和所修改字段新值均为null，通过");

        t.setId("");
        t.setTitle(null);
        Assertions.assertEquals(
                controller.modify(t).getCode(), 0);
        log.info("Template模块>>更新请求测试3：Id为空串，所修改字段新值为null，通过");

        t.setId("114514");
        t.setTitle(null);
        Assertions.assertEquals(
                controller.modify(t).getCode(), 0);
        log.info("Template模块>>更新请求测试4：不存在的Id，通过");

        log.info("Template模块>>更新请求测试通过");
    }

    @Test
    void del() {
        var t = new Template();
        t.setId(null);
        Assertions.assertEquals(
                controller.deleteById(t).getCode(), 0);
        log.info("Template模块>>删除请求测试1：Id为null，通过");
//        t.setId("649c10917337265281718808");
//        Assertions.assertEquals(
//                controller.deleteById(t).getCode(), 1);
//        log.info("Template模块>>删除请求测试2：正常情况，通过");

        t.setId("oooooooooooooooooooooooooooooooo");
        Assertions.assertEquals(
                controller.deleteById(t).getCode(), 0);
        log.info("Template模块>>删除请求测试3：不存在的Id，通过");

        log.info("Template模块>>删除请求测试通过");
    }

    @Test
    void queryList() {
        var t = new TemplateListRequest();
        t.setPage(1);
        t.setSize(10);
        var data = controller.queryList(t)
                .getData();
        var dataList = new ArrayList<>();
        dataList.addAll((List<Template>)data);
        Assertions.assertEquals(dataList
                .isEmpty(), false, "Template模块>>列表请求测试1：返回所有，未通过");
        log.info("Template模块>>列表请求测试1：返回所有，通过");

        t.setTitle("g");
        Assertions.assertEquals(((List<Template>)
                (controller.queryList(t)
                        .getData()))
                .isEmpty(), false, "Template模块>>列表请求测试2：根据模版名模糊查询，未通过");
        log.info("Template模块>>列表请求测试2：根据模版名模糊查询，通过");

        log.info("Template模块>>列表请求测试通过");
    }

    @Test
    void querySingle() {
        var t = new Template();
        t.setId("11111111111");
        Assertions.assertEquals(
                controller.queryById(t).getCode(), 0);
        log.info("Template模块>>单个请求测试1：不存在的Id，通过");

        t.setId("649c17052c35593382cb0d8e");
        Assertions.assertEquals(
                controller.queryById(t).getCode(), 1);
        log.info("Template模块>>单个请求测试2：存在的Id，通过");

        log.info("Template模块>>单个请求测试通过");
    }
}
