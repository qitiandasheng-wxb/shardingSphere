package com.example.sharding.complex;



import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;
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
public class ComplexShardingTableImpl implements ComplexKeysShardingAlgorithm {



//    ComplexShardingStrategy
    @Override
    public Collection<String> doSharding(Collection availableTargetNames, ComplexKeysShardingValue shardingValue) {
        System.out.println(availableTargetNames);
        System.out.println(shardingValue);
//        checkresult,billno
        Collection<String> billnos= (Collection<String>) shardingValue.getColumnNameAndShardingValuesMap().get("billno");
        Collection<Integer> checkresults= (Collection<Integer>) shardingValue.getColumnNameAndShardingValuesMap().get("checkresult");
        for(String  billno:billnos){
            if("".equals(billno)){
                for(int checkresult:checkresults){

                }
            }
        }


        Collection<String> tables=new ArrayList<>();
        tables.add("billinfo_1");
        return tables;

    }
}
