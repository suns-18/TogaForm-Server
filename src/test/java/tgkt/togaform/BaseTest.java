package tgkt.togaform;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import tgkt.togaform.response.HttpResponse;
import tgkt.togaform.util.UUIDUtil;

@SpringBootTest
class BaseTest {
    Logger log = Logger.getLogger(BaseTest.class);

    @Test
    void uuidUtil(){
        Assertions.assertNull(UUIDUtil.getUUID(0));
        log.info("UUID工具类测试1：获取0个UUID，返回null，通过");
        Assertions.assertNotNull(UUIDUtil.getUUID(1));
        log.info("UUID工具类测试2：获取1个UUID，返回列表，通过");
        Assertions.assertNotNull(UUIDUtil.getUUID(2));
        log.info("UUID工具类测试通过");
    }

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
