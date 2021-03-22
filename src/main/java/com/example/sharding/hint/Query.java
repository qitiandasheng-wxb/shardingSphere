package com.example.sharding.hint;

import org.apache.shardingsphere.api.hint.HintManager;
import org.apache.shardingsphere.shardingjdbc.jdbc.core.datasource.ShardingDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Configuration
public class Query {
    @Autowired
    ShardingDataSource dataSource;

    public   void query(){
        String sql="select count(*) from    ACCTRADEINFO0208";
        HintManager hintManager = HintManager.getInstance();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            hintManager.addDatabaseShardingValue("t_order", 1);
            hintManager.addTableShardingValue("t_order", 3);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while(rs.next()) {
                    System.out.println("-------------------------------------"+rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
        }finally {
            hintManager.close();
        }
     }
}
