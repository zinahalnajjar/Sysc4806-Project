package org.example.testingweb;

import org.example.User;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {

    @LocalServerPort
    private int port;
    @Autowired
    private MockMvc mockMvc;

    HttpHeaders headers = new HttpHeaders();
    TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void testLogin() throws Exception {
        this.mockMvc.perform(get("/userLogin")).andDo(print()).andExpect(status().isOk());
                //.andExpect((ResultMatcher) content().string(containsString("Sam")));


    }
    @Test
    public void testingSignUp() throws Exception {
        this.mockMvc.perform(get("/userSignup")).andDo(print()).andExpect(status().isOk());

    }


}
