package tgkt.togaform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tgkt.togaform.entity.User;
import tgkt.togaform.service.UserService;
import tgkt.togaform.response.HttpResponse;
import tgkt.togaform.util.UUIDUtil;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public HttpResponse userLogin(@RequestBody User user) {
        //HttpResponse resp;
        HttpResponse resp = new HttpResponse();
        try {
            if(user.getUsername()==null) throw new Exception();
            var result = userService.verify(user);

            if (result.isEmpty()) {/*
                resp = HttpResponse.builder()
                        .code("0")
                        .message("登陆失败，用户名或密码错误")
                        .build();*/
                resp.setCode("0");
                resp.setMessage("登陆失败，用户名或密码错误");
            } else {
                /*
                resp = HttpResponse.builder()
                        .code("1")
                        .data(result.get(0))
                        .message("登陆成功")
                        .build();*/
                resp.setCode("0");
                resp.setMessage("登陆成功");
            }
        } catch (Exception e) {
            /*
            resp = HttpResponse.builder()
                    .code("0")
                    .message("请求错误")
                    .build();*/
            resp.setCode("0");
            resp.setMessage("请求错误");
        }

        return resp;
    }

    @RequestMapping(value = "/queryList", method = RequestMethod.POST)
    public HttpResponse queryUserList(@RequestBody User user) {
        HttpResponse resp = new HttpResponse();
        try {
            if (user==null) throw new Exception();
            var result = userService.queryList(user);
            resp.setData(result);
            if (result.isEmpty()) {
                /*
                resp = HttpResponse.builder()
                        .code("1")
                        .message("列表为空")
                        .build();*/
                resp.setCode("1");
                resp.setMessage("列表为空");
            } else {
                /*
                resp = HttpResponse.builder()
                        .code("1")
                        .data(result)
                        .message("查询成功")
                        .build();*/
                resp.setCode("1");
                resp.setMessage("查询成功");
            }
        } catch (Exception e) {
            /*
            resp = HttpResponse.builder()
                    .code("0")
                    .message("请求错误")
                    .build();*/
            resp.setCode("0");
            resp.setMessage("请求错误");

        }

        return resp;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public HttpResponse addUser(@RequestBody User user) {
        HttpResponse resp = new HttpResponse();
        try {
            if(user.getId()==null) throw new Exception();
            var result = userService.insert(user);

            if (result != 0){
                /*
                resp = HttpResponse.builder()
                        .code("1")
                        .message("添加成功")
                        .build();*/
                resp.setCode("1");
                resp.setMessage("添加成功");
            }
            else{
                /*
                resp = HttpResponse.builder()
                        .code("0")
                        .message("添加失败")
                        .build();*/

                resp.setCode("0");
                resp.setMessage("添加失败");
            }

        } catch (Exception e) {
            /*
            resp = HttpResponse.builder()
                    .code("0")
                    .message("添加请求错误")
                    .build();*/
            resp.setCode("0");
            resp.setMessage("添加请求错误");
        }
        return resp;
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public HttpResponse updateUser(@RequestBody User user) {
        HttpResponse resp = new HttpResponse();
        try {
            if(user.getId()==null) throw new Exception();
            var result = userService.modify(user);

            if (result != 0){
                resp.setCode("1");
                resp.setMessage("修改成功");
            }
                /*
                resp = HttpResponse.builder()
                        .code("1")
                        .message("修改成功")
                        .build();*/

            else{
                resp.setCode("0");
                resp.setMessage("修改失败");
            }
                /*
                resp = HttpResponse.builder()
                        .code("0")
                        .message("修改失败")
                        .build();*/

        } catch (Exception e) {
            /*
            resp = HttpResponse.builder()
                    .code("0")
                    .message("请求错误")
                    .build();*/
            resp.setCode("0");
            resp.setMessage("请求错误");
        }
        return resp;
    }
    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public HttpResponse deleteUserById(@RequestBody User user) {
        HttpResponse resp = new HttpResponse();
        try {
            if(user.getId()==null) throw new Exception();
            var result = userService.deleteById(user);

            if (result != 0){
                resp.setCode("1");
                resp.setMessage("删除成功");
            }
            /*
                resp = HttpResponse.builder()
                        .code("1")
                        .message("删除成功")
                        .build();*/
            else{
                resp.setCode("1");
                resp.setMessage("删除失败");
            }
            /*
                resp = HttpResponse.builder()
                        .code("0")
                        .message("删除失败")
                        .build();*/

        } catch (Exception e) {/*
            resp = HttpResponse.builder()
                    .code("0")
                    .message("请求错误")
                    .build();*/
            resp.setCode("0");
            resp.setMessage("请求错误");
        }
        return resp;
    }
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public HttpResponse userLogout(){
        var resp = new HttpResponse();
        resp.setCode("1");
        return resp;
        //return HttpResponse.builder().code("1").message("ok").data("ok").build();
    }
}
