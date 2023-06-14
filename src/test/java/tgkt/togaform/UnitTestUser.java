package tgkt.togaform;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import tgkt.togaform.controller.UserController;
import tgkt.togaform.entity.User;
import tgkt.togaform.response.HttpResponse;
import tgkt.togaform.util.UUIDUtil;

@Component
public class UnitTestUser {
	public void httpResponseTest(){
		var h = new HttpResponse();
		h.setData("aaa");
		h.setCode((String) h.getData());
		h.setMessage(h.getCode());
		h.setData(h.getMessage());

		System.out.println(h.equals(new HttpResponse()));
		System.out.println(h.equals(h));
		System.out.println(h);
		System.out.println(h.hashCode());

	}
	@Autowired
	UserController userController;
	public void controller() throws Exception {
		User user = new User();
		user.setId(UUIDUtil.getOneUUID());
		var id = user.getId();
		user.setStatus("1");
		user.setUsername("LS");
		user.setPassword("123");

		userController.addUser(user);
		userController.addUser(user);
		user.setId(null);
		userController.addUser(user);

		user.setId(id);
		user.setStatus("0");
		user.setUsername("LS23213");
		user.setPassword("1231313");

		userController.updateUser(user);
		userController.queryUserList(user);
		userController.queryUserList(null);

		user.setId("1111");
		userController.updateUser(user);
		user.setId(null);
		userController.updateUser(user);

		user.setId(id);
		userController.deleteUserById(user);
		userController.deleteUserById(user);
		user.setId(null);
		userController.deleteUserById(user);

		userController.queryUserList(user);


		userController.userLogout();

		user.setUsername("admin");
		user.setPassword("admin");
		userController.userLogin(user);

		user.setUsername("admiwewen");
		user.setPassword("adwdwdmin");
		userController.userLogin(user);

		userController.userLogin(null);
		userController.userLogin(new User());

	}
}
