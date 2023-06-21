package tgkt.togaform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tgkt.togaform.entity.User;
import tgkt.togaform.request.UserListRequest;
import tgkt.togaform.service.UserService;
import tgkt.togaform.response.HttpResponse;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public HttpResponse add(@RequestBody User user) {
        HttpResponse resp;
        try {
            var result = userService.insert(user);
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
                    .message("数据库访问错误")
                    .data(e.getMessage())
                    .build();
        }
        return resp;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public HttpResponse deleteById(@RequestBody User user) {
        HttpResponse resp;
        try {
            var result = userService.deleteById(user);

            if (result != 0)
                resp = HttpResponse.builder()
                        .code(1)
                        .message("删除成功")
                        .build();
            else
                resp = HttpResponse.builder()
                        .code(0)
                        .message("删除失败")
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

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public HttpResponse modify(@RequestBody User user) {
        HttpResponse resp;
        try {
            var result = userService.update(user);

            if (result != 0)
                resp = HttpResponse.builder()
                        .code(1)
                        .message("修改成功")
                        .build();
            else
                resp = HttpResponse.builder()
                        .code(0)
                        .message("修改失败")
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

    @RequestMapping(value = "/queryList", method = RequestMethod.POST)
    public HttpResponse queryList(@RequestBody UserListRequest req) {
        HttpResponse resp;
        try {
            resp = userService.selectAll(req);
            resp.setCode(1);
            resp.setMessage("查询成功");

        } catch (Exception e) {
            e.printStackTrace();
            resp = HttpResponse.builder()
                    .code(0)
                    .message("数据库访问错误")
                    .data(e.getStackTrace())
                    .build();
        }
        return resp;
    }

    @RequestMapping(value = "/queryById", method = RequestMethod.POST)
    public HttpResponse queryById(@RequestBody UserListRequest req) {
        HttpResponse resp;
        try {
            var result = userService.selectAll(req);
            var list = (List<User>) result.getData();
            if (list.isEmpty()) {
                resp = HttpResponse.builder()
                        .code(1)
                        .message("查询不到该用户")
                        .build();
            } else {
                resp = HttpResponse.builder()
                        .code(1)
                        .data(result)
                        .message("查询成功")
                        .build();
            }
        } catch (Exception e) {
            resp = HttpResponse.builder()
                    .code(0)
                    .message("数据库访问错误")
                    .data(e.getMessage())
                    .build();

        }

        return resp;
    }

    @PostMapping(value = "/login")
    public HttpResponse login(@RequestBody User user) {
        //HttpResponse resp;
        HttpResponse resp;
        try {
            if (user.getUsername() == null) throw new Exception();
            var result = userService.verify(user);

            if (result == null) {
                resp = HttpResponse.builder()
                        .code(0)
                        .message("登陆失败，用户名或密码错误")
                        .build();
            } else {
                resp = HttpResponse.builder()
                        .code(1)
                        .data(result)
                        .message("登陆成功")
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

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public HttpResponse userLogout() {
        return HttpResponse.builder()
                .code(1)
                .message("ok")
                .data("ok")
                .build();
    }
}
