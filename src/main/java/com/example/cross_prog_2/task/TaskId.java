package com.example.cross_prog_2.task;

import io.github.wimdeblauwe.jpearl.AbstractEntityId;

import java.util.UUID;

public class TaskId extends AbstractEntityId<UUID> {

   /**
   * Default constructor for JPA
   */
   protected TaskId() {
   }

   public TaskId(UUID id) {
       super(id);
   }
}