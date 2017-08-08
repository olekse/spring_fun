package com.springapp.mvc.service;

import com.springapp.mvc.model.User;
import com.springapp.mvc.model.client.Client;

import java.util.List;


public interface ClientService {
	
	Client findById(int id);

	Client findBySSO(String sso);
	
	void saveClient(Client user);
	
	void updateClient(Client user);
	
	void deleteClientBySSO(String sso);

	List<Client> findAllClients();
	
	boolean isUserSSOUnique(Integer id, String sso);

}