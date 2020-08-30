package com.example.connectpool.hivedemo.controller;

import com.example.connectpool.hivedemo.vo.TableVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class IndexController {

    public static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    @Qualifier("hiveDruidDataSource")
    private DataSource druidDataSource;

    @Autowired
    @Qualifier("hiveDruidTemplate")
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/table/show")
    public List<Map<String,Object>> showtables() {
        logger.info("jdbcTemplate",jdbcTemplate);
        List<String> list = new ArrayList<String>();
        List<Map<String, Object>> maps = new ArrayList<>();
        Statement statement = null;
        try {
            statement = druidDataSource.getConnection().createStatement();
            String sql = "show tables";
            logger.info("Running: " + sql);
            ResultSet res = statement.executeQuery(sql);
            while (res.next()) {
                list.add(res.getString(1));
            }
            maps = jdbcTemplate.queryForList(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return maps;
    }
    @RequestMapping("/table/column")
    public List<TableVo> getResParams() {
        logger.info("get tableName start!");
        jdbcTemplate.execute(" use nfs "); //且库
        //Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap(" desc hive20200822 ");
        List<Map<String, Object>> desc_hive20200822 = jdbcTemplate.queryForList("desc hive20200822");
        List<TableVo> desc_hive20200822_ = jdbcTemplate.queryForList("desc hive20200822 ", TableVo.class);
        SqlRowSet desc_desc_hive20200822_ = jdbcTemplate.queryForRowSet("desc desc hive20200822 ");
        boolean first = desc_desc_hive20200822_.first();
        logger.info("get table column informations!");
        return desc_hive20200822_;
    }

}