package com.gcms.service;

import com.gcms.pojo.GarbageType;

public interface GarbageTypeService {
    Object getAllByLimit(GarbageType pojo);

    void deleteById(Long id);

    void add(GarbageType pojo);

    void update(GarbageType pojo);

    GarbageType getById(Integer id);
}
