package com.systenezweb.SystenEZ_WEB.service;

import com.systenezweb.SystenEZ_WEB.model.Produto;
import com.systenezweb.SystenEZ_WEB.model.Usuario;
import com.systenezweb.SystenEZ_WEB.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;

    public Produto criar(Produto produto) {
        produto.setId(null);
        produtoRepository.save(produto);
        return produto;
    }

    public List<Produto> buscarTodos(){
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Integer id){
        return produtoRepository.findById(id).orElseThrow();
    }

    public void excluir(Integer id){
        Produto produtoEncontrado = buscarPorId(id);
        produtoRepository.deleteById(produtoEncontrado.getId());
    }

    public Produto atualizar(Integer id, Produto produto){
        Produto produtoEncontrado = buscarPorId(id);

        produtoEncontrado.setNome(produto.getNome());
        produtoEncontrado.setPrecoCusto(produto.getPrecoCusto());
        produtoEncontrado.setPrecoVenda(produto.getPrecoVenda());
        produtoEncontrado.setCategoria(produto.getCategoria());
        produtoEncontrado.setQuantidade(produto.getQuantidade());

        produtoRepository.save(produtoEncontrado);
        return produtoEncontrado;
    }

    public List<Produto> buscarPorNome(String nome) {
        return produtoRepository.findByNomeContainingIgnoreCase(nome);
    }

}
