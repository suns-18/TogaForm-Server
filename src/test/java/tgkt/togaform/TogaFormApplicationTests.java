package tgkt.togaform;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;
import tgkt.togaform.controller.UserController;
import tgkt.togaform.entity.User;
import tgkt.togaform.service.UserService;
import tgkt.togaform.util.UUIDUtil;

import java.util.List;

@SpringBootTest
class TogaFormApplicationTests {
	@Autowired
	UnitTestProject unitTestProject;
	@Autowired
	UnitTestUser unitTestUser;
	@Test
	void contextLoads() throws Exception{
		unitTestUser.httpResponseTest();
		unitTestUser.controller();
		unitTestProject.controller();
	}

	Logger log = Logger.getLogger(TogaFormApplicationTests.class);
	@Autowired
	private UserService userService;

	@Test
	public void queryUserList() throws Exception {
		//调用userMapper的方法
		User userEntity = new User();
		List<User> list = userService.queryList(userEntity);
		if (CollectionUtils.isEmpty(list)) {
			// 记录error级别的信息
			log.error(">> User数据访问层: queryList测试未通过");
		} else {
			System.out.println(list);
			// 记录info级别的信息
			log.info(">> User数据访问层: queryList测试通过");
		}
	}

	@Test
	public void selectUserInfo() throws Exception {
		//调用userMapper的方法
		User userEntity = new User();
		userEntity.setUsername("admin");
		userEntity.setPassword("123");
		List<User> list = userService.queryList(userEntity);
		if (CollectionUtils.isEmpty(list)) {
			log.error(">> User数据访问层: login测试失败");
		} else {
			log.info(">> User数据访问层: login测试成功");
		}
	}

	@Test
	public void insert() throws Exception {
		User userEntity = new User();
		userEntity.setId(UUIDUtil.getOneUUID());
		userEntity.setUsername("LS");
		userEntity.setPassword("123");
		int i = userService.insert(userEntity);
		if (i == 0) {
			log.error(">> User数据访问层: insert测试失败");
		} else {
			log.info(">> User数据访问层: insert测试成功");
		}
	}

	@Test
	public void deleteUserByName() throws Exception {
		//调用userMapper的方法
		User userEntity = new User();
		userEntity.setUsername("aaa");
		userEntity.setId(UUIDUtil.getOneUUID());
		userService.insert(userEntity);

		int i = userService.deleteByName(userEntity);
		if (i == 0) {
			log.error(">> User数据访问层: deleteByName测试失败");
		} else {
			// 记录info级别的信息
			log.info(">> User数据访问层: deleteByName测试成功");
		}
	}

	@Test
	public void deleteUserById() throws Exception {

		User userEntity = new User();
		userEntity.setId(UUIDUtil.getOneUUID());
		userEntity.setStatus("1");
		userEntity.setUsername("LS");
		userEntity.setPassword("123");
		userService.insert(userEntity);

		int i = userService.deleteById(userEntity);
		if (i == 0) {
			log.error(">> User数据访问层: deleteById测试失败");
		} else {
			// 记录info级别的信息
			log.info(">> User数据访问层: deleteById测试成功");
		}
	}

	@Test
	void uuidUtil() {
		System.out.println(UUIDUtil.getUUID(0));
		System.out.println(UUIDUtil.getUUID(1));
		System.out.println(UUIDUtil.getUUID(2));
	}
}
