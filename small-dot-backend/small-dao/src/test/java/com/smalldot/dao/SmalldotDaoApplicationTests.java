package com.smalldot.dao;

import com.smalldot.dao.entity.RPoems;
import com.smalldot.dao.mapper.RPoemsMapper;
import com.smalldot.dao.model.RPoemsExample;
import com.smalldot.dao.service.IRPoemsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SmalldotDaoApplicationTests {
    @Autowired
    private IRPoemsService poemsService;

    @Test
    void contextLoads() {

        List<RPoems> list = poemsService.list();
        System.out.println(list);


    }

}
