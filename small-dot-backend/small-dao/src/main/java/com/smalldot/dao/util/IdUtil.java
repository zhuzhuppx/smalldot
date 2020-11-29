package com.smalldot.dao.util;

import java.util.UUID;

public class IdUtil {
    public static String nextId() {
        return UUID.randomUUID().toString();
    }
}
