package com.systenezweb.SystenEZ_WEB.repository;

import com.systenezweb.SystenEZ_WEB.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    List<Usuario> findByNomeContainingIgnoreCase(String nome);
}
