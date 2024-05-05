package com.example.cross_prog_2.task;

import io.github.wimdeblauwe.jpearl.UniqueIdGenerator;

import java.util.UUID;

public class TaskRepositoryImpl implements TaskRepositoryCustom {
    private final UniqueIdGenerator<UUID> generator;

    public TaskRepositoryImpl(UniqueIdGenerator<UUID> generator) {
        this.generator = generator;
    }

    @Override
    public TaskId nextId() {
        return new TaskId(generator.getNextUniqueId());
    }
}