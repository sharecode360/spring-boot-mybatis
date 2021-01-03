package com.example.springboot;

import com.example.springboot.controller.StudentController;
import com.example.springboot.domain.model.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringBootTest
@Transactional
class SpringBootMybatisApplicationTests {

    private final String BASE_URL = "http://localhost:8080/";

    @Autowired
    private WebApplicationContext context;

    @InjectMocks
    private StudentController studentController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    void testAddStudent() throws Exception {

        Student input = new Student(null, "半沢直樹", "男性", 23);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(input);
        MvcResult result = mockMvc
                .perform(post("/student").contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andReturn();

        Student student = mapper.readValue(result.getResponse().getContentAsString(), Student.class);
        assert(student.getId() != null);
    }
}
