package com.example.cross_prog_2.task;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CreateTaskParameters( String task, boolean important, boolean checked, LocalDateTime date) {

}
