package com.example.connectpool.hivedemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestBase {

    @Autowired
    @Qualifier("hiveDruidDataSource")
    private DataSource druidDataSource;

    @Autowired
    @Qualifier("hiveDruidTemplate")
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testDruidCon() {

        Map<String, Object> show_databases = jdbcTemplate.queryForMap("show databases");
        System.out.println(show_databases);
    }
}
