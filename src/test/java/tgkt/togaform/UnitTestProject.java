package tgkt.togaform;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import tgkt.togaform.controller.ProjectController;
import tgkt.togaform.entity.ProjectInfo;
import tgkt.togaform.service.ProjectService;
import tgkt.togaform.util.UUIDUtil;

import java.util.List;

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

		pji.setId(null);
		pji.setProjectName("k");
		projectController.queryList(pji);

		pji.setId(null);
		pji.setProjectName(null);
		projectController.queryList(pji);

		pji.setProjectName("test");
		projectController.addProject(pji);
		pji.setProjectName(null);
		projectController.addProject(pji);
		pji.setProjectName("");
		projectController.addProject(pji);

		pji.setProjectName("a");
		pji = (ProjectInfo) ((List<?>) (projectController.queryList(pji).getData())).get(0);
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
