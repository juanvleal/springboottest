package com.bootcamp.springboottest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest
@ExtendWith(SpringExtension.class)
public class TesteIntController {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testInt() throws Exception{
        RequestBuilder requisicao = get("/test");
        MvcResult resultado = mvc.perform(requisicao).andReturn();
        assertEquals("Bem-vindo, Juan", resultado.getResponse().getContentAsString());
    }
    @Test
    public void testIntComArgumento() throws Exception{
        mvc.perform(get("/test?nome=Renan"))
                .andExpect(content().string("Bem-vindo, Renan"));
    }
}
