package com.peixun.test.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.peixun.test.entity.JsonUtil.STATE_OK;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JsonUtilTest {
    @Test
    public void test(){
        JsonUtil jsonUtil = new JsonUtil();
        System.out.println(jsonUtil.getState());
    }
}