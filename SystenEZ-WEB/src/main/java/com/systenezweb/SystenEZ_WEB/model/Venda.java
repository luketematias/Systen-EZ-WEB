package com.systenezweb.SystenEZ_WEB.model;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "venda")
@Access(AccessType.FIELD)
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private int quantidadeVendida;

    private LocalDate dataVenda;
    private double total;

    @Transient
    private Integer produtoId;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

}
