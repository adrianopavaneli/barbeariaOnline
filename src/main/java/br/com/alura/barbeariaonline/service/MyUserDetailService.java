package br.com.alura.barbeariaonline.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.alura.barbeariaonline.model.MyUserPrincipal;
import br.com.alura.barbeariaonline.model.User;
import br.com.alura.barbeariaonline.repository.UsuarioRepo;

@Service(value = "usuarioService")
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UsuarioRepo usuarioRepo;    

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<User> opt = usuarioRepo.findByUsername(username);
        User user = null;
        if(opt.isPresent()){
            user = opt.get();
        }
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrincipal(user);
    }

    public User save(User usuario) {
        usuario.setPassword(bcryptEncoder.encode(usuario.getPassword()));
        return usuarioRepo.save(usuario);
    }
}