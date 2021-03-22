package com.example.sharding.hint;



import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collection;

@Configuration
public class HintShardingTableImpl implements HintShardingAlgorithm<Long> {

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, HintShardingValue<Long> shardingValue) {
        System.out.println("HintShardingTableImpl---availableTargetNames"+availableTargetNames);
        System.out.println("HintShardingTableImpl---shardingValue"+shardingValue);

        Collection<String> result = new ArrayList<>();
//            for (String each : availableTargetNames) {
//                for (Long value : shardingValue.getValues()) {
//                    if (each.endsWith(String.valueOf(value % 2))) {
//                        result.add(each);
//                    }
//                }
//            }
        result.add("t_order0");
        return result;
    }
}
