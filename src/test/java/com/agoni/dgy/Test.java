package com.agoni.dgy;

import com.baomidou.mybatisplus.core.toolkit.AES;

public class Test {
    public static void main(String[] args) {
        // 生成 16 位随机 AES 密钥
        String randomKey = AES.generateRandomKey();

        // 随机密钥加密
        String result = AES.encrypt("dongGY1234", randomKey);
        System.out.printf(result);
    }
}
