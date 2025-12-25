package com.systenezweb.SystenEZ_WEB.service;

import com.systenezweb.SystenEZ_WEB.model.Usuario;
import com.systenezweb.SystenEZ_WEB.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario criar(Usuario usuario) {
        usuario.setId(null);
        usuarioRepository.save(usuario);
        return usuario;
    }

    public List<Usuario> buscarTodos(){
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Integer id){
        return usuarioRepository.findById(id).orElseThrow();
    }

    public void excluir(Integer id){
        Usuario usuarioEncontrado = buscarPorId(id);
        usuarioRepository.deleteById(usuarioEncontrado.getId());
    }

    public Usuario atualizar(Integer id, Usuario usuario){
        Usuario usuarioEncontrado = buscarPorId(id);

        usuarioEncontrado.setNome(usuario.getNome());
        usuarioEncontrado.setSenha(usuario.getSenha());
        usuarioEncontrado.setTipo(usuario.getTipo());
        

        usuarioRepository.save(usuarioEncontrado);
        return usuarioEncontrado;
    }

    public List<Usuario> buscarPorNome(String nome) {
        return usuarioRepository.findByNomeContainingIgnoreCase(nome);
    }

}
