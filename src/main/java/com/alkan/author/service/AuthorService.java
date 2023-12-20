package com.alkan.author.service;

import com.alkan.author.entity.Author;
import com.alkan.author.response.author.AuthorResponse;

public interface AuthorService {
    AuthorResponse findByName(String name);

    AuthorResponse create(String id, String name);

    Author findById(String id);
}
