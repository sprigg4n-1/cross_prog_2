package com.example.cross_prog_2.task;

import io.github.wimdeblauwe.jpearl.InMemoryUniqueIdGenerator;
import io.github.wimdeblauwe.jpearl.UniqueIdGenerator;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("data-jpa-test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TaskRepositoryTest {
    private final TaskRepository repository;
    private final JdbcTemplate jdbcTemplate;
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    TaskRepositoryTest(TaskRepository repository,
                           JdbcTemplate jdbcTemplate) {
        this.repository = repository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @BeforeEach
    void validatePreconditions() {
        assertThat(repository.count()).isZero();
    }

    @Test
    void testSaveTask() {
        TaskId id = repository.nextId();
        repository.save(new Task(id, new TodoTask("task1"), true, false, LocalDateTime.of(2024, 12, 12, 12, 0)));

        entityManager.flush();

        assertThat(jdbcTemplate.queryForObject("SELECT id FROM tt_tasks", UUID.class)).isEqualTo(id.getId());
        assertThat(jdbcTemplate.queryForObject("SELECT task FROM tt_tasks", String.class)).isEqualTo("task1");
        assertThat(jdbcTemplate.queryForObject("SELECT important FROM tt_tasks", Boolean.class)).isEqualTo(true);
        assertThat(jdbcTemplate.queryForObject("SELECT checked FROM tt_tasks", Boolean.class)).isEqualTo(false);
        assertThat(jdbcTemplate.queryForObject("SELECT date FROM tt_tasks", LocalDateTime.class)).isEqualTo(LocalDateTime.of(2024, 12, 12, 12, 0));
    }

    @Test
    void testFindAllPageable() {
        saveTask(8);
        Sort sort = Sort.by(Sort.Direction.ASC, "task");

        assertThat(repository.findAll(PageRequest.of(0, 5, sort)))
                .hasSize(5)
                .extracting(task -> task.getTodoTask().getTask())
                .containsExactly("task 0", "task 1", "task 2", "task 3", "task 4");

        assertThat(repository.findAll(PageRequest.of(1, 5, sort)))
                .hasSize(3)
                .extracting(task -> task.getTodoTask().getTask())
                .containsExactly("task 5","task 6", "task 7");

        assertThat(repository.findAll(PageRequest.of(2, 5, sort))).isEmpty();
    }

    private void saveTask(int numberOfTasks) {
        for (int i = 0; i < numberOfTasks; i++) {
            repository.save(new Task(
                    repository.nextId(),
                    new TodoTask("task " + i),
                    false,
                    false,
                    LocalDateTime.of(2024, 12, 12, 12, 0)
            ));
        }
    }

    @TestConfiguration
    static class TestConfig {
        @Bean
        public UniqueIdGenerator<UUID> uniqueIdGenerator() {
            return new InMemoryUniqueIdGenerator();
        }
    }

}