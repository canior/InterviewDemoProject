package com.carriersedge.demo.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.carriersedge.demo.entity.Carrier;

@Repository
public class CarrierDAOImpl implements CarrierDAO {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public Carrier getCarrier(String name) {
		return (Carrier) sessionFactory.getCurrentSession().createQuery("from Carrier where name=:name")
				.setParameter("name", name).uniqueResult();
	}
	
	@Override
	public void saveCarrier(Carrier carrier) {
		sessionFactory.getCurrentSession().saveOrUpdate(carrier);
	}

}
