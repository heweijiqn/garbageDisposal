package com.gcms.controller.admin;

import com.gcms.pojo.GarbageType;
import com.gcms.service.GarbageTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller("GarbageTypeController")
@RequestMapping("/admin/type")
public class GarbageTypeController {
    @Autowired
    private GarbageTypeService garbageTypeService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 分类列表页面
     */
    @RequestMapping("/typeList")
    public String fenleiList() {
        return "sa/typeList";
    }

    @RequestMapping("user/typeList")
    public String typeUserList() {
        return "sa/typeUserList";
    }

    /**
     * 返回查询数据
     */
    @RequestMapping("/getAllByLimit")
    @ResponseBody
    public Object getAllByLimit(GarbageType categorization) {
        return garbageTypeService.getAllByLimit(categorization);
    }

    @RequestMapping(value = "/del")
    @ResponseBody
    @Transactional
    public String delUser(Long id) {
        try {
            garbageTypeService.deleteById(id);
            return "SUCCESS";
        } catch (Exception e) {
            logger.error("删除异常", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return "ERROR";
        }
    }

    @RequestMapping(value = "/add")
    public String addUserPage() {
        return "sa/typeAdd";
    }

    @RequestMapping(value = "/updateOne")
    public String update(Integer id, Model model) {
        GarbageType g = garbageTypeService.getById(id);
        model.addAttribute("gtype", g);
        return "sa/typeAdd";
    }

    @RequestMapping(value = "/doAdd")
    @ResponseBody
    @Transactional
    public String doAdd(GarbageType categorization) {
        try {
            categorization.setCreateTime(new Date());
            garbageTypeService.add(categorization);
            return "SUCCESS";
        } catch (Exception e) {
            logger.error("添加异常", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return "ERROR";
        }
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    @Transactional
    public String update(GarbageType categorization) {
        try {
            garbageTypeService.update(categorization);
            return "SUCCESS";
        } catch (Exception e) {
            logger.error("修改异常", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return "ERROR";
        }
    }
}
