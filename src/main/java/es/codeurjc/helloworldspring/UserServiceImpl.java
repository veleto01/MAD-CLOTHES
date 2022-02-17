package es.codeurjc.helloworldspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements ServiceUser{
     @Autowired
     private UsuarioRepository Usuario_Repository;
     @Override
     public Boolean saveUser(Usuario user) {
          try {
        	  Usuario_Repository.save(user);
               return true;
          } catch (Exception e) {
               return false;
          }
     }
}