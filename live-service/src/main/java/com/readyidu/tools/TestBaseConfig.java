package com.readyidu.tools;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcConfigurer;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext.xml"})
@WebAppConfiguration
//事务自动回滚
@Rollback
@Transactional
public class TestBaseConfig {

    @Autowired(required = false)
    protected WebApplicationContext context;
    @Autowired(required = false)
    protected MockMvcConfigurer mockMvcConfigurer;
    protected MockMvc mockMvc;

    @Before
    public void init() {
        createMockMVC();
    }

    public void createMockMVC() {
        DefaultMockMvcBuilder builder = webAppContextSetup(context);
        if (mockMvcConfigurer != null) {
            builder = builder.apply(mockMvcConfigurer);
        }
        mockMvc = builder.build();
    }

    @Test
    public void test() throws Exception {

    }
}
