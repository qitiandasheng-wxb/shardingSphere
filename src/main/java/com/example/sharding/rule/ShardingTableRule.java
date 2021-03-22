package com.example.sharding.rule;

import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.util.*;

@Configuration
public class ShardingTableRule implements ComplexKeysShardingAlgorithm {
    @Override
    public Collection<String> doSharding(Collection availableTargetNames, ComplexKeysShardingValue shardingValue) {
        Map<String,List> valueMap=shardingValue.getColumnNameAndShardingValuesMap();
        List<Object> branchnoList=valueMap.get("branchno");
        List<Date> billdateList=valueMap.get("billdate");
        List<String> shardingSuffix = new ArrayList<>();
        for(Object brnchnoTemp:branchnoList){
            for(Date billdateTemp:billdateList){
////                String[] strs=Object.split(",");
//                for(String str:strs){
//                    shardingSuffix.add(shardingValue.getLogicTableName()+"_"+billdateTemp.toString().replace("-","").substring(0,4)+"_"+str.replaceAll("'",""));
//                }
               shardingSuffix.add(shardingValue.getLogicTableName()+"_"+billdateTemp.toString().replace("-","").substring(0,4)+"_"+brnchnoTemp);

            }
        }
//        shardingSuffix.add("BILLINFO_2019_810101011");
        return shardingSuffix;
    }
}
