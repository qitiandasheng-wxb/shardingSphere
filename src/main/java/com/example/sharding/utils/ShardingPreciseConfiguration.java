package com.example.sharding.utils;

 import com.alibaba.druid.pool.DruidDataSource;
  import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
 import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
 import org.apache.shardingsphere.api.config.sharding.strategy.InlineShardingStrategyConfiguration;
 import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
 import org.apache.shardingsphere.shardingjdbc.jdbc.core.datasource.ShardingDataSource;
 import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
 import org.apache.shardingsphere.transaction.core.TransactionType;

 import javax.sql.DataSource;
 import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


 public class ShardingPreciseConfiguration {


    public DataSource getDataSource() throws SQLException {
//        ShardingDataSource shardingDataSource=new ShardingDataSource();
        ShardingRuleConfiguration configuration=new ShardingRuleConfiguration();
         configuration.getTableRuleConfigs().add(getOrderTableRuleConfiguration());
        configuration.getTableRuleConfigs().add(getOrderItemTbaleRuleConfiguration());
        configuration.getBindingTableGroups().add("t_order,t_order_item");
        //配置分库
        configuration.setDefaultDatabaseShardingStrategyConfig(
                new InlineShardingStrategyConfiguration(
                "user_id","ds${user_id % 2}"));
//#spring.shardingsphere.sharding.default-database-
// strategy.standard.range-algorithm-class-name=
                //配置分表
//        DefaultKeyGenerator
        configuration.setDefaultTableShardingStrategyConfig(
                new InlineShardingStrategyConfiguration(
                "order_id","t_order${order_id % 2}"));
         return ShardingDataSourceFactory.createDataSource(createDateSourceMap(),
                configuration,
                new Properties());

     }

    private Map<String, DataSource> createDateSourceMap() {
        Map<String,DataSource> hashMap=new HashMap<>();
        DruidDataSource  dataSource1=new DruidDataSource();
        dataSource1.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource1.setUrl("jdbc:oracle:thin:@192.251.1.52:1521:ora11g");
        dataSource1.setUsername("hsyhdzd");
        dataSource1.setPassword("hsyhdzd");
        hashMap.put("ds0",dataSource1);
        DruidDataSource dataSource2=new DruidDataSource();
        dataSource2.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource2.setUrl("jdbc:oracle:thin:@192.251.1.51:1521:ora11g");
        dataSource2.setUsername("lzyqdz");
        dataSource2.setPassword("lzyqdz");
        hashMap.put("ds1",dataSource2);
        return  hashMap;
    }

    private TableRuleConfiguration getOrderItemTbaleRuleConfiguration() {
        TableRuleConfiguration result=new TableRuleConfiguration("t_order_item","ds${0..1}.t_order_item${0..1}");

        return  result;
    }

    private TableRuleConfiguration getOrderTableRuleConfiguration() {
        TableRuleConfiguration result=new TableRuleConfiguration("t_order","ds${0..1}.t_order${0..1}");
        return  result;
    }

    public static void main(String[] args) throws SQLException {
        ShardingPreciseConfiguration shardingPreciseConfiguration=new ShardingPreciseConfiguration();
        ShardingDataSource dataSource= (ShardingDataSource) shardingPreciseConfiguration.getDataSource();
        String sql = "SELECT i.* FROM t_order o JOIN t_order_item i ON o.order_id=i.order_id WHERE o.order_id=? AND o.USER_id=?";
         sql="insert into  t_order (ORDER_ID,USER_ID,name) values(?,?,?)";
        sql="select count(*) from   billinfo";

        try ( Connection conn = dataSource.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
//            preparedStatement.setInt(1, 1);
//            preparedStatement.setInt(2, 2);
//            preparedStatement.setString(3, "TEST");
////            preparedStatement.executeUpdate();
            preparedStatement.executeUpdate();
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while(rs.next()) {
                    System.out.println(rs.getInt(1));
//                    System.out.println(rs.getInt(2));
//                    System.out.println(rs.getString(3));

                }
            }
//            preparedStatement.ex
        }
    }
}
