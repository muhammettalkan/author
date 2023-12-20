package com.alkan.author.response.work;


import java.util.List;

public class WorksApiResponse {

    private int size;
    private WorkApiLinks links;
    private List<WorkApiEntry> entries;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<WorkApiEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<WorkApiEntry> entries) {
        this.entries = entries;
    }

    public WorkApiLinks getLinks() {
        return links;
    }

    public void setLinks(WorkApiLinks links) {
        this.links = links;
    }
}
