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
    public HttpResponse add(@RequestBody Quesnaire q){
        HttpResponse resp = new HttpResponse();
        try{
            var result = service.insert(q);
            if(result == 0){
                resp.setMessage("添加失败，数据访问错误");
                return resp;
            }

            resp.setCode("1");
            resp.setData(result);
            resp.setMessage("添加成功");
            return resp;
        }
        catch (Exception e){
            resp.setMessage("参数错误");
            return resp;
        }
    }

    @RequestMapping(value = "/del",
            method = RequestMethod.POST)
    public HttpResponse delete(@RequestBody Quesnaire q){
        HttpResponse resp = new HttpResponse();
        try{
            var result = service.delete(q);
            if(result == 0){
                resp.setMessage("删除失败，数据访问错误");
                return resp;
            }

            resp.setCode("1");
            resp.setData(result);
            resp.setMessage("删除成功");
            return resp;
        }
        catch (Exception e){
            resp.setMessage("参数错误");
            return resp;
        }
    }

    @RequestMapping(value = "/modify",
            method = RequestMethod.POST)
    public HttpResponse modify(@RequestBody Quesnaire q){
        HttpResponse resp = new HttpResponse();
        try{
            var result = service.update(q);
            if(result == 0){
                resp.setMessage("修改失败，数据访问错误");
                return resp;
            }

            resp.setCode("1");
            resp.setData(result);
            resp.setMessage("修改成功");
            return resp;
        }
        catch (Exception e){
            resp.setMessage("参数错误");
            return resp;
        }
    }

    @RequestMapping(value = "/queryById",
            method = RequestMethod.POST)
    public HttpResponse queryById(@RequestBody Quesnaire q){
        HttpResponse resp = new HttpResponse();
        try{
            var result = service.selectById(q);
            if(result == null){
                resp.setMessage("查询不到该问卷");
                return resp;
            }

            resp.setCode("1");
            resp.setData(result);
            resp.setMessage("查询成功");
            return resp;
        }
        catch (Exception e){
            resp.setMessage("参数错误");
            return resp;
        }
    }

    @RequestMapping(value = "/queryByProject",
            method = RequestMethod.POST)
    public ListResponse queryByProject(@RequestBody Quesnaire q){
        ListResponse resp = new ListResponse();

        try{
            var result = service.selectByProject(q);
            if(result == null){
                resp.setMessage("列表为空");
                return resp;
            }

            resp.setCode("1");
            resp.setData(result);
            resp.setMessage("查询成功");
            return resp;
        }
        catch (Exception e){
            resp.setMessage("参数错误");
            return resp;
        }
    }
}
