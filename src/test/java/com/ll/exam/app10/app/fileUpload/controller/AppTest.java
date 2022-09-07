package com.ll.exam.app10.app.fileUpload.controller;

import com.ll.exam.app10.app.home.controller.HomeController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import javax.transaction.Transactional;
import java.io.InputStream;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class AppTest {
    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("메인화면에 안녕 출력")
    void t1() throws Exception {
        // when
        ResultActions resultActions = mvc
                .perform(get("/"))
                .andDo(print());

        // then
        resultActions
                .andExpect(status().is2xxSuccessful())
                .andExpect(handler().handlerType(HomeController.class))
                // Mehtod 이름이 main인 함수 실행
                .andExpect(handler().methodName("main"))
                // main 메소드를 실행했을 때 안녕이 들어가있는지 확인
                .andExpect(content().string(containsString("안녕")));
    }
}