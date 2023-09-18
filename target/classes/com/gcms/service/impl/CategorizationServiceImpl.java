package com.gcms.service.impl;

import com.gcms.mapper.CategorizationMapper;
import com.gcms.model.MMGridPageVoBean;
import com.gcms.pojo.Categorization;
import com.gcms.pojo.CategorizationExample;
import com.gcms.service.CategorizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CategorizationServiceImpl implements CategorizationService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    CategorizationMapper categorizationMapper;
    @Override
    public Object getAllByLimit(Categorization categorization) {
        int size = 0;

        Integer begin = (categorization.getPage() - 1) * categorization.getLimit();
        categorization.setPage(begin);

        List<Categorization> rows = new ArrayList<>();
        try {
            rows = categorizationMapper.getAllByLimit(categorization);
            if (categorization.getContent()!=null && !"".equals(categorization.getContent())){
                categorizationMapper.viewCount(categorization.getContent());
            }
            size = categorizationMapper.countAllByLimit(categorization);
        } catch (Exception e) {
            logger.error("根据条件查询异常", e);
        }
        MMGridPageVoBean<Categorization> vo = new MMGridPageVoBean<>();
        vo.setTotal(size);
        vo.setRows(rows);

        return vo;
    }

    @Override
    public void deleteById(Long id) {
        categorizationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int add(Categorization categorization) {
        CategorizationExample example = new CategorizationExample();
        example.createCriteria().andContentEqualTo(categorization.getContent());
        List<Categorization> categorizations = categorizationMapper.selectByExample(example);
        if (categorizations.size() > 0){
            return 0;
        }
        return categorizationMapper.insert(categorization);
    }

    @Override
    public List<Categorization> searchWord(String word) {
        CategorizationExample example = new CategorizationExample();
        example.createCriteria().andContentLike("%"+word+"%");
        return categorizationMapper.selectByExample(example);
    }

    @Override
    public void viewWord(String word) {
        categorizationMapper.viewCount(word);
    }

    @Override
    public Categorization getById(Long id) {
        return categorizationMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Categorization categorization) {
        categorizationMapper.updateByPrimaryKeySelective(categorization);
    }

    @Override
    public List<Map<String, Object>> tjByTpye() {
        return categorizationMapper.tjByTpye();
    }
}
