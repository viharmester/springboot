package com.andorid.l2pp.SpringBootApplication.metrics;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class EvenHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        int chance = ThreadLocalRandom.current().nextInt();
        Health.Builder status = chance % 2 == 0 ? Health.up() : Health.down();
        return status.build();
    }
}
