package com.example.retornosAPI.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "O nome é obrigatório e não pode estar vazio.")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
    private String name;
    @Size(max = 500, message = "A descrição deve ter no máximo 500 caracteres")
    private String descricao;
    @Positive(message = "O preço é obrigatório!")
    private Double price;
    @NotNull(message = "A quantidade em estoque é obrigatória.")
    @Min(value = 0, message = "A quantidade em estoque deve ser maior ou igual a 0.")
    private int quantidadeEstoque;
    @Enumerated(EnumType.STRING)
    @NotNull
    private CategoryProduct categoria;

    public ProductEntity() {
    }

    public ProductEntity(Long id, String name, String descricao, Double price, int quantidadeEstoque, CategoryProduct categoria) {
        this.id = id;
        this.name = name;
        this.descricao = descricao;
        this.price = price;
        this.quantidadeEstoque = quantidadeEstoque;
        this.categoria = categoria;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public CategoryProduct getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoryProduct categoria) {
        this.categoria = categoria;
    }
}