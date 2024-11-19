package com.hexagonal.software_arch.application.api;

import com.hexagonal.software_arch.ITSupport;
import com.hexagonal.software_arch.application.dto.MyInfoDto;
import com.hexagonal.software_arch.infrastructure.repository.InfoRepository;
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
public class UserInfoResourceTest extends ITSupport {
    private static final String ENDPOIONT = "/api/info";
    
    @Autowired
    private MockMvc mvc;

    @Autowired
    private InfoRepository infoRepository;

    @Test
    void testGetInfoById() throws Exception {
        infoRepository.addInformation(
                new MyInfoDto("mohamed ahmed",
                        "87298792","m@google.com"));

        mvc.perform(
                get(ENDPOIONT + "/" + 1).contentType(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.fullName").value("mohamed ahmed"));
    }
}
