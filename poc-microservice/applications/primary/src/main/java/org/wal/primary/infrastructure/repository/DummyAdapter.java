package org.wal.primary.infrastructure.repository;

import org.wal.primary.domain.repository.TimeseriesRepository;

import org.springframework.stereotype.Repository;

@Repository
public class DummyAdapter implements TimeseriesRepository {

    @Override
    public Long count(String location) {
        return 3L;
    }
}
