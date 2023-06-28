package tgkt.togaform.util;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

@Component
public class BSONIDUtil {
    public static String getOneId() {
        return new ObjectId().toString();
    }
}
