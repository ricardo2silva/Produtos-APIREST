package com.ricardo.produtos.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

@Table(name = "tb_produto")
@Entity
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "id", hidden = true)
    private Long id;
    @NotBlank(message = "{name.not.blank}")
    @Size(min= 3, max = 20, message = "{name.min.size}")
    private String nome;
    @NotNull(message = "{preco.not.null}")
    @Positive(message = "{preco.not.negative}")
    private BigDecimal preco;
    @NotNull(message = "{quantidade.not.null}")
    @Positive(message = "{quantidade.not.negative}")
    private int quantidade;

    public Produto(String nome, BigDecimal preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Produto (){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
