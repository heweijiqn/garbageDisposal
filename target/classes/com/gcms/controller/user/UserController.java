package com.gcms.controller.user;

import com.gcms.model.ResultMap;
import com.gcms.pojo.User;
import com.gcms.service.UserRoleService;
import com.gcms.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("User")
@RequestMapping("/user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final ResultMap resultMap;
    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    public UserController(ResultMap resultMap) {
        this.resultMap = resultMap;
    }

    @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
    public ResultMap getMessage() {
        return resultMap.success().message("您拥有用户权限，可以获得该接口的信息！");
    }

    @RequestMapping(value = "/editUserPage")
    public String editUserPage(Long userId, Model model) {
        model.addAttribute("manageUser", userId);
        if (null != userId) {
            User user = userService.selectByPrimaryKey(userId);
            model.addAttribute("manageUser", user);
        }
        return "user/userEdit";
    }

    @ResponseBody
    @RequestMapping("/updateUser")
    public String updateUser(User user) {
        return userService.updateUser(user);
    }
}
