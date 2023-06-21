package tgkt.togaform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tgkt.togaform.entity.Quesnaire;
import tgkt.togaform.response.HttpResponse;
import tgkt.togaform.response.ListResponse;
import tgkt.togaform.service.QuesnaireService;

@RestController
@RequestMapping("/api/quesnaire")
public class QuesnaireController {
    @Autowired
    private QuesnaireService service;

    @RequestMapping(value = "/add",
            method = RequestMethod.POST)
    public HttpResponse add(@RequestBody Quesnaire q) {
        HttpResponse resp;
        try {
            var result = service.insert(q);
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

    @RequestMapping(value = "/del",
            method = RequestMethod.POST)
    public HttpResponse deleteById(@RequestBody Quesnaire q) {
        HttpResponse resp;
        try {
            var result = service.delete(q);
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

    @RequestMapping(value = "/modify",
            method = RequestMethod.POST)
    public HttpResponse modify(@RequestBody Quesnaire q) {
        HttpResponse resp;
        try {
            var result = service.update(q);
            if (result == 0) {
                resp = HttpResponse.builder()
                        .code(0)
                        .message("修改失败")
                        .build();
            }

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

    @RequestMapping(value = "/queryById",
            method = RequestMethod.POST)
    public HttpResponse queryById(@RequestBody Quesnaire q) {
        HttpResponse resp;
        try {
            var result = service.selectById(q);
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

    @RequestMapping(value = "/queryByProject",
            method = RequestMethod.POST)
    public HttpResponse queryByProject(@RequestBody Quesnaire q) {
        HttpResponse resp;

        try {
            var result = service.selectByProject(q);
            if (result == null)
                resp = ListResponse.builder()
                        .code(1)
                        .message("列表为空")
                        .build();
            else
                resp = ListResponse.builder()
                        .code(1)
                        .data(result)
                        .message("查询成功")
                        .currentPage(0)
                        .totalPage(0)
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
