package com.carriersedge.demo;


import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.carriersedge.demo.controller.DemoController;
import com.carriersedge.demo.dto.UserCurriculumDTO;
import com.carriersedge.demo.entity.User;
import com.carriersedge.demo.entity.UserCurriculum;
import com.carriersedge.demo.service.UserCurriculumService;
import com.carriersedge.demo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

@Transactional
@RunWith(SpringRunner.class)
@WebMvcTest(DemoController.class)
public class DemoControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserCurriculumService userCurriculumService;
	
	
	@Test
    public void shouldCreateUserCurriculum() throws Exception {
		
		long userId = 2;
		boolean secondary = false;
		UserCurriculumDTO userCurriculumDTO = new UserCurriculumDTO(userId, secondary);
		
		User user = userService.getUserById(userId);
		List<UserCurriculum>  userCurriculums = userCurriculumService.getUserCurriculums(user.getUsername());
	    assertTrue(userCurriculums.isEmpty());
	    
		ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
	    String requestJson = ow.writeValueAsString(userCurriculumDTO);
		
	    mockMvc.perform(post("/demo/").contentType(new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8")))
	            .content(requestJson))
	            .andExpect(status().is(201));
	    
	    
	    userCurriculums = userCurriculumService.getUserCurriculums(user.getUsername());
	    assertTrue(!userCurriculums.isEmpty());
    }
}
