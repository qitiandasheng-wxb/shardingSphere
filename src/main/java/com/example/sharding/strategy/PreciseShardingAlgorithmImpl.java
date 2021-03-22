package com.example.sharding.strategy;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;

@Configuration
public class PreciseShardingAlgorithmImpl implements PreciseShardingAlgorithm {
    @Override
    public String doSharding(Collection availableTargetNames, PreciseShardingValue shardingValue) {
        System.out.println(PreciseShardingAlgorithmImpl.class.getName());
        System.out.println(availableTargetNames);
        System.out.println(shardingValue);
        return null;
    }
}
