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
    void uuidUtil() {
        Assertions.assertNull(UUIDUtil.getUUID(0));
        log.info("UUID工具类测试1：获取0个UUID，返回null，通过");
        Assertions.assertNotNull(UUIDUtil.getUUID(1));
        log.info("UUID工具类测试2：获取1个UUID，返回列表，通过");
        Assertions.assertNotNull(UUIDUtil.getUUID(2));
        log.info("UUID工具类测试通过");
    }

    @Test
    void httpResp() {
        var h = new HttpResponse();
        h.setData("111");
        h.setCode("111");
        h.setMessage("111");
        Assertions.assertEquals(h.getCode(), "111");
        Assertions.assertEquals(h.getMessage(), "111");
        Assertions.assertEquals(h.getData(), "111");
    }

}
