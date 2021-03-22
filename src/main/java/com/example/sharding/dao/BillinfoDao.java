package com.example.sharding.dao;

import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
public class BillinfoDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public String queryBillinfo(String branchno,String billdate,String billno){
        Date date=Date.valueOf(billdate);
        int  checkreult=1;
        String sql="select   billno from    billinfo where  checkresult=? and ROWNUM<10  ";
//        String sql="select count(*) from  accountinfo where  branchno = ?";
        List   list=jdbcTemplate.queryForList(sql,branchno);
        return  list.get(0)+"";
    }


    @Transactional(rollbackFor=Exception.class)
    @ShardingTransactionType(TransactionType.LOCAL)
    public int updateBillinfo(String branchno,String billdate ){
        Date date=Date.valueOf(billdate);
        String sql="update billinfo set checkresult=? where  (branchno=? or branchno=?) and billdate=?";
        return  jdbcTemplate.update(sql,2,branchno.split(",")[0],branchno.split(",")[1],date);
    }
}
