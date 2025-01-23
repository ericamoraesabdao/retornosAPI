package com.example.retornosAPI.models;

public enum CategoryProduct {
    ELETRONICOS("Eletrônicos"),
    ROUPAS("Roupas"),
    ALIMENTOS("Alimentos");

    private final String categoryProduct;

    CategoryProduct(String categoryProduct) {
        this.categoryProduct = categoryProduct;
    }

    public String getCategoryProduct(){
        return categoryProduct;
    }
}
