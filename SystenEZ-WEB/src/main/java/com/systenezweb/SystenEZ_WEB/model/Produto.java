package com.systenezweb.SystenEZ_WEB.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
@Table(name = "produto")
@Access(AccessType.FIELD)
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "É obrigatorio preencher este campo!")
    private String nome;

    @NotBlank(message = "É obrigatorio preencher este campo!")
    private String categoria;

    @NotNull(message = "É obrigatorio preencher este campo!")
    @PositiveOrZero(message = "Este campo não pode ser em valor negativo!")
    private Double precoCusto;

    @NotNull(message = "É obrigatorio preencher este campo!")
    @Positive(message = "Este campo é obrigatório o valor ser maior que zero!")
    private Double precoVenda;

    @NotNull(message = "É obrigatorio preencher este campo!")
    @Min(value = 0, message = "Este campo não pode ser em valor negativo!")
    private Integer quantidade;

    @Transient
    public double getMargemLucro() {
        return precoVenda - precoCusto;
    }
}
