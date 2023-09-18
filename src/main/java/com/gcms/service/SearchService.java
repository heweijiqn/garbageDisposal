package com.gcms.service;

import com.gcms.pojo.Search;

import java.util.List;

public interface SearchService {
    Search getByContent(Search search);

    void update(Search search);

    void save(Search search);

    Object getAllByLimit(Search search);

    List<Search> newSearch(int i);

    List<Search> top(int i);
}
