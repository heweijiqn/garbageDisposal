package com.gcms.service.impl;

import com.gcms.mapper.SearchMapper;
import com.gcms.model.MMGridPageVoBean;
import com.gcms.pojo.Categorization;
import com.gcms.pojo.Search;
import com.gcms.pojo.SearchExample;
import com.gcms.service.SearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    SearchMapper searchMapper;

    @Override
    public Search getByContent(Search search) {
        SearchExample example = new SearchExample();
        example.createCriteria().andContentLike(search.getContent());
        List<Search> searches = searchMapper.selectByExample(example);
        if (searches.size() >0 ){
            return searches.get(0);
        }
        return null;
    }

    @Override
    public void update(Search search) {
        searchMapper.updateByPrimaryKeySelective(search);
    }

    @Override
    public void save(Search search) {
        searchMapper.insert(search);
    }

    @Override
    public Object getAllByLimit(Search search) {
        int size = 0;

        Integer begin = (search.getPage() - 1) * search.getLimit();
        search.setPage(begin);

        List<Categorization> rows = new ArrayList<>();
        try {
            rows = searchMapper.getAllByLimit(search);
            size = searchMapper.countAllByLimit(search);
        } catch (Exception e) {
            logger.error("根据条件查询异常", e);
        }
        MMGridPageVoBean<Categorization> vo = new MMGridPageVoBean<>();
        vo.setTotal(size);
        vo.setRows(rows);

        return vo;
    }

    @Override
    public List<Search> newSearch(int i) {
        return searchMapper.newSearch(i);
    }

    @Override
    public List<Search> top(int i) {
        return searchMapper.top(i);
    }

}
