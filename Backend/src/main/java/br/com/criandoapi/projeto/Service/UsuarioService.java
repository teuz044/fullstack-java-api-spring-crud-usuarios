package br.com.criandoapi.projeto.Service;

import br.com.criandoapi.projeto.Repository.UsuarioRepository;
import br.com.criandoapi.projeto.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;
    private PasswordEncoder passwordEncoder;
    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }
        public List<Usuario> listarUsuario () {
            List<Usuario> lista  = repository.findAll();
            return lista;
        }
        public Usuario criarUsuario (Usuario usuario) {
            String encoder = this.passwordEncoder.encode(usuario.getSenha());
            usuario.setSenha(encoder);
            Usuario usuarioNovo = repository.save(usuario);
            return usuarioNovo;
        }
        public Usuario alterarUsuario (Usuario usuario) {
            String encoder = this.passwordEncoder.encode(usuario.getSenha());
            usuario.setSenha(encoder);
            Usuario usuarioNovo = repository.save(usuario);
            return usuarioNovo;
        }

        public Boolean deletarUsuario (Integer id) {
            repository.deleteById(id);
            return true;
    }

    public Boolean validarSenha(Usuario usuario) {
        String senha = repository.getReferenceById(usuario.getId()).getSenha();
        Boolean valid = passwordEncoder.matches(usuario.getSenha(), senha);
        return valid;
    }
}
