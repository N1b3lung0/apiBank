package com.nextdigital.apibank.services.common.uuid;

import org.springframework.util.Assert;

import java.util.UUID;

public class UUIDUtils {

    public static UUID fromString(String id) throws IllegalArgumentException {
        Assert.notNull(id, "Id is required");
        return UUID.fromString(id);
    }
}
