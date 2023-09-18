package com.gcms.controller.user;


import com.gcms.pojo.Notice;
import com.gcms.service.NoticeService;
import com.gcms.utils.MyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * 健康指南
 */
@Controller("UserNoticeController")
@RequestMapping("/user/notice")
public class UserNoticeController {
    @Autowired
    private NoticeService noticeService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 查看详情页面/user/xqWord.html
     */
    @RequestMapping("/xq")
    public String xq(Long id, Model model) {
        noticeService.view(id);
        Notice word = noticeService.getById(id);
        System.out.println(word.getContent());
        model.addAttribute("c", word.getContent());
        model.addAttribute("title", word.getTitle());
        model.addAttribute("view", word.getViewCount());
        model.addAttribute("time", MyUtils.getDate2String(word.getCreateTime()));
        return "/user/xqWord";
    }

    /**
     * 普通用户查看列表/user/wordList.html
     */
    @RequestMapping("/list")
    public String list() {
        return "/user/wordList";
    }

    /**
     * 医生查看列表/user/wordListDoctor.html
     */
    @RequestMapping("/listAdmin")
    public String listDoctor() {
        return "/user/wordListAdmin";
    }

    /**
     * 医生发布指南页面/user/word.html
     */
    @RequestMapping("/publish")
    public String publish() {
        return "/user/word";
    }

    /**
     * 添加到数据库
     */
    @ResponseBody
    @RequestMapping("/addWord")
    public String addWord(Notice notice) {
        try {
            notice.setCreateTime(new Date());
            notice.setViewCount(0L);
            noticeService.add(notice);
            return "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
            return "ERR";
        }
    }

    /**
     * 获取所有指南数据
     */
    @RequestMapping("/getAllWordByLimit")
    @ResponseBody
    public Object getAllWordByLimit(Notice word) {
        return noticeService.getAllByLimit(word);
    }

    /**
     * 删除指南
     */
    @ResponseBody
    @RequestMapping("/delWord")
    public String delWord(String[] ids) {
        try {
            for (String id : ids){
                noticeService.deleteById(Long.parseLong(id));
            }
            return "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
            return "ERR";
        }
    }
}
