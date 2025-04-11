package br.com.api.CrudUsuarios.repository;

import br.com.api.CrudUsuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}

