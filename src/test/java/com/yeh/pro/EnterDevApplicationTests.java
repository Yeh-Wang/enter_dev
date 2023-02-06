package com.yeh.pro;

import com.yeh.pro.controller.VideoResourceBankController;
import com.yeh.pro.mapper.VideoResourceBankMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ws.schild.jave.EncoderException;

import java.io.File;

@SpringBootTest
class EnterDevApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private VideoResourceBankMapper videoResourceBankMapper;

    @Autowired
    private VideoResourceBankController videoResourceBankController;
    @Test
    void test_new() throws EncoderException {
        System.out.println(videoResourceBankController.getVideoTime(new File("D:/looker/Video/nunu.mp4")));
    }
}
