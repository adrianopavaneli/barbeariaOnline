package br.com.alura.barbeariaonline.service;




import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.alura.barbeariaonline.model.MyUserPrincipal;
import br.com.alura.barbeariaonline.model.Usuario;
import br.com.alura.barbeariaonline.repository.UsuarioRepository;

@Service(value = "usuarioService")
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepo;    

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<Usuario> opt = usuarioRepo.findByUsername(username);
        Usuario usuario = null;
        if(opt.isPresent()){
            usuario = opt.get();
        }
        if (usuario == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrincipal(usuario);
    }

    public Usuario save(Usuario usuario) {
        usuario.setPassword(bcryptEncoder.encode(usuario.getPassword()));
        return usuarioRepo.save(usuario);
    }
}