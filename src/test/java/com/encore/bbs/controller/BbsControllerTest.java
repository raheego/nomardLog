package com.encore.bbs.controller;

import com.encore.bbs1.controller.BbsController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@SpringBootTest
@ExtendWith(SpringExtension.class)
class BbsControllerTest {

    @Autowired
    com.encore.bbs1.controller.BbsController bbsController;

    public MockMvc mockMvc; //api 테스트 mockmvc
    /* Spring Boot와 Spring Framework의 최신 버전에서는 @SpringBootTest와 @ExtendWith(SpringExtension.class)가 사용되면
     테스트 컨텍스트가 올바르게 설정되어 MockMvc 인스턴스를 자동으로 생성하므로, @Autowired를 사용하여 mockMvc 필드를
     주입받을 수 있습니다*/

    @BeforeEach
    public void setup() {
        bbsController = new BbsController();
        mockMvc = MockMvcBuilders.standaloneSetup(bbsController).build();
    }

    @Test
    @DisplayName("Get 컨트롤러 작동 확인")
    void getList() throws Exception {
        mockMvc.perform(get("/api/message"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, World!"));
    }
}