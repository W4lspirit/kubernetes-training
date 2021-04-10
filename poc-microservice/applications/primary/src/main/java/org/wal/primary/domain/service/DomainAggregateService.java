package org.wal.primary.domain.service;

import org.wal.primary.domain.repository.TimeseriesRepository;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple3;

import static reactor.core.publisher.Mono.just;
import static reactor.util.function.Tuples.of;

public class DomainAggregateService implements AggregateService {

    private static final long HARDCODED_EXEC_TIME = 2L;
    private final TimeseriesRepository timeseriesRepository;
    private final int decimals;

    public DomainAggregateService(TimeseriesRepository repository, int decimals) {
        this.timeseriesRepository = repository;
        this.decimals = decimals;
    }

    @Override
    public Mono<Tuple3<Long, Long, Integer>> computeStatistic(String location) {
        return just(of(HARDCODED_EXEC_TIME,
                timeseriesRepository.count(location),
                decimals));
    }

}
