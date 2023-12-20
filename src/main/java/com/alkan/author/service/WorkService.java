package com.alkan.author.service;

import com.alkan.author.dto.WorkDto;
import com.alkan.author.entity.Work;
import com.alkan.author.response.work.WorkResponse;

import java.util.List;

public interface WorkService {
    WorkDto mapToDto(Work work);

    List<WorkDto> findByAuthorId(String authorId);

    List<Work> findWorksByAuthorId(String authorId);
}
