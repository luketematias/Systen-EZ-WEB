package com.systenezweb.SystenEZ_WEB.controller;

import com.systenezweb.SystenEZ_WEB.model.Produto;
import com.systenezweb.SystenEZ_WEB.model.Usuario;
import com.systenezweb.SystenEZ_WEB.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ProdutoController {
    @Autowired
    ProdutoService produtoService;

    @PostMapping("/gravarProduto")
    public String cadastrarProduto(@Valid @ModelAttribute("produto") Produto produto, BindingResult result, Model model) {

        if (result.hasErrors()) {

            List<String> erros = result.getFieldErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());

            model.addAttribute("erros", erros);
            return "cadastroProdutos";
        }

        produtoService.criar(produto);
        model.addAttribute("sucesso", "Produto cadastrado com sucesso!");
        return "cadastroProdutos";
    }

    @GetMapping("/excluir-produto")
    public String excluirProduto(Model model, @RequestParam String id){
        Integer idProduto = Integer.parseInt(id);

        produtoService.excluir(idProduto);
        return "redirect:/listaProdutos";
    }

    @GetMapping("/buscarProduto")
    public String buscarProduto(@RequestParam String nome, Model model) {
        model.addAttribute("produtos", produtoService.buscarPorNome(nome));
        return "listaProdutos";
    }

    @GetMapping("/buscarEstoque")
    public String buscarEstoque(@RequestParam String nome, Model model) {
        model.addAttribute("produtos", produtoService.buscarPorNome(nome));
        return "relatorioEstoque";
    }

    @GetMapping("/buscarMargem")
    public String buscarMargem(@RequestParam String nome, Model model) {
        model.addAttribute("produtos", produtoService.buscarPorNome(nome));
        return "relatorioMargemLucro";
    }

}
