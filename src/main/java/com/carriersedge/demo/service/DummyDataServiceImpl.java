package com.carriersedge.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carriersedge.demo.dao.CarrierDAO;
import com.carriersedge.demo.dao.CurriculumDAO;
import com.carriersedge.demo.dao.LocationDAO;
import com.carriersedge.demo.dao.UserDAO;
import com.carriersedge.demo.entity.Carrier;
import com.carriersedge.demo.entity.Curriculum;
import com.carriersedge.demo.entity.Location;
import com.carriersedge.demo.entity.User;

@Service
public class DummyDataServiceImpl implements DummyDataService {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private LocationDAO locationDAO;
	
	@Autowired
	private CurriculumDAO curriculumDAO;
	
	@Autowired
	private CarrierDAO carrierDAO;
	
	
	
	@Override
	@Transactional
	public void createAdminUser() {
		Carrier carrier = carrierDAO.getCarrier("carrier1");
		User admin = new User();
		admin.setUsername("admin");
		admin.setCarrier(carrier);
        userDAO.saveUser(admin);
	}
	
	@Override
	@Transactional
	public void createUser() {
		Carrier carrier1 = carrierDAO.getCarrier("carrier1");
		Location location1 = locationDAO.getLocation("location1");
		User user1 = new User();
		user1.setUsername("client1");
		user1.setLocation(location1);
		user1.setCarrier(carrier1);
		userDAO.saveUser(user1);
		
		
		Carrier carrier2 = carrierDAO.getCarrier("carrier2");
		Location location2 = locationDAO.getLocation("location2");
		User user2 = new User();
		user2.setUsername("client2");
		user2.setLocation(location2);
		user2.setCarrier(carrier2);
		userDAO.saveUser(user2);
	}
	

	@Override
	@Transactional
	public void createLocations() {
		Location location1 = new Location();
		location1.setName("location1");
		locationDAO.saveLocation(location1);
		
		Location location2 = new Location();
		location2.setName("location2");
		locationDAO.saveLocation(location2);
	}

	@Override
	@Transactional
	public void createCurriculums() {
		Curriculum curriculum1 = new Curriculum();
		curriculum1.setName("curriculum1");
		curriculumDAO.saveCurriculum(curriculum1);
		
		Curriculum curriculum2 = new Curriculum();
		curriculum2.setName("curriculum2");
		curriculumDAO.saveCurriculum(curriculum2);
	}


	@Override
	@Transactional
	public void createCarrier() {
		Carrier carrier1 = new Carrier();
		carrier1.setName("carrier1");
		carrierDAO.saveCarrier(carrier1);
		
		Carrier carrier2 = new Carrier();
		carrier2.setName("carrier2");
		carrierDAO.saveCarrier(carrier2);
	}

	@Override
	@Transactional
	public void createLocationCurriculums() {
		Location location1 = locationDAO.getLocation("location1");
		Curriculum curriculum1 = curriculumDAO.getCurriculum("curriculum1");
		Curriculum curriculum2 = curriculumDAO.getCurriculum("curriculum2");
		locationDAO.addCurriculum(location1, curriculum1);
		locationDAO.addCurriculum(location1, curriculum2);
		
		Location location2 = locationDAO.getLocation("location2");
		locationDAO.addCurriculum(location2, curriculum2);
	}

}
