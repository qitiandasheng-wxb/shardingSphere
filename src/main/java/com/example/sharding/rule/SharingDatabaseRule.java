package com.example.sharding.rule;

import org.apache.shardingsphere.api.sharding.ShardingValue;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;
import org.springframework.aop.scope.ScopedObject;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class SharingDatabaseRule implements ComplexKeysShardingAlgorithm {

    @Override
    public Collection<String> doSharding(Collection  collection, ComplexKeysShardingValue shardingValues) {
        System.out.println("collection:" + collection + ",shardingValues:" + shardingValues);
        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.DAY_OF_YEAR);
        List<String> shardingSuffix = new ArrayList<>();
        shardingSuffix.add("ds0");
        return shardingSuffix;
    }

}
