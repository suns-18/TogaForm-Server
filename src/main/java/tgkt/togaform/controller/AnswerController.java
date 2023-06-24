package tgkt.togaform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tgkt.togaform.entity.Answer;
import tgkt.togaform.entity.Quesnaire;
import tgkt.togaform.request.AnswerlistRequest;
import tgkt.togaform.request.QuesnaireListRequest;
import tgkt.togaform.response.HttpResponse;
import tgkt.togaform.service.AnswerService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/answer")
public class AnswerController {
    @Autowired
    private AnswerService service;
    @PostMapping(value = "/add")
    public HttpResponse add(@RequestBody Answer a) {
        HttpResponse resp;
        try {
            var result = service.insert(a);
            if (result == 0)
                resp = HttpResponse.builder()
                        .code(0)
                        .message("添加失败")
                        .build();
            else
                resp = HttpResponse.builder()
                        .code(1)
                        .message("添加成功")
                        .build();
        } catch (Exception e) {
            resp = HttpResponse.builder()
                    .code(0)
                    .message("数据库访问错误")
                    .data(e.getMessage())
                    .build();
        }
        return resp;
    }
    @PostMapping(value = "/del")
    public HttpResponse deleteById(@RequestBody Answer a) {
        HttpResponse resp;
        try {
            var result = service.deleteById(a);
            if (result == 0)
                resp = HttpResponse.builder()
                        .code(0)
                        .message("删除失败")
                        .build();
            else
                resp = HttpResponse.builder()
                        .code(1)
                        .message("删除成功")
                        .build();
        } catch (Exception e) {
            resp = HttpResponse.builder()
                    .code(0)
                    .message("数据库访问错误")
                    .data(e.getMessage())
                    .build();
        }
        return resp;
    }

    @PostMapping(value = "/modify")
    public HttpResponse modify(@RequestBody Answer a) {
        HttpResponse resp;
        try {
            var result = service.update(a);
            if (result == 0)
                resp = HttpResponse.builder()
                        .code(0)
                        .message("修改失败")
                        .build();
            else
                resp = HttpResponse.builder()
                        .code(1)
                        .message("修改成功")
                        .build();
        } catch (Exception e) {
            resp = HttpResponse.builder()
                    .code(0)
                    .message("数据库访问错误")
                    .data(e.getMessage())
                    .build();
        }
        return resp;
    }
    @PostMapping(value = "/queryById")
    public HttpResponse queryById(@RequestBody Answer a) {
        HttpResponse resp;
        try {
            var result = service.selectById(a);
            if (result == null)
                resp = HttpResponse.builder()
                        .code(0)
                        .message("查询不到该问卷")
                        .build();
            else
                resp = HttpResponse.builder()
                        .code(1)
                        .data(result)
                        .message("查询成功")
                        .build();
        } catch (Exception e) {
            resp = HttpResponse.builder()
                    .code(0)
                    .message("数据库访问错误")
                    .data(e.getMessage())
                    .build();
        }
        return resp;
    }
    @RequestMapping(value = "/queryByQuesnaire",
            method = RequestMethod.POST)
    public HttpResponse queryByProject(@RequestBody AnswerlistRequest req) {
        HttpResponse resp;

        try {
            resp = service.selectByQuesnaire(req);
            if (((List<Quesnaire>) (resp.getData())).isEmpty()) {
                resp.setCode(1);
                resp.setMessage("列表为空");
            } else {
                resp.setCode(1);
                resp.setMessage("查询成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp = HttpResponse.builder()
                    .code(0)
                    .message("数据库访问错误")
                    .data(e.getMessage())
                    .build();
        }
        return resp;
    }

}
