package com.systenezweb.SystenEZ_WEB.controller;

import com.systenezweb.SystenEZ_WEB.model.Usuario;
import com.systenezweb.SystenEZ_WEB.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/gravarUsuario")
    public String cadastrarUsuario(@ModelAttribute Usuario usuario, Model model) {
        usuarioService.criar(usuario);
        return "redirect:/cadastrarUsuario";
    }

    @GetMapping("/excluir-usuario")
    public String excluirUsuario(Model model, @RequestParam String id){
        Integer idUsuario = Integer.parseInt(id);

        usuarioService.excluir(idUsuario);
        return "redirect:/listaUsuarios";
    }

    @GetMapping("/buscarUsuario")
    public String buscarUsuario(@RequestParam String nome, Model model) {
        model.addAttribute("usuarios", usuarioService.buscarPorNome(nome));
        return "listaUsuarios";
    }

}
