package com.example.sharding.strategy;

import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;


@Configuration
public class RangeShardingImpl implements RangeShardingAlgorithm {
    @Override
    public Collection<String> doSharding(Collection availableTargetNames, RangeShardingValue shardingValue) {
        System.out.println(RangeShardingImpl.class.getName());
        System.out.println(availableTargetNames);
        System.out.println(shardingValue);
        return null;
    }
}
