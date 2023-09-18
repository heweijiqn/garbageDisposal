package com.gcms.service.impl;

import com.gcms.mapper.GarbageTypeMapper;
import com.gcms.model.MMGridPageVoBean;
import com.gcms.pojo.GarbageType;
import com.gcms.service.GarbageTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class GarbageTypeServiceImpl implements GarbageTypeService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    GarbageTypeMapper garbageTypeMapper;
    @Override
    public Object getAllByLimit(GarbageType pojo) {
        int size = 0;

        Integer begin = (pojo.getPage() - 1) * pojo.getLimit();
        pojo.setPage(begin);

        List<GarbageType> rows = new ArrayList<>();
        try {
            rows = garbageTypeMapper.getAllByLimit(pojo);
            size = garbageTypeMapper.countAllByLimit(pojo);
        } catch (Exception e) {
            logger.error("根据条件查询异常", e);
        }
        MMGridPageVoBean<GarbageType> vo = new MMGridPageVoBean<>();
        vo.setTotal(size);
        vo.setRows(rows);

        return vo;
    }

    @Override
    public void deleteById(Long id) {
        garbageTypeMapper.deleteByPrimaryKey(Integer.parseInt(id+""));
    }

    @Override
    public void add(GarbageType pojo) {
        garbageTypeMapper.insert(pojo);
    }

    @Override
    public void update(GarbageType pojo) {
        garbageTypeMapper.updateByPrimaryKeySelective(pojo);
    }

    @Override
    public GarbageType getById(Integer id) {
        return garbageTypeMapper.selectByPrimaryKey(id);
    }
}
