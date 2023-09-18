package com.gcms.service;

import com.gcms.pojo.UserGarbage;

import java.util.List;
import java.util.Map;

public interface UserGarbageService {
    Object getAllByLimit(UserGarbage userGarbage);

    void save(UserGarbage userGarbage);

    void deleteById(long parseLong);

    List<Map<String, Object>> tjMoney(Long id);

    List<Map<String, Object>> tjQuanGuo();

    List<Map<String, Object>> tjByTpye();
}
