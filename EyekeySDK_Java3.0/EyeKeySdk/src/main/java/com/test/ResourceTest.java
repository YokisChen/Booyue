package com.test;

import com.alibaba.fastjson.JSONObject;
import com.eyekey.http.EyeKeyHttp;

public class ResourceTest {
    public static void main(String[] args) {
        EyeKeyHttp http = new EyeKeyHttp();
        JSONObject o = http.createPeopleById(null, null, null, null);
        System.out.println(o);
    }
}
