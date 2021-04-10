package org.wal.primary.infrastructure.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties(prefix = "aggregation")
@ConstructorBinding
public record PrecisionConfiguration(int decimals) {

    public int getDecimals() {
        return decimals;
    }

}