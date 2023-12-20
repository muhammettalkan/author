package com.alkan.author.service.impl;

import com.alkan.author.entity.Author;
import com.alkan.author.repository.AuthorRepository;
import com.alkan.author.response.author.AuthorApiEntry;
import com.alkan.author.response.author.AuthorApiResponse;
import com.alkan.author.response.author.AuthorResponse;
import com.alkan.author.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class AuthorServiceImpl implements AuthorService {
    private static final String EXTERNAL_ENDPOINT = "https://openlibrary.org/search/authors.json?q=";  // This is the external API endpoint

    private final AuthorRepository authorRepository;
    private final RestTemplate restTemplate; // This is the Spring RestTemplate to retrieve data from external API

    public AuthorServiceImpl(AuthorRepository authorRepository, RestTemplate restTemplate) {
        this.authorRepository = authorRepository;
        this.restTemplate = restTemplate;
    }
    private AuthorResponse mapToResponse(Author author) { // Maps entity's into a special response.
        return new AuthorResponse(author.getId(), author.getName());
    }

    @Override
    public AuthorResponse findByName(String name){
        Author author = authorRepository.findByName(name).orElse(null);
        if (author == null) {
            String url = EXTERNAL_ENDPOINT + name;
            ResponseEntity<AuthorApiResponse> response = restTemplate.getForEntity(url, AuthorApiResponse.class);
            if (response.getBody() != null && response.getBody().getNumFound() > 0) {
                AuthorApiEntry apiAuthor = response.getBody().getDocs().get(0); // Gets author from external api.
                author = new Author(apiAuthor.getKey(), apiAuthor.getName()); // Gets key and name from external api and sets it to id and name.
                authorRepository.save(author); // Saves new author to database
            }
        }
        return mapToResponse(author);
    }
    @Override
    public AuthorResponse create(String id, String name) {
        Author author = new Author(id, name);
        author.setWorks(new ArrayList<>());
        authorRepository.save(author);
        return mapToResponse(authorRepository.save(author));
    }
    @Override
    public Author findById(String id) {
        return authorRepository.findById(id).orElse(null);
    }

}
