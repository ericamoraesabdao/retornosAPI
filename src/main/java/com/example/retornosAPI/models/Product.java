package com.example.retornosAPI.models;

public record Product(Long id, String name, String description, Double price, int quantityStock, CategoryProduct categoryProduct) {
}