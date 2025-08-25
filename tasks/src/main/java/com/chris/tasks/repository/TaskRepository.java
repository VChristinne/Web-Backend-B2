package com.chris.tasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.chris.tasks.model.Task;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {}
