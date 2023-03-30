package com.ricardo.produtos.service;

import com.ricardo.produtos.model.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {

    Produto saveProduto(Produto produto);
    Produto getProduto(Long id);

    List<Produto> getAllProduto();

    Produto updateProduto(Produto produto, Long id);

    void deleteProduto(Long id);
}
