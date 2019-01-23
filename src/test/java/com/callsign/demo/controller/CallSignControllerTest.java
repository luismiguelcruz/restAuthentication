package com.callsign.demo.controller;

import com.callsign.demo.pojo.User;
import com.callsign.demo.service.CallSignService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CallSignControllerTest {
    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    private String validResponse = "\"id\":\"admin\",\"password\":\"\"";

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity()) // enable security for the mock set up
                .build();
    }

    @Test
    @WithMockUser(value = "admin", password = "password")
    public void whenUserAndPasswordAreCorrectThenReturnValidLogedUser() throws Exception {
        String contentType = MediaType.APPLICATION_JSON + ";charset=UTF-8";

        final MvcResult result = mvc
                .perform(get("/login").contentType(MediaType.APPLICATION_JSON).content(""))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andReturn();

        assertThat(result.getResponse().getContentAsString(), containsString(validResponse));
    }
}