package com.alkan.author.response.author;

import java.util.List;

public class AuthorApiResponse { // This is the response object for the API call
    private int numFound;
    private List<AuthorApiEntry> docs;

    public int getNumFound() {
        return numFound;
    }

    public void setNumFound(int numFound) {
        this.numFound = numFound;
    }

    public List<AuthorApiEntry> getDocs() {
        return docs;
    }

    public void setDocs(List<AuthorApiEntry> docs) {
        this.docs = docs;
    }
}
