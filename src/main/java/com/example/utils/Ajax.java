package com.example.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pavelbortnikov on 06.04.16.
 */

public class Ajax {

    public static Map<String, Object> successResponse(Object object) {
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("result", "success");
        response.put("data", object);
        return response;
    }

    public static Map<String, Object> errorResponse(String errorMessage) {
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("result", "success");
        response.put("data", null);
        response.put("message", errorMessage);
        return response;
    }
}