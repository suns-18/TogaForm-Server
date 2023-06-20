package tgkt.togaform.util;


import java.util.UUID;

public class UUIDUtil {
    private UUIDUtil(){}

    public static String getOneUUID() {
        //Get single UUID and replace "-" with ""
        return UUID.randomUUID().
                toString().replaceAll("-", "");
    }

    public static String[] getUUID(int count) {
        if (count < 1)
            return null;

        var uuids = new String[count];

        for (int i = 0; i < count; i++)
            uuids[i] = getOneUUID();

        return uuids;
    }
}