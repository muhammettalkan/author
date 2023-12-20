package com.alkan.author.repository;

import com.alkan.author.entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkRepository extends JpaRepository<Work, String> {
    List<Work> findByAuthorId(String authorId);
}
