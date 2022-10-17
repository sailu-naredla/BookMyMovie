package com.canvas.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

  /*  @Autowired
    private SecreteRepository secreteRepository;*/

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*SecreteEntity secreteEntity = secreteRepository.findByName(username);
        if (secreteEntity == null) {
            throw new UsernameNotFoundException("Secrete not found with username: " + username);
        }*/
        //plain password N@r3d1a
        return new org.springframework.security.core.userdetails.User("Sailu", "$2a$12$5Bb1UNExY3.icUMSWIo2a.JKoq.QD.uwB/ZAv6xS6/PP./5Y6nJr.",
                new ArrayList<>());
    }
}
