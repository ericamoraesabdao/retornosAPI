package com.example.retornosAPI.models;

public record Product(Long id, String name, String descricao, Double price, int quantidadeEstoque, CategoryProduct categoria) {
}