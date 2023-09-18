package com.gcms.controller.user;

import com.gcms.pojo.Appointment;
import com.gcms.pojo.User;
import com.gcms.service.AppointmentService;
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

@Controller("UserApplyController")
@RequestMapping("/user/apply")
public class UserApplyController {
    @Autowired
    private AppointmentService appointmentService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 分类列表页面
     */
    @RequestMapping("/applyListBaoJie")
    public String applyListBaoJie() {
        return "user/applyListBaoJie";
    }

    @RequestMapping("/applyList")
    public String fenleiList() {
        return "user/applyList";
    }
    /**
     * 返回查询数据
     */
    @RequestMapping("/getAllByLimit")
    @ResponseBody
    public Object getAllByLimit(Appointment appointment) {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        appointment.setUserId(user.getId());
        return appointmentService.getAllByLimit(appointment);
    }


    @RequestMapping("/getAllByLimitBaoJie")
    @ResponseBody
    public Object getAllByLimitBaoJie(Appointment appointment) {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        appointment.setHandleUserId(user.getId());
        return appointmentService.getAllByLimit(appointment);
    }

    @RequestMapping(value = "/del")
    @ResponseBody
    @Transactional
    public String delUser(Long id) {
        try {
            appointmentService.deleteById(id);
            return "SUCCESS";
        } catch (Exception e) {
            logger.error("删除异常", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return "ERROR";
        }
    }

    @RequestMapping(value = "/add")
    public String addUserPage() {
        return "user/applyAdd";
    }

    @RequestMapping(value = "/doAdd")
    @ResponseBody
    @Transactional
    public String doAdd(Appointment appointment) {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        try {
            appointment.setUserId(user.getId());
            appointment.setCreateTime(new Date());
            // 状态:1申请中,2申请通过,3不通过,4已完成
            appointment.setStatus(1);
            appointmentService.add(appointment);
            return "SUCCESS";
        } catch (Exception e) {
            logger.error("添加异常", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return "ERROR";
        }
    }

    @RequestMapping(value = "/chStatus")
    @ResponseBody
    @Transactional
    public String chStatus(Appointment appointment) {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        try {
            appointment.setHandleUserId(user.getId());
            appointmentService.update(appointment);
            return "SUCCESS";
        } catch (Exception e) {
            logger.error("添加异常", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return "ERROR";
        }
    }
}
