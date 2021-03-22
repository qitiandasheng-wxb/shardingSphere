package com.example.sharding.hint;


import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;
import org.apache.shardingsphere.core.strategy.route.ShardingStrategy;
import org.apache.shardingsphere.core.strategy.route.complex.ComplexShardingStrategy;
import org.apache.shardingsphere.core.strategy.route.value.RouteValue;
import org.apache.shardingsphere.underlying.common.config.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collection;
@Configuration
public class HintShardingDataBaseImpl implements ShardingStrategy {
    @Override
    public Collection<String> getShardingColumns() {
        return null;
    }

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, Collection<RouteValue> shardingValues, ConfigurationProperties properties) {
        return null;
    }
}
