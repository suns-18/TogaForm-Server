package tgkt.togaform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tgkt.togaform.entity.Project;
import tgkt.togaform.request.ProjectListRequest;
import tgkt.togaform.response.HttpResponse;
import tgkt.togaform.service.ProjectService;

@RestController
@RequestMapping(value = "/api/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public HttpResponse add(@RequestBody Project project) {
        HttpResponse resp;
        try {
            var result = projectService.insert(project);

            if (result != 0) {
                resp = HttpResponse.builder()
                        .code(1)
                        .message("添加成功")
                        .build();
            } else {
                resp = HttpResponse.builder()
                        .code(0)
                        .message("添加失败")
                        .build();
            }

        } catch (Exception e) {
            resp = HttpResponse.builder()
                    .code(0)
                    .message("参数错误")
                    .build();
        }
        return resp;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public HttpResponse deleteById(@RequestBody Project project) {
        HttpResponse resp;
        try {
            if (project.getId() == null) throw new RuntimeException();
            var result = projectService.deleteById(project);

            if (result != 0) {
                resp = HttpResponse.builder()
                        .code(1)
                        .message("删除成功")
                        .build();
            } else {
                resp = HttpResponse.builder()
                        .code(0)
                        .message("删除失败")
                        .build();
            }
        } catch (Exception e) {
            resp = HttpResponse.builder()
                    .code(0)
                    .message("数据库访问错误")
                    .build();
        }
        return resp;
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public HttpResponse modify(@RequestBody Project project) {
        HttpResponse resp;
        try {
            if (project.getId() == null)
                throw new RuntimeException();
            var result = projectService.update(project);

            if (result != 0) {
                resp = HttpResponse.builder()
                        .code(1)
                        .message("修改成功")
                        .build();
            } else {
                resp = HttpResponse.builder()
                        .code(0)
                        .message("修改失败")
                        .build();
            }
        } catch (Exception e) {
            resp = HttpResponse.builder()
                    .code(0)
                    .message("数据库访问错误")
                    .build();
        }
        return resp;
    }

    @RequestMapping(value = "/queryById", method = RequestMethod.POST)
    public HttpResponse queryById(@RequestBody Project project) {
        HttpResponse resp;
        try {
            var result = projectService.selectById(project);
            resp = HttpResponse.builder()
                    .code(1)
                    .message("查询成功")
                    .data(result)
                    .build();
        } catch (Exception e) {
            resp = HttpResponse.builder()
                    .code(0)
                    .message("数据库访问错误")
                    .build();
        }
        return resp;
    }

    @RequestMapping(value = "/queryList", method = RequestMethod.POST)
    public HttpResponse queryList(@RequestBody ProjectListRequest req) {
        HttpResponse resp;
        try {
            resp = projectService.selectAllExtended(req);
            resp.setCode(1);
            resp.setMessage("查询成功");
        } catch (Exception e) {
            e.printStackTrace();
            resp = HttpResponse.builder()
                    .code(0)
                    .message("数据库访问错误")
                    .build();
        }
        return resp;
    }
}
