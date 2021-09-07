package com.truper.spring.service;

import com.truper.spring.dao.ICompradorAuthDao;
import com.truper.spring.model.Comprador;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class compradorServiceAuth implements UserDetailsService, ICompradorServiceAuth{

    private Logger logger = LoggerFactory.getLogger(compradorServiceAuth.class);

    @Autowired
    private ICompradorAuthDao compradorDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String clave) throws UsernameNotFoundException {

        Comprador comprador =compradorDao.findByUsername2(clave);

        if (comprador == null){
            logger.error("Error en el Login: no existe el comprador con clave: " + clave + " en el sistema");
            throw new UsernameNotFoundException("Error en el Login: no existe el comprador con clave : " + clave + " en el sistema");
        }
        List<GrantedAuthority> authorities = comprador.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getNombreRol()))
                .peek(authority -> logger.info("Role: " + authority.getAuthority()))
                .collect(Collectors.toList());
        return new User(comprador.getClave(), comprador.getPassword(), comprador.isEstatus(), true, true, true, authorities);
    }

    @Override
    @Transactional(readOnly = true)
    public Comprador findByUsername2(String clave) {
        return compradorDao.findByUsername2(clave);
    }
}
