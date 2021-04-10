package org.wal.primary.infrastructure.configuration;

import org.wal.primary.domain.service.AggregateService;
import org.wal.primary.domain.service.DomainAggregateService;
import org.wal.primary.infrastructure.repository.DummyAdapter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class BeanConfiguration {

    @Bean
    AggregateService aggregateService(PrecisionConfiguration configuration) {
        return new DomainAggregateService(new DummyAdapter(),
                configuration.getDecimals());
    }

}
