package com.springapp.mvc.security;

import java.util.ArrayList;
import java.util.List;

import com.springapp.mvc.model.User;
import com.springapp.mvc.model.UserProfile;
import com.springapp.mvc.model.client.Client;
import com.springapp.mvc.service.ClientService;
import com.springapp.mvc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{

	static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
	
	@Autowired
	private ClientService clientService;
	
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String ssoId)
			throws UsernameNotFoundException {
		Client client = clientService.findBySSO(ssoId);
		logger.info("Client : {}", client);
		if(client==null){
			logger.info("Client not found");
			throw new UsernameNotFoundException("Client not found");
		}
			return new org.springframework.security.core.userdetails.User(client.getSsoId(), client.getPassword(),
				 true, true, true, true, getGrantedAuthorities(client));
	}

	
	private List<GrantedAuthority> getGrantedAuthorities(User user){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for(UserProfile userProfile : user.getUserProfiles()){
			logger.info("Client : {}", userProfile);
			authorities.add(new SimpleGrantedAuthority("ROLE_"+userProfile.getType()));
		}
		logger.info("authorities : {}", authorities);
		return authorities;
	}
	
}
