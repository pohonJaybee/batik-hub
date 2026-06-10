package com.ecommerce.web.jpa.e_commerce_web_jpa.Utilities;

import org.springframework.stereotype.Component;

@Component
public class UtilityCookieName {

    private static String id;

    public static void setId(String idCookie) {
        id = idCookie;
    }

    public static String getId() {
        return id;
    }

}
