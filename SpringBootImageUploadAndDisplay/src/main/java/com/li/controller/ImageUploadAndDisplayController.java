package com.li.controller;

import com.li.service.UserService;
import com.qingwenwei.exception.BadRequestException;
import com.qingwenwei.web.dto.UserSettingsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * 图片上传和加载到前端显示
 */
@Controller
public class ImageUploadAndDisplayController {

    @Autowired
    private UserService userService;
    /**
     *
     */
    @RequestMapping(value = "/user/settings", method = RequestMethod.POST)
    public String handleFileUpload(@ModelAttribute("userSettingsDto") UserSettingsDto userSettingsDto, Model model) {

        if (null == userSettingsDto) {
//            throw new BadRequestException("UserSettingsDto cound not be null.");
        }
        Map<String, Object> attributes = this.userService.updateUserProfile(userSettingsDto);
        if (null == attributes) {
//            throw new ResourceNotFoundException("attributes not found.");
        }
        model.addAllAttributes(attributes);
        return "forum/user-settings";
    }

}
