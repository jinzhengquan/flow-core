package cn.flow.core.utils;

import java.util.UUID;

public class IdGenerateUtil {

    public static String generate() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
