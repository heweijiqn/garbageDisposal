package com.gcms.controller.user;

import com.gcms.pojo.Categorization;
import com.gcms.pojo.User;
import com.gcms.pojo.UserGarbage;
import com.gcms.service.CategorizationService;
import com.gcms.service.UserGarbageService;
import com.gcms.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller("UserGarbageController")
@RequestMapping("/user/garbage")
public class UserGarbageController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    UserGarbageService userGarbageService;
    @Autowired
    UserService userService;
    @Autowired
    private CategorizationService categorizationService;

    @RequestMapping("/list")
    public String list() {
        return "user/garbageList";
    }

    @RequestMapping("/listBaoJie")
    public String listBaoJie() {
        return "user/garbageListBaoJie";
    }

    @RequestMapping("/add")
    public String addPage() {
        return "user/garbageAdd";
    }

    /**
     * 返回查询数据
     */
    @RequestMapping("/getAllByLimit")
    @ResponseBody
    public Object getAllByLimit(UserGarbage userGarbage) {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        userGarbage.setUserId(user.getId());
        return userGarbageService.getAllByLimit(userGarbage);
    }

    /**
     * 返回查询数据
     */
    @RequestMapping("/getAllByLimitBaoJie")
    @ResponseBody
    public Object getAllByLimitBaoJie(UserGarbage userGarbage) {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        userGarbage.setHandUserId(user.getId());
        return userGarbageService.getAllByLimit(userGarbage);
    }


    @RequestMapping(value = "/doAdd")
    @ResponseBody
    @Transactional
    public String doAdd(UserGarbage userGarbage) {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        Categorization c= new Categorization();
        // 相似查询
        List<Categorization> categorizationList = categorizationService.searchWord(userGarbage.getTitle());
        if (categorizationList.size()>0){
            c =  categorizationList.get(0);
        }else {
            c.setValue(1.0);
        }
        try {
            if (user == null || user.getCity()==null){
                return "PHONE_ERR";
            }
            userGarbage.setCreateTime(new Date());
            userGarbage.setUserId(user.getId());
            userGarbage.setProvince(user.getProvince());
            userGarbage.setCity(user.getCity());
            userGarbage.setArea(user.getArea());
            userGarbage.setMoney(userGarbage.getGram() * c.getValue());
            userGarbageService.save(userGarbage);
            return "SUCCESS";
        } catch (Exception e) {
            logger.error("添加异常", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return "ERROR";
        }
    }

    /**
     * 返回查询数据
     */
    @RequestMapping("/search")
    @ResponseBody
    public Object search(String word) {
        // 相似查询
        List<Categorization> categorizationList = categorizationService.searchWord(word);
        if (categorizationList.size()>0){
            return categorizationList.get(0);
        }
        return null;
    }

    /**
     * 删除指南
     */
    @ResponseBody
    @RequestMapping("/del")
    public String delWord(String[] ids) {
        try {
            for (String id : ids){
                userGarbageService.deleteById(Long.parseLong(id));
            }
            return "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
            return "ERR";
        }
    }
}
