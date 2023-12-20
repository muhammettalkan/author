package com.alkan.author.response.author;

public class AuthorApiEntry { // This is the response object for the API call
    private String key;
    private String name;

    public AuthorApiEntry() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
