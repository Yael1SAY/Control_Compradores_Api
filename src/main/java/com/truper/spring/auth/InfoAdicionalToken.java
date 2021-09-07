package com.truper.spring.auth;

import com.truper.spring.model.Comprador;
import com.truper.spring.service.ICompradorServiceAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InfoAdicionalToken implements TokenEnhancer {

    @Autowired
    private ICompradorServiceAuth compradorService;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        //Envia el id del usuario y nombre de usuario al autenticar
        Comprador comprador = compradorService.findByUsername2(oAuth2Authentication.getName());
        Map<String, Object> info = new HashMap<>();
        info.put("clave", comprador.getClave());
        info.put("nombre",comprador.getNombre());
        info.put("apellidoPaterno",comprador.getApellidoPaterno());
        info.put("apellidoMaterno",comprador.getApellidoMaterno());
        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(info);
        return oAuth2AccessToken;
    }
}
