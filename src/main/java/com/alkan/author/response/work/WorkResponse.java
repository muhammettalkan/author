package com.alkan.author.response.work;

import com.alkan.author.entity.Work;

import java.util.List;

public class WorkResponse {

    private List<Work> entries;

    public WorkResponse() {
    }

    public WorkResponse(List<Work> entries) {
        this.entries = entries;
    }

    public List<Work> getWorks() {
        return entries;
    }

    public void setWorks(List<Work> works) {
        this.entries = works;
    }
}
