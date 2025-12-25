package com.systenezweb.SystenEZ_WEB.controller;

import com.systenezweb.SystenEZ_WEB.model.Produto;
import com.systenezweb.SystenEZ_WEB.model.Usuario;
import com.systenezweb.SystenEZ_WEB.model.Venda;
import com.systenezweb.SystenEZ_WEB.service.ProdutoService;
import com.systenezweb.SystenEZ_WEB.service.UsuarioService;
import com.systenezweb.SystenEZ_WEB.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerPrincipal {

    @Autowired
    ProdutoService produtoService;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    VendaService vendaService;

    @GetMapping("/")
    public String login() {
        return "login";}

    @GetMapping("/telaInicial")
    public String inicio() {
        return "index";}

    @GetMapping("/telaCadastros")
    public String telaCadastros() {
        return "cadastros";}

    @GetMapping("/telaListas")
    public String telaListas() {
        return "listas";}

    @GetMapping("/telaRelatorios")
    public String telaRelatorios() {
        return "relatorios";}

    @GetMapping("/registroDeVendas")
    public String registroDeVendas(Model model) {
        model.addAttribute("venda", new Venda());
        return "vendas";}

    @GetMapping("/cadastrarProduto")
    public String cadastrarProduto(Model model) {
        model.addAttribute("produto", new Produto());
        return "cadastroProdutos";}

    @GetMapping("/cadastrarUsuario")
    public String cadastrarUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "cadastroUsuarios";}

    @GetMapping("/listaProdutos")
    public String listaProdutos(Model model) {
        model.addAttribute("produtos", produtoService.buscarTodos());
        return "listaProdutos";}

    @GetMapping("/listaUsuarios")
    public String listaUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.buscarTodos());
        return "listaUsuarios";}

    @GetMapping("/relatorioEstoque")
    public String relatorioEstoque(Model model) {
        model.addAttribute("produtos", produtoService.buscarTodos());
        return "relatorioEstoque";}

    @GetMapping("/relatorioMargemLucro")
    public String relatorioMargemLucro(Model model) {
        model.addAttribute("produtos", produtoService.buscarTodos());
        return "relatorioMargemLucro";}

    @GetMapping("/relatorioVendas")
    public String relatorioVendas(Model model) {
        model.addAttribute("vendas", vendaService.buscarTodos());
        return "relatorioVendas";}

}
