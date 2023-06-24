package tgkt.togaform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tgkt.togaform.entity.Template;
import tgkt.togaform.response.HttpResponse;
import tgkt.togaform.service.TemplateService;

@RestController
@RequestMapping("/api/template")
public class TemplateController {
    @Autowired
    private TemplateService service;
    @PostMapping(value = "/add")
    public HttpResponse add(@RequestBody Template t) {
        HttpResponse resp;
        try {
            var result = service.insert(t);
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
    public HttpResponse deleteById(@RequestBody Template t) {
        HttpResponse resp;
        try {
            var result = service.deleteById(t);
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
    public HttpResponse modify(@RequestBody Template t) {
        HttpResponse resp;
        try {
            var result = service.update(t);
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
    public HttpResponse queryById(@RequestBody Template t) {
        HttpResponse resp;
        try {
            var result = service.selectById(t);
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

}
