package com.gcms.service;

import com.gcms.pojo.Notice;

public interface NoticeService {
    void update(Notice notice);

    void add(Notice notice);

    void deleteById(Long id);

    Object getAllByLimit(Notice notice);

    Notice getById(Long id);

    void view(Long id);
}
