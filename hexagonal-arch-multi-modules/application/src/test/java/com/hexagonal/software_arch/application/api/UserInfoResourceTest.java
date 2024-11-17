package com.hexagonal.software_arch.application.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UserInfoResourceTest {
    private static final String ENDPOIONT = "/api/info";
    
    @Autowired
    private MockMvc mvc;

    @Test
    void testGetInfoById() throws Exception {
        mvc.perform(
           get(ENDPOIONT + "/" + 1).contentType(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(status().isOk());
    }
}
