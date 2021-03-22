package com.example.sharding.dao;

import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.sql.SQLException;

@Service

public class T_orderDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Transactional(rollbackFor = Exception.class)
    @ShardingTransactionType(TransactionType.XA)
    public void save() throws SQLException {
        jdbcTemplate.execute("insert into T_ORDER (order_id,user_id,name) values(?,?,'3')",(PreparedStatementCallback<Object>) preparedStatement ->{
            preparedStatement.setObject(1, 1);
            preparedStatement.setObject(2, 1);
            return    preparedStatement.executeUpdate();
         });
        jdbcTemplate.execute("insert into T_ORDER (order_id,user_id,name) values(?,?,'3')",(PreparedStatementCallback<Object>) preparedStatement ->{
            preparedStatement.setObject(1, 2);
            preparedStatement.setObject(2, 2);
            return    preparedStatement.executeUpdate();
        });
    }
}
