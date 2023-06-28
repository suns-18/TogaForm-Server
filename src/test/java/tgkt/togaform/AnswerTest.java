package tgkt.togaform;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import tgkt.togaform.controller.AnswerController;
import tgkt.togaform.entity.Answer;
import tgkt.togaform.request.AnswerListRequest;
import tgkt.togaform.service.AnswerService;
import java.util.List;


@SpringBootTest
@Component
public class AnswerTest {
    @Autowired
    AnswerController controller;
    @Autowired
    AnswerService service;
    Logger log = Logger.getLogger(AnswerTest.class);
    @Test
    void query() {
        var a = new AnswerListRequest();
        a.setUserId("admin");
        Assertions.assertFalse(((List<Answer>)
                        (controller.queryByUser(a)
                                .getData()))
                        .isEmpty()
                , "Answer模块>>列表请求测试1：根据用户ID查询，未通过");
        log.info("Answer模块>>列表请求测试1：根据用户ID查询，通过");
        a.setQuesnaire("nihao");
        Assertions.assertFalse(((List<Answer>)
                        (controller.queryByProject(a)
                                .getData()))
                        .isEmpty()
                , "Answer模块>>列表请求测试1：根据问卷查询，未通过");
        log.info("Answer模块>>列表请求测试1：根据问卷查询，通过");
        a.setId("guagua");
        Assertions.assertFalse(((List<Answer>)
                        (controller.queryById(a)
                                .getData()))
                        .isEmpty()
                , "Answer模块>>列表请求测试1：根据ID查询，未通过");
        log.info("Answer模块>>列表请求测试1：根据ID查询，通过");
        a.setId(null);
        Assertions.assertTrue(((List<Answer>)
                        (controller.queryById(a)
                                .getData()))
                        .isEmpty()
                , "Answer模块>>列表请求测试2：查询到ID为null，未通过");
        log.info("Answer模块>>列表请求测试2：未查询到ID为null，通过");

        log.info("Answer模块>>列表请求测试通过");
    }
   
    @Test
    void add() {
        var a = new Answer();
        a.setQuesnaire("test1");
        Assertions.assertEquals(
                controller.add(a).getCode(), "1");
        log.info("Answer模块>>添加请求测试1：正常情况，通过");

        a.setQuesnaire(null);
        Assertions.assertEquals(
                controller.add(a).getCode(), "0");
        log.info("Answer模块>>添加请求测试2：问卷名为null，通过");

        a.setQuesnaire("");
        Assertions.assertEquals(
                controller.add(a).getCode(), "0");
        log.info("Answer模块>>添加请求测试3：问卷名为空字符串，通过");

        log.info("Answer模块>>添加请求测试通过");
    }
    @Test
    void modify() {
        var a = new AnswerListRequest();
        a = (AnswerListRequest) ((List<?>) (controller.queryById(a).getData()));
        a.setId("123");
        Assertions.assertEquals(
                controller.modify(a).getCode(), "1");
        log.info("Answer模块>>更新请求测试1：正常情况，通过");

        a.setId(null);
        a.setQuesnaire(null);
        Assertions.assertEquals(
                controller.modify(a).getCode(), "0");
        log.info("Answer模块>>更新请求测试2：Id和所修改字段新值均为null，通过");

        a.setId("");
        a.setQuesnaire(null);
        Assertions.assertEquals(
                controller.modify(a).getCode(), "0");
        log.info("Answer模块>>更新请求测试3：Id为空串，所修改字段新值为null，通过");

        a.setId("114514");
        a.setQuesnaire(null);
        Assertions.assertEquals(
                controller.modify(a).getCode(), "0");
        log.info("Answer模块>>更新请求测试4：不存在的Id，通过");

        log.info("Answer模块>>更新请求测试通过");
    }

    @Test
    void del() {
        var a = new AnswerListRequest();
        a.setId(null);
        Assertions.assertEquals(
                controller.deleteById(a).getCode(), "0");
        log.info("Answer模块>>删除请求测试1：Id为null，通过");

        a.setQuesnaire("test");
        a = ((List<AnswerListRequest>) controller.queryByProject(a).getData()).get(0);
        Assertions.assertEquals(
                controller.deleteById(a).getCode(), "1");
        log.info("Answer模块>>删除请求测试2：正常情况，通过");

        a.setId("oooooooooooooooooooooooooooooooo");
        Assertions.assertEquals(
                controller.deleteById(a).getCode(), "0");
        log.info("Answer模块>>删除请求测试3：不存在的Id，通过");

        log.info("Answer模块>>删除请求测试通过");
    }
}
