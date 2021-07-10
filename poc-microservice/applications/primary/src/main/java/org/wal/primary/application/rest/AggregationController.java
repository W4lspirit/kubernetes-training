package org.wal.primary.application.rest;

import java.util.function.Function;

import org.wal.primary.application.response.AggregationStatistics;
import org.wal.primary.domain.service.AggregateService;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aggregation")
public class AggregationController {

    private final AggregateService aggregateService;

    public AggregationController(AggregateService service) {
        aggregateService = service;
    }

    @GetMapping(value = "/{location}/statistics")
    private Mono<AggregationStatistics> getEmployeeById(@PathVariable String location) {
        Mono<Tuple3<Long, Long, Integer>> result =
                aggregateService.computeStatistic(location);
        return result.map(convert());
    }

    private Function<Tuple3<Long, Long, Integer>, AggregationStatistics> convert() {
        return objects -> new AggregationStatistics(objects.getT1(),
                objects.getT2(),
                objects.getT3());
    }

    @GetMapping(value = "/{location}/statistics")
    private void a() {

    }
}
