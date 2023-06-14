package tgkt.togaform;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import tgkt.togaform.controller.ProjectController;
import tgkt.togaform.entity.ProjectInfo;
import tgkt.togaform.service.ProjectService;
import tgkt.togaform.util.UUIDUtil;

@Component
//@SpringBootTest
public class UnitTestProject {
	@Autowired
	ProjectController projectController;
	@Autowired
	ProjectService projectService;

	//@Test
	public void controller(){

		var pji = new ProjectInfo();
		projectController.queryList(pji);

		pji.setId("1");
		projectController.queryList(pji);

		pji.setId("0ff2e0a4e31d41439cd705b0eafc5f15");
		projectController.queryList(pji);

		pji.setId(null);
		pji.setProjectName("k");
		projectController.queryList(pji);

		pji.setId(null);
		pji.setProjectName(null);
		projectController.queryList(pji);

		pji.setId(UUIDUtil.getOneUUID());
		pji.setProjectName("test");
		projectController.addProject(pji);
		projectController.addProject(pji);
		pji.setId("");
		projectController.addProject(pji);
		pji.setId("114514");
		projectController.addProject(pji);

		pji.setProjectName("test1");
		System.out.println(pji.toString());
		projectController.updateUser(pji);

		pji.setId(null);
		pji.setProjectName(null);
		projectController.updateUser(pji);

		pji.setId("");
		pji.setProjectName(null);
		projectController.updateUser(pji);

		pji.setId("114514");
		pji.setProjectName(null);
		projectController.updateUser(pji);

		projectController.deleteUserById(pji);
		projectController.deleteUserById(pji);
		pji.setId(null);
		projectController.deleteUserById(pji);
	}
}
