package tgkt.togaform;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import tgkt.togaform.controller.QuesnaireController;
import tgkt.togaform.entity.Quesnaire;
import tgkt.togaform.request.QuesnaireListRequest;
import tgkt.togaform.response.HttpResponse;
import tgkt.togaform.service.QuestionService;

import java.util.List;


@SpringBootTest
@Component
public class QuesnaierTest {
    @Autowired
    QuesnaireController controller;
    @Autowired
    QuestionService service;
    Logger log = Logger.getLogger(QuesnaierTest.class);
    @Test
    void add() {
        var q = new Quesnaire();
        q.setTitle("test1");
        Assertions.assertEquals(
                controller.add(q).getCode(), 1);
        log.info("Quesnaire模块>>添加请求测试1：正常情况，通过");

        q.setTitle(null);
        Assertions.assertEquals(
                controller.add(q).getCode(), 0);
        log.info("Quesnaire模块>>添加请求测试2：问卷标题为null，通过");

        q.setTitle("");
        Assertions.assertEquals(
                controller.add(q).getCode(), 0);
        log.info("Quesnaire模块>>添加请求测试3：工程名为空字符串，通过");

        log.info("Quesnaire模块>>添加请求测试通过");
    }
    @Test
    void query() {
        var q = new QuesnaireListRequest();
        q.setId("649c2e46f23580075031f883");//已存在
        Assertions.assertFalse(((List<QuesnaireListRequest>)
                        (controller.queryById(q)
                                .getData()))
                        .isEmpty()
                , "Quesnaire模块>>列表请求测试1：无法返回已存在的问卷，未通过");
        log.info("Quesnaire模块>>列表请求测试1：返回已存在的问卷，通过");

        q.setId(null);
        Assertions.assertTrue(((List<QuesnaireListRequest>)
                        (controller.queryById(q)
                                .getData()))
                        .isEmpty()
                , "Quesnaire模块>>列表请求测试2：查询到ID为null，未通过");
        log.info("Quesnaire模块>>列表请求测试2：无法查询到ID为null，通过");

        q.setProject("guagua");//已存在
        Assertions.assertFalse(((List<QuesnaireListRequest>)
                        (controller.queryByProject(q)
                                .getData()))
                        .isEmpty()
                , "Quesnaire模块>>列表请求测试3：无法返回项目已存在的问卷，未通过");
        log.info("Quesnaire模块>>列表请求测试3：返回项目已存在的问卷，通过");

        q.setProject(null);//已存在
        Assertions.assertTrue(((List<QuesnaireListRequest>)
                        (controller.queryByProject(q)
                                .getData()))
                        .isEmpty()
                , "Quesnaire模块>>列表请求测试4：查询到工程为null，未通过");
        log.info("Quesnaire模块>>列表请求测试4：无法查询到工程为null，通过");
        log.info("Quesnaire模块>>列表请求测试通过");
    }


    @Test
    void modify() {
        var q = new QuesnaireListRequest();
        q.setProject("007");//已存在
        var qList = controller.queryByProject(q).getData();

        q.setTitle("guaguanihao");
        Assertions.assertEquals(
                controller.modify(q).getCode(), 1);
        log.info("Quesnaire模块>>更新请求测试1：正常情况，通过");

        q.setProject(null);
        q.setTitle(null);
        Assertions.assertEquals(
                controller.modify(q).getCode(), 0);
        log.info("Quesnaire模块>>更新请求测试2：无法修改工程Id和所修改字段新值均为null的情况，通过");

        q.setProject("");
        q.setTitle(null);
        Assertions.assertEquals(
                controller.modify(q).getCode(), 0);
        log.info("Quesnaire模块>>更新请求测试3：无法修改工程Id为空串，所修改字段新值为null的情况，通过");

        q.setProject("114514");
        q.setTitle("guaguaniaho");
        Assertions.assertEquals(
                controller.modify(q).getCode(), 0);
        log.info("Quesnaire模块>>更新请求测试4：无法修改不存在的工程Id，通过");

        q.setId("111");//已存在
        q = (QuesnaireListRequest) ((List<?>) (controller.queryById(q).getData())).get(0);
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
    void del() {
        var q = new QuesnaireListRequest();
        q.setId(null);
        Assertions.assertEquals(
                controller.deleteById(q).getCode(), 0);
        log.info("Quesnaire模块>>删除请求测试1：Id为null，通过");

        q.setId("111");
        q = ((List<QuesnaireListRequest>) controller.queryById(q).getData()).get(0);
        Assertions.assertEquals(
                controller.deleteById(q).getCode(), 1);
        log.info("Quesnaire模块>>删除请求测试2：正常情况，通过");

        q.setId("oooooooooooooooooooooooooooooooo");
        Assertions.assertEquals(
                controller.deleteById(q).getCode(), 0);
        log.info("Quesnaire模块>>删除请求测试3：不存在的Id，通过");

        log.info("Quesnaire模块>>删除请求测试通过");
    }
}
