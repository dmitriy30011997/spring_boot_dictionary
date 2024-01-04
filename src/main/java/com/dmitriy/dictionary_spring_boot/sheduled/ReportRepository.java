package com.dmitriy.dictionary_spring_boot.sheduled;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
