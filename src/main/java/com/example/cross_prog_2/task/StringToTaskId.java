package com.example.cross_prog_2.task;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class StringToTaskId implements Converter<String, TaskId> {
    @Override
    public TaskId convert(@NotNull String source) {
        try {
            return new TaskId(UUID.fromString(source));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid TaskId format");
        }
    }
}
