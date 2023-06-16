package tgkt.togaform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tgkt.togaform.entity.ProjectInfo;
import tgkt.togaform.response.HttpResponse;
import tgkt.togaform.service.ProjectService;

@RestController
@RequestMapping(value = "/api/project")
public class ProjectController {
	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public HttpResponse queryList(@RequestBody ProjectInfo projectInfo) {
		HttpResponse resp = new HttpResponse();
		try {

			var result = projectService.queryList(projectInfo);
/*
			resp = HttpResponse.builder()
				.code("1")
				.data(result)
				.message("ok")
				.build();*/
			resp.setCode("1");
			resp.setData(result);
			resp.setMessage("ok");
		} catch (Exception e) {
			/*
			e.printStackTrace();
			resp = HttpResponse.builder()
				.code("0")
				.message("请求错误")
				.build();*/
			resp.setCode("0");
			resp.setMessage("请求错误");
		}

		return resp;
	}

	@RequestMapping(value = "/addProject", method = RequestMethod.POST)
	public HttpResponse addProject(@RequestBody ProjectInfo projectInfo) {
		HttpResponse resp = new HttpResponse();
		try {
			var result = projectService.insert(projectInfo);

			if (result != 0) {
				resp.setCode("1");
				resp.setMessage("添加成功");
			} else {
				resp.setCode("0");
				resp.setMessage("添加失败");
			}

		} catch (Exception e) {
			resp.setCode("0");
			resp.setMessage("请求错误");
		}
		return resp;
	}

	@RequestMapping(value = "/updateProject", method = RequestMethod.POST)
	public HttpResponse updateUser(@RequestBody ProjectInfo projectInfo) {
		HttpResponse resp = new HttpResponse();
		try {
			if (projectInfo.getId() == null) throw new RuntimeException();
			var result = projectService.update(projectInfo);

			if (result != 0) {
				resp.setCode("1");
				resp.setMessage("修改成功");
			}/*
				resp = HttpResponse.builder()
					.code("1")
					.message("修改成功")
					.build();*/ else {
				resp.setCode("0");
				resp.setMessage("修改失败");
			}/*
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

	@RequestMapping(value = "/deleteProject", method = RequestMethod.POST)
	public HttpResponse deleteUserById(@RequestBody ProjectInfo projectInfo) {
		HttpResponse resp = new HttpResponse();
		try {
			if (projectInfo.getId() == null) throw new RuntimeException();
			var result = projectService.deleteById(projectInfo);

			if (result != 0) {
				resp.setCode("1");
				resp.setMessage("删除成功");
			}/*
				resp = HttpResponse.builder()
					.code("1")
					.message("删除成功")
					.build();*/ else {
				resp.setCode("0");
				resp.setMessage("删除失败");
			}/*
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
}
