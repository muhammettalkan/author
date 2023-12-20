package com.alkan.author.dto;

public class WorkDto { // Data Transfer Object for Work, this will be used to send data to the client
    private String id;
    private String title;
    private String authorId;

    public WorkDto() {
    }

    public WorkDto(String id, String title, String authorId) {
        this.id = id;
        this.title = title;
        this.authorId = authorId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }
}
