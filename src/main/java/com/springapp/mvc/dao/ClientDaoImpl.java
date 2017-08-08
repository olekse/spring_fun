package com.springapp.mvc.dao;

import com.springapp.mvc.model.User;
import com.springapp.mvc.model.client.Client;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("clientDao")
public class ClientDaoImpl extends AbstractDao<Integer, Client> implements ClientDao {

	static final Logger logger = LoggerFactory.getLogger(ClientDaoImpl.class);


	@Override
	public Client findById(int id) {
		Client client = getByKey(id);
		if(client != null){
			//Hibernate.initialize(client.getBankCards());
		}
		return client;
	}

	@Override
	public Client findBySSO(String sso) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("ssoId", sso));
		Client client = (Client) criteria.uniqueResult();

		if(client != null){
			//Hibernate.initialize(client.getBankCards());
		}
		return client;
	}

	@Override
	public void save(Client client) {
		persist(client);
	}

	@Override
	public void deleteBySSO(String sso) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("ssoId", sso));
		Client client = (Client)crit.uniqueResult();
		delete(client);
	}

	@Override
	public List<Client> findAllClients() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("firstName"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Client> clients = (List<Client>) criteria.list();


		for(Client client : clients){
			//Hibernate.initialize(client.getBankCards());
		}
		return clients;
	}


}
