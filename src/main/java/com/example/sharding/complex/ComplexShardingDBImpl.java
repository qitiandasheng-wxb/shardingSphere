package com.example.sharding.complex;



import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collection;

@Configuration
public class ComplexShardingDBImpl implements ComplexKeysShardingAlgorithm {
    String sta="UAT";
//    ComplexShardingStrategy
    @Override
    public Collection<String> doSharding(Collection availableTargetNames, ComplexKeysShardingValue shardingValue) {
        Collection<String> dbs=new ArrayList<>();
        Collection<String> branchnos= (Collection<String>) shardingValue.getColumnNameAndShardingValuesMap().get("branchno");
        for (String branchno:branchnos) {
           if("1".equals(branchnos)){
               dbs.add("db1");
           }else{
               dbs.add("db1");
           }
        }
        return dbs;
    }
}
