package br.com.criandoapi.projeto.Repository;

import br.com.criandoapi.projeto.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.yaml.snakeyaml.events.Event;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {



}
