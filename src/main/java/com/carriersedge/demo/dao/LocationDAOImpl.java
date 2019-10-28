package com.carriersedge.demo.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.carriersedge.demo.entity.Curriculum;
import com.carriersedge.demo.entity.Location;

@Repository
public class LocationDAOImpl implements LocationDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveLocation(Location location) {
		sessionFactory.getCurrentSession().saveOrUpdate(location);
	}

	@Override
	public Location getLocation(String name) {
		return (Location) sessionFactory.getCurrentSession().createQuery("from Location where name=:name")
				.setParameter("name", name).uniqueResult();
	}
	
	@Override
	public void addCurriculum(Location location, Curriculum curriculum) {
		location.addCurriculum(curriculum);
		this.saveLocation(location);
	}

}
