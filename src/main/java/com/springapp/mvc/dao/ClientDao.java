package com.springapp.mvc.dao;

import com.springapp.mvc.model.User;
import com.springapp.mvc.model.client.Client;

import java.util.List;


public interface ClientDao {

	Client findById(int id);

	Client findBySSO(String sso);
	
	void save(Client client);
	
	void deleteBySSO(String sso);
	
	List<Client> findAllClients();

}

