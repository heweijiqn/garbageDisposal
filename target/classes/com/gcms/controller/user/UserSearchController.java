package com.gcms.controller.user;

import com.gcms.pojo.Categorization;
import com.gcms.pojo.GarbageType;
import com.gcms.pojo.Search;
import com.gcms.pojo.User;
import com.gcms.service.CategorizationService;
import com.gcms.service.GarbageTypeService;
import com.gcms.service.SearchService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller("UserSearchController")
@RequestMapping("/user/search")
public class UserSearchController {
    @Autowired
    private SearchService searchService;
    @Autowired
    private CategorizationService categorizationService;
    @Autowired
    private GarbageTypeService garbageTypeService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/log")
    public String fenleiList() {
        return "user/searchLog";
    }


    @RequestMapping("/index")
    public String index(String word, Model model) {
        List<Search> searchList = new ArrayList<>();
        List<Search> topList = new ArrayList<>();
        List<Categorization> categorizationList = new ArrayList<>();
        if (word != null && !"".equals(word)){
            // 相似查询
            categorizationList = categorizationService.searchWord(word);
            categorizationService.viewWord(word);
            model.addAttribute("cList", categorizationList);
            model.addAttribute("wordName", word);
            if (categorizationList.size()>0){
                Categorization c = categorizationList.get(0);
                GarbageType byId = garbageTypeService.getById(c.getType());
                model.addAttribute("wordTpye", byId.getType());
                model.addAttribute("typeTipTitle", byId.getType()+"是指");
                model.addAttribute("typeTip", byId.getTip());
                model.addAttribute("typeIncludeTitle", byId.getType()+"主要包括");
                model.addAttribute("typeInclude", byId.getInclude());
                model.addAttribute("typeAskTitle", byId.getType()+"投放要求");
                model.addAttribute("typeAsk", byId.getAsk());
                model.addAttribute("tt", "属于");
            }else {
                model.addAttribute("tt", "  目前本系统未收录!!!");
            }

            Search search = new Search();
            search.setContent(word);
            Search byContent = searchService.getByContent(search);
            if (byContent !=null){
                byContent.setViewCount(byContent.getViewCount()+1);
                searchService.update(byContent);
            }else {
                search.setViewCount(1L);
                search.setCreateTime(new Date());
                searchService.save(search);
            }
        }
        // TOP 10
        topList = searchService.top(10);
        model.addAttribute("tList", topList);
        // 最近查询
        searchList = searchService.newSearch(10);
        model.addAttribute("sList", searchList);
        return "search";
    }
    /**
     * 返回查询数据
     */
    @RequestMapping("/getAllByLimit")
    @ResponseBody
    public Object getAllByLimit(Search search) {
        return searchService.getAllByLimit(search);
    }

    @RequestMapping("/")
    @ResponseBody
    @Transactional
    public Object search(Search search) {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        try {
            Search old = searchService.getByContent(search);
            // 之前有记录
            if (old != null){
                search.setViewCount(old.getViewCount()+1);
                searchService.update(search);
            }else {
                search.setViewCount(1L);
                search.setUserId(user.getId());
                search.setCreateTime(new Date());
                searchService.save(search);
            }

            Categorization categorization = new Categorization();
            categorization.setContent(search.getContent());
            // 增加浏览量
            categorization.setViewCount(-1L);

           return categorizationService.getAllByLimit(categorization);
        } catch (Exception e) {
            logger.error("查询异常", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return "ERROR";
        }
    }


}
