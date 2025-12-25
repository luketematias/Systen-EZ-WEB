package com.systenezweb.SystenEZ_WEB.repository;

import com.systenezweb.SystenEZ_WEB.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    List<Produto> findByNomeContainingIgnoreCase(String nome);
}
