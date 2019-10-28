package com.carriersedge.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.carriersedge.demo.dto.UserCurriculumDTO;
import com.carriersedge.demo.entity.User;
import com.carriersedge.demo.service.UserCurriculumService;
import com.carriersedge.demo.service.UserService;

@Controller
@RequestMapping("/demo")
public class DemoController {

	@Autowired
    private UserService userService;
	
	
	@Autowired
    private UserCurriculumService userCurriculumService;
	
	
	@RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
	public void createAllUserCurriculums(@RequestBody UserCurriculumDTO userCurriculumDTO) {
		User createdBy = userService.getAdminUser();
		User user = userService.getUserById(userCurriculumDTO.getUserId());
		boolean secondary = userCurriculumDTO.isSecondary();
		if (!secondary) {
			userCurriculumService.createAllUserCurriculums(user, createdBy);
		} else {
			// secondary service logic goes here
		}
	}
}
