package com.ricardo.produtos.controller;

import com.ricardo.produtos.model.Produto;
import com.ricardo.produtos.service.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@Api(value = "API REST Produtos")
@CrossOrigin(origins = "*")
public class ProdutoController {

    private ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @PostMapping("/adicionar")
    @ApiOperation(value = "Salva um produto")
    public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto){
        Produto product = service.saveProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
    @ApiOperation(value = "Lista um produto")
    @GetMapping("/listar-produto/{id}")
    public ResponseEntity<Produto> listarProduto(@PathVariable Long id) {
        Produto product = service.getProduto(id);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }
    @ApiOperation(value = "Lista todos os produtos")
    @GetMapping("/listar-produtos")
    public ResponseEntity<List<Produto>> listarTodosProdutos(){
        List<Produto> produtos = service.getAllProduto();
        return ResponseEntity.status(HttpStatus.OK).body(produtos);
    }
    @ApiOperation(value = "Atualiza um produto")
    @PutMapping("atualizar-produto")
    public ResponseEntity<Produto> atualizarProduto(@RequestBody Produto produto) {
        Produto produtoUpdate = service.updateProduto(produto);
        return ResponseEntity.status(HttpStatus.OK).body(produtoUpdate);
    }
    @ApiOperation(value = "Deleta um produto")
    @DeleteMapping("/deletar-produto/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id){
        service.deleteProduto(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
