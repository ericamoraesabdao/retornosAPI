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
    private String description;
    @NotNull(message = "O preço é obrigatório.")
    @Positive(message = "O preço deve ser maior que zero.")
    private Double price;
    @NotNull(message = "A quantidade em estoque é obrigatória.")
    @Min(value = 0, message = "A quantidade em estoque deve ser maior ou igual a 0.")
    private int quantityStock;
    @Enumerated(EnumType.STRING)
    @NotNull
    private CategoryProduct categoryProduct;

    public ProductEntity() {
    }

    public ProductEntity(Long id, String name, String description, Double price, int quantityStock, CategoryProduct categoryProduct) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantityStock = quantityStock;
        this.categoryProduct = categoryProduct;
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

    public String getDescription(){
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantityStock() {
        return quantityStock;
    }

    public void setQuantityStock(int quantidadeEstoque) {
        this.quantityStock = quantidadeEstoque;
    }

    public CategoryProduct getCategoryProduct() {
        return categoryProduct;
    }

    public void setCategoryProduct(CategoryProduct categoryProduct) {
        this.categoryProduct = categoryProduct;
    }
}