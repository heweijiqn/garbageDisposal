package com.gcms.service;

import com.gcms.pojo.Categorization;

import java.util.List;
import java.util.Map;

public interface CategorizationService {
    Object getAllByLimit(Categorization categorization);

    void deleteById(Long id);

    int add(Categorization categorization);

    List<Categorization> searchWord(String word);

    void viewWord(String word);

    Categorization getById(Long id);

    void update(Categorization categorization);

    List<Map<String, Object>> tjByTpye();
}
