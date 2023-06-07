package tgkt.togaform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tgkt.togaform.entity.User;
import tgkt.togaform.service.UserService;
import tgkt.togaform.response.HttpResponse;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public HttpResponse userLogin(@RequestBody User user) {
        HttpResponse resp;
        try {
            var result = userService.verify(user);

            if (result.isEmpty()) {
                resp = HttpResponse.builder()
                        .code("0")
                        .message("登陆失败，用户名或密码错误")
                        .build();
            } else {
                resp = HttpResponse.builder()
                        .code("1")
                        .data(result.get(0))
                        .message("登陆成功")
                        .build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp = HttpResponse.builder()
                    .code("0")
                    .message("请求错误")
                    .build();
        }

        return resp;
    }

    @RequestMapping(value = "/queryList", method = RequestMethod.GET)
    public HttpResponse queryUserList(User user) {
        HttpResponse resp;
        try {
            var result = userService.queryList(user);

            if (result.isEmpty()) {
                resp = HttpResponse.builder()
                        .code("1")
                        .message("列表为空")
                        .build();
            } else {
                resp = HttpResponse.builder()
                        .code("1")
                        .data(result)
                        .message("查询成功")
                        .build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp = HttpResponse.builder()
                    .code("0")
                    .message("请求错误")
                    .build();
        }

        return resp;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public HttpResponse addUser(@RequestBody User user) {
        HttpResponse resp;
        try {
            var result = userService.add(user);

            if (result != 0)
                resp = HttpResponse.builder()
                        .code("1")
                        .message("添加成功")
                        .build();
            else
                resp = HttpResponse.builder()
                        .code("0")
                        .message("添加失败")
                        .build();

        } catch (Exception e) {
            e.printStackTrace();
            resp = HttpResponse.builder()
                    .code("0")
                    .message("添加请求错误")
                    .build();
        }
        return resp;
    }

    @RequestMapping(value = "/modifyUser", method = RequestMethod.POST)
    public HttpResponse modifyUser(@RequestBody User user) {
        HttpResponse resp;
        try {
            var result = userService.modify(user);

            if (result != 0)
                resp = HttpResponse.builder()
                        .code("1")
                        .message("修改成功")
                        .build();
            else
                resp = HttpResponse.builder()
                        .code("0")
                        .message("修改失败")
                        .build();

        } catch (Exception e) {
            e.printStackTrace();
            resp = HttpResponse.builder()
                    .code("0")
                    .message("请求错误")
                    .build();
        }
        return resp;
    }
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    public HttpResponse deleteUserById(@RequestBody User user) {
        HttpResponse resp;
        try {
            var result = userService.removeById(user);

            if (result != 0)
                resp = HttpResponse.builder()
                        .code("1")
                        .message("删除成功")
                        .build();
            else
                resp = HttpResponse.builder()
                        .code("0")
                        .message("删除失败")
                        .build();

        } catch (Exception e) {
            resp = HttpResponse.builder()
                    .code("0")
                    .message("请求错误")
                    .build();
        }
        return resp;
    }
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public HttpResponse userLogout(){
        return HttpResponse.builder().code("1").message("ok").data("ok").build();
    }
}
