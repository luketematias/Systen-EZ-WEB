package com.systenezweb.SystenEZ_WEB.service;

import com.systenezweb.SystenEZ_WEB.model.Produto;
import com.systenezweb.SystenEZ_WEB.model.Venda;
import com.systenezweb.SystenEZ_WEB.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {

    @Autowired
    VendaRepository vendaRepository;

    @Autowired
    ProdutoService produtoService;

    public Venda criar(Venda venda) {
        Produto produto = produtoService.buscarPorId(venda.getProdutoId());

        produto.setQuantidade(produto.getQuantidade()-venda.getQuantidadeVendida());


        venda.setTotal(produto.getPrecoVenda()*venda.getQuantidadeVendida());

        venda.setProduto(produto);

        venda.setId(null);

        vendaRepository.save(venda);
        return venda;
    }

    public List<Venda> buscarTodos(){
        return vendaRepository.findAll();
    }

    public List<Venda> buscarPorNome(String nome) {
        return vendaRepository.buscarPorNomeProduto(nome);
    }
}
