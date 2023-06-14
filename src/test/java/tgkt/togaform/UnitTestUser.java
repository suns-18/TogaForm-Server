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
		User user1 = new User();

		user1.setStatus("1");
		user1.setUsername("user1");
		user1.setPassword("user1");

		userController.addUser(user1);
		user1.setUsername(null);
		user1.setPassword("null_str");
		userController.addUser(user1);

		user1.setUsername("");
		user1.setPassword("empty_str");
		userController.addUser(user1);

		userController.addUser(null);


		user1.setUsername("user1");
		user1.setPassword("user1");

		var data = userController.userLogin(user1);
		var user2 = (User) data.getData();

		user2.setPassword("user2");
		user2.setUsername("user2");
		userController.updateUser(user2);

		userController.queryUserList(user1);

		user1.setUsername("aaaaaaaaaaaaaaaaaaaaaaaaaa");
		userController.queryUserList(user1);
		userController.queryUserList(null);

		var user2ID = user2.getId();
		user2.setId("1111");
		userController.updateUser(user2);
		user2.setId(null);
		userController.updateUser(user2);


		user2.setId(user2ID);
		userController.deleteUserById(user2);

		userController.deleteUserById(user2);

		user2.setId(null);
		userController.deleteUserById(user2);

		userController.userLogout();

		user1.setUsername("admin");
		user1.setPassword("admin");
		userController.userLogin(user1);

		user1.setUsername("admiwewen");
		user1.setPassword("adwdwdmin");
		userController.userLogin(user1);

		userController.userLogin(null);
		userController.userLogin(new User());

	}
}
