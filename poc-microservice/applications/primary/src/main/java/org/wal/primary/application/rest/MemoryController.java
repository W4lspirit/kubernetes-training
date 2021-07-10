package org.wal.primary.application.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wal.primary.application.request.MemoryOrder;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

@RestController
@RequestMapping("/memory")
public class MemoryController {

    private final ConcurrentLinkedQueue<List<String>> queue = new ConcurrentLinkedQueue<>();

    @GetMapping(value = "/{order}")
    public Mono<String> apply(@PathVariable MemoryOrder location) {
        switch (location) {

            case UP -> {
                queue.add(List.of(Instant.now().toString()));
            }
            case DOWN -> {
                queue.remove();
            }
            case RESET -> {
                queue.clear();
            }
        }
        return Mono.just("done");
    }


}
