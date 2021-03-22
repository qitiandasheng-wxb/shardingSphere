package com.example.sharding.dao;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class BillinfoDaoTest {
    @Autowired
    BillinfoDao dao;
    @Test
    void queryBillinfo() {
        System.out.println(
                dao.queryBillinfo("810101011","2019-06-30","20200930"));
    }
    @Test
    void updateBillinfo(){
        System.out.println(dao.updateBillinfo("810101011,810102041","2019-06-30"));
    }
}