package tgkt.togaform;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import tgkt.togaform.controller.QuestionController;
import tgkt.togaform.entity.Question;
import tgkt.togaform.request.QuestionListRequest;
import tgkt.togaform.service.QuestionService;

import java.util.List;


@SpringBootTest
@Component
public class QuestionTest {
    @Autowired
    QuestionController controller;
    @Autowired
    QuestionService service;
    Logger log = Logger.getLogger(QuestionTest.class);


    @Test
    void add() {
        var q = new Question();
        q.setTitle("test1");
        Assertions.assertEquals(
                controller.add(q).getCode(), 1);
        log.info("Question模块>>添加请求测试1：正常情况，通过");

        q.setTitle(null);
        Assertions.assertEquals(
                controller.add(q).getCode(), 0);
        log.info("Question模块>>添加请求测试2：问题名为null，通过");

        q.setTitle("");
        Assertions.assertEquals(
                controller.add(q).getCode(), 0);
        log.info("Question模块>>添加请求测试3：问题名为空字符串，通过");

        log.info("Question模块>>添加请求测试通过");
    }
    @Test
    void modify() {
        var q = new Question();
        
        q.setId("007");//已存在
        q.setTitle("guagua你好aaaaa");
        Assertions.assertEquals(
                controller.modify(q).getCode(), 1);
        log.info("Question模块>>更新请求测试1：正常情况，通过");

        q.setId(null);
        q.setTitle(null);
        Assertions.assertEquals(
                controller.modify(q).getCode(), 0);
        log.info("Question模块>>更新请求测试2：Id和所修改字段新值均为null，通过");

        q.setId("");
        q.setTitle(null);
        Assertions.assertEquals(
                controller.modify(q).getCode(), 0);
        log.info("Question模块>>更新请求测试3：Id为空串，所修改字段新值为null，通过");

        q.setId("114514");
        q.setTitle(null);
        Assertions.assertEquals(
                controller.modify(q).getCode(), 0);
        log.info("Question模块>>更新请求测试4：不存在的Id，通过");

        log.info("Question模块>>更新请求测试通过");
    }

    @Test
    void del() {
        var q = new QuestionListRequest();
        q.setId(null);
        Assertions.assertEquals(
                controller.deleteById(q).getCode(), 0);
        log.info("Question模块>>删除请求测试1：Id为null，通过");

        q.setId("649c117cd2d96912a1222a48");
        Assertions.assertEquals(
                controller.deleteById(q).getCode(), 1);
        log.info("Question模块>>删除请求测试2：正常情况，通过");

        q.setId("222222222222222222222222");//不存在的ID
        Assertions.assertEquals(
                controller.deleteById(q).getCode(), 0);
        log.info("Question模块>>删除请求测试3：不存在的Id，通过");

        log.info("Question模块>>删除请求测试通过");
    }
    @Test
    void query() {
        var q = new Question();
        q.setId("649c117cd2d96912a1222a47");//已存在
        Assertions.assertEquals(
                controller.queryById(q).getCode(), 1);
        log.info("Question模块>>列表请求测试1：返回已存在的问卷，通过");

        q.setId(null);
        Assertions.assertEquals(
                controller.queryById(q).getCode(), 0);

        log.info("Question模块>>列表请求测试2：无法查询到ID为null，通过");


        log.info("Question模块>>列表请求测试通过");
    }
}
