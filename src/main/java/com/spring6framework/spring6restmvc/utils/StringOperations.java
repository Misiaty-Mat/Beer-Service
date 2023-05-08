package com.spring6framework.spring6restmvc.utils;

import org.springframework.util.StringUtils;

public class StringOperations {
    static Boolean hasText(String string) {
        return StringUtils.hasText(string);
    }
}
