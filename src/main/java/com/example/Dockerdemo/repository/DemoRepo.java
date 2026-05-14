package com.example.Dockerdemo.repository;

import com.example.Dockerdemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

@Repository
public interface DemoRepo extends JpaRepository<Student,Long> {
}
