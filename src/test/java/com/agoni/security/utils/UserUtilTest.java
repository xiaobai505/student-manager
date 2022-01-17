package com.agoni.security.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserUtilTest {

    @Test
    void getUser() {

    }
}

abstract class  a {
    String str;

    abstract String a();
}

interface aa{
    String str = null;

    String aaa();
}

class aaimpl extends a implements aa{

    @Override
    public String aaa() {
        return null;
    }

    @Override
    String a() {
        return null;
    }
}