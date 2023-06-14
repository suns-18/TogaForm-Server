package tgkt.togaform;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import tgkt.togaform.entity.User;
import tgkt.togaform.response.HttpResponse;

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
}
