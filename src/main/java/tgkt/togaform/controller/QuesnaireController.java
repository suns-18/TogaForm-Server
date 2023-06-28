package tgkt.togaform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tgkt.togaform.entity.Quesnaire;
import tgkt.togaform.request.QuesnaireListRequest;
import tgkt.togaform.response.HttpResponse;
import tgkt.togaform.response.ListResponse;
import tgkt.togaform.service.QuesnaireService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/quesnaire")
public class QuesnaireController {
    @Autowired
    private QuesnaireService service;


    @PostMapping(value = "/add")
    public HttpResponse add(@RequestBody Quesnaire q) {
        HttpResponse resp;
        try {
            var result = service.insert(q);
            if (result == 0)
                resp = HttpResponse.builder()
                        .code(0)
                        .data(result)
                        .message("添加失败")
                        .build();
            else
                resp = HttpResponse.builder()
                        .code(1)
                        .data(result)
                        .message("添加成功")
                        .build();
        } catch (Exception e) {
            resp = HttpResponse.builder()
                    .code(0)
                    .message("数据库访问错误")
                    .data(e.getMessage())
                    .build();
            e.printStackTrace();
        }
        return resp;
    }

    @PostMapping(value = "/del")
    public HttpResponse deleteById(@RequestBody Quesnaire q) {
        HttpResponse resp;
        try {
            var result = service.deleteById(q);
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
    public HttpResponse modify(@RequestBody Quesnaire q) {
        HttpResponse resp;
        try {
            var result = service.update(q);
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
    public HttpResponse queryById(@RequestBody Quesnaire q) {
        HttpResponse resp;
        try {
            var result = service.selectById(q);
            if (result == null)
                resp = HttpResponse.builder()
                        .code(0)
                        .data(result)
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
                    .build();e.printStackTrace();
        }
        return resp;
    }

    @RequestMapping(value = "/queryByProject",
            method = RequestMethod.POST)
    public HttpResponse queryByProject(@RequestBody QuesnaireListRequest req) {
        HttpResponse resp;
            try {
                resp = service.selectByProject(req);
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

        @PostMapping("/queryByUser")
    public HttpResponse queryByUser(@RequestBody QuesnaireListRequest req
            , @RequestParam String userId) {
        HttpResponse resp;

        try {
            resp = service.selectByUser(req, userId);
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
