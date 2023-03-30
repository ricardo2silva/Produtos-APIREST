package com.ricardo.produtos.service.impl;

import com.ricardo.produtos.model.Produto;
import com.ricardo.produtos.repository.ProdutoRepository;
import com.ricardo.produtos.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository repository;
    @Override
    public Produto saveProduto(Produto produto) {
        return repository.save(produto);
    }

    @Override
    public Produto getProduto(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Produto> getAllProduto() {
        List<Produto> produtos = repository.findAll();
        return produtos;
    }

    @Override
    public Produto updateProduto(Produto produto,Long id) {
        produto.setId(id);
        return repository.save(produto);
    }

    @Override
    public void deleteProduto(Long id) {
        Produto produto = repository.findById(id).get();
        repository.delete(produto);
    }
}
