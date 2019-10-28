package com.carriersedge.demo.dao;

import com.carriersedge.demo.entity.Carrier;

public interface CarrierDAO {
	public Carrier getCarrier(String name);
	
	public void saveCarrier(Carrier carrier);
}
