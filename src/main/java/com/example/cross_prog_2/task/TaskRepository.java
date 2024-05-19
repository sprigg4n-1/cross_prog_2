package com.example.cross_prog_2.task;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface TaskRepository extends CrudRepository<Task, TaskId>, PagingAndSortingRepository<Task, TaskId>, TaskRepositoryCustom {
}