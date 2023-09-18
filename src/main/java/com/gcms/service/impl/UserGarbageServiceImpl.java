package com.gcms.service.impl;

import com.gcms.mapper.UserGarbageMapper;
import com.gcms.model.MMGridPageVoBean;
import com.gcms.pojo.Appointment;
import com.gcms.pojo.UserGarbage;
import com.gcms.service.UserGarbageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserGarbageServiceImpl implements UserGarbageService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    UserGarbageMapper userGarbageMapper;

    @Override
    public Object getAllByLimit(UserGarbage userGarbage) {
        int size = 0;

        Integer begin = (userGarbage.getPage() - 1) * userGarbage.getLimit();
        userGarbage.setPage(begin);

        List<Appointment> rows = new ArrayList<>();
        try {
            rows = userGarbageMapper.getAllByLimit(userGarbage);
            size = userGarbageMapper.countAllByLimit(userGarbage);
        } catch (Exception e) {
            logger.error("根据条件查询异常", e);
        }
        MMGridPageVoBean<Appointment> vo = new MMGridPageVoBean<>();
        vo.setTotal(size);
        vo.setRows(rows);

        return vo;
    }

    @Override
    public void save(UserGarbage userGarbage) {
        userGarbageMapper.insert(userGarbage);
    }

    @Override
    public void deleteById(long id) {
        userGarbageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Map<String, Object>> tjMoney(Long id) {
        return userGarbageMapper.tjMoney(id);
    }

    @Override
    public List<Map<String, Object>> tjQuanGuo() {
        return userGarbageMapper.tjQuanGuo();
    }

    @Override
    public List<Map<String, Object>> tjByTpye() {
        return userGarbageMapper.tjByTpye();
    }
}
