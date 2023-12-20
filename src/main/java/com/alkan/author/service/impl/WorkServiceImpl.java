package com.alkan.author.service.impl;

import com.alkan.author.dto.WorkDto;
import com.alkan.author.entity.Author;
import com.alkan.author.entity.Work;
import com.alkan.author.repository.WorkRepository;
import com.alkan.author.response.work.WorkApiEntry;
import com.alkan.author.response.work.WorkResponse;
import com.alkan.author.response.work.WorksApiResponse;
import com.alkan.author.service.AuthorService;
import com.alkan.author.service.WorkService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {

    private static final String EXTERNAL_ENDPOINT = "https://openlibrary.org/authors/";

    private final WorkRepository workRepository;
    private final RestTemplate restTemplate; // This is the Spring RestTemplate to retrieve data from external API
    private final AuthorService authorService;

    public WorkServiceImpl(WorkRepository workRepository, RestTemplate restTemplate, AuthorService authorService) {
        this.workRepository = workRepository;
        this.restTemplate = restTemplate;
        this.authorService = authorService;
    }

    private List<WorkDto> mapToListResponse(List<Work> works) {
        return works.stream().map(this::mapToDto).toList();
    }
    @Override
    public WorkDto mapToDto(Work work) {
        return new WorkDto(work.getId(), work.getTitle(), work.getAuthor().getId());
    }
    @Override
    public List<WorkDto> findByAuthorId(String authorId) {

        List<Work> works = findWorksByAuthorId(authorId); // Checks if there's work in db.
        if (!works.isEmpty()) return mapToListResponse(works); // If there's it returns it.


        String url = EXTERNAL_ENDPOINT + authorId + "/works.json";
        // Retrieve data from external endpoint.
        ResponseEntity<WorksApiResponse> response = restTemplate.getForEntity(url, WorksApiResponse.class);

        if(response.getBody().getSize() > 0) {
            Author author = authorService.findById(authorId);
            for (WorkApiEntry entry : response.getBody().getEntries()) { // Adds works with a for loop.
                Work work = new Work(entry.getKey(), entry.getTitle(), author);
                works.add(work);
            }
            workRepository.saveAll(works); // Saves works to the db.
            return mapToListResponse(works);
        }
        return mapToListResponse(new ArrayList<>());
    }
    @Override
    public List<Work> findWorksByAuthorId(String authorId) {
        List<Work> works = workRepository.findByAuthorId(authorId);
        return works != null ? works : new ArrayList<>();
    }


}
