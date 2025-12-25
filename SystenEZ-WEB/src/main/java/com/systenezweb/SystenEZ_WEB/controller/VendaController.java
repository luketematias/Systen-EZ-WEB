package com.systenezweb.SystenEZ_WEB.controller;

import com.systenezweb.SystenEZ_WEB.model.Venda;
import com.systenezweb.SystenEZ_WEB.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VendaController {

    @Autowired
    VendaService vendaService;

    @PostMapping("/registrarVenda")
    public String cadastrarVenda(@ModelAttribute Venda venda) {
        vendaService.criar(venda);
        return "redirect:/registroDeVendas";
    }

    @GetMapping("/buscarVenda")
    public String buscarVenda(@RequestParam("nome") String nome, Model model) {
        model.addAttribute("vendas", vendaService.buscarPorNome(nome));
        return "relatorioVendas";
    }

}
