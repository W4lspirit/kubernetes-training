package org.wal.primary.application.rest;

import org.junit.jupiter.api.Test;
import org.wal.primary.application.request.MemoryOrder;

class MemoryControllerTest {
    MemoryController memoryController = new MemoryController();

    @Test
    void name() throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            memoryController.apply(MemoryOrder.UP);
        }
        Thread.sleep(1);
        for (int i = 0; i < 1000; i++) {
            memoryController.apply(MemoryOrder.DOWN);
        }
        Thread.sleep(1);
        for (int i = 0; i < 1000; i++) {
            memoryController.apply(MemoryOrder.UP);
        }
        Thread.sleep(1);
        memoryController.apply(MemoryOrder.RESET);
    }
}