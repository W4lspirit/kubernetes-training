package org.wal.primary.domain.service;

import reactor.core.publisher.Mono;
import reactor.util.function.Tuple3;

public interface AggregateService {

    Mono<Tuple3<Long, Long, Integer>> computeStatistic(String location);
}
