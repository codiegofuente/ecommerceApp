package com.app.ecommerce.enums;

import static com.app.ecommerce.utils.ValidationsConstants.*;

public enum ErrorCustom {

    DATE_ERROR(MANDATORY_DATE),
    PRODUCT_ID_ERROR(MANDATORY_PRODUCT_ID),
    BRAND_ID_ERROR(MANDATORY_BRAND_ID);

    private final String code;

    ErrorCustom(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public static ErrorCustom valueOfCode(String code) {
        for (ErrorCustom errorC : ErrorCustom.values()) {
            if (errorC.getCode().equals(code))
                return errorC;
        }

        return null;
    }

}
