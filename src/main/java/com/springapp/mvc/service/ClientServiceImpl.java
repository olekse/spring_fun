package com.springapp.mvc.service;

import com.springapp.mvc.dao.ClientDao;
import com.springapp.mvc.model.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by OleksandrSerediuk on 08.06.2017.
 */

@Service("clientService")
@Transactional
public class ClientServiceImpl implements ClientService {


    @Autowired
    private ClientDao dao;

    @Lazy
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Client findById(int id) {
        return dao.findById(id);
    }

    @Override
    public Client findBySSO(String sso) {
        return dao.findBySSO(sso);
    }

    @Override
    public void saveClient(Client client) {
        client.setPassword(passwordEncoder.encode(client.getPassword()));

        dao.save(client);
    }

    @Override
    public void updateClient(Client client) {
        Client entity = dao.findById(client.getId());
        if(entity!=null){
            entity.setSsoId(client.getSsoId());
            if(!client.getPassword().equals(entity.getPassword())){
                entity.setPassword(passwordEncoder.encode(client.getPassword()));
            }
        }
    }

    @Override
    public void deleteClientBySSO(String sso) {
        dao.deleteBySSO(sso);
    }

    @Override
    public List<Client> findAllClients() {
        return dao.findAllClients();
    }

    @Override
    public boolean isUserSSOUnique(Integer id, String sso) {
        Client client = findBySSO(sso);
        return ( client == null || ((id != null) && (client.getId() == id)));
    }
}
