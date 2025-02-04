package com.example.retornosAPI.services;

import com.example.retornosAPI.exceptions.ResourceNotFoundException;
import com.example.retornosAPI.models.Product;
import com.example.retornosAPI.models.ProductEntity;
import com.example.retornosAPI.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product createProduct(Product product) {
        ProductEntity entity = new ProductEntity(null, product.name(), product.description(), product.price(), product.quantityStock(), product.categoryProduct());
        ProductEntity savedEntity = repository.save(entity);
        return new Product(savedEntity.getId(), savedEntity.getName(), savedEntity.getDescription(), savedEntity.getPrice(), savedEntity.getQuantityStock(), savedEntity.getCategoryProduct());
    }

    public Product getProductById(Long id) {
        ProductEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado!"));
        return new Product(entity.getId(), entity.getName(), entity.getDescription(), entity.getPrice(), entity.getQuantityStock(), entity.getCategoryProduct());
    }

    public List<Product> getAllProducts() {
        return repository.findAll().stream()
                .map(entity -> new Product(entity.getId(), entity.getName(), entity.getDescription(), entity.getPrice(), entity.getQuantityStock(), entity.getCategoryProduct()))
                .collect(Collectors.toList());
    }

    public boolean productExists(Long id) {
        return repository.existsById(id);
    }

    public void deleteProduct(Long id) {
        if (productExists(id)) {
            repository.deleteById(id);
        } else {
            ProductEntity existingEntity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Produto com o ID: " + id + " não foi encontrado."));

        }

    }

    // Atualizar um produto existente
    public Product updateProduct(Long id, Product updatedProduct) {
        // Verificar se o produto existe
        ProductEntity existingEntity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não foi possível atualizar pois o produto não foi encontrado."));

        // Atualizar os dados do produto
        existingEntity.setName(updatedProduct.name());
        existingEntity.setDescription(updatedProduct.description());
        existingEntity.setPrice(updatedProduct.price());
        existingEntity.setQuantityStock(updatedProduct.quantityStock());
        existingEntity.setCategoryProduct(updatedProduct.categoryProduct());

        // Salvar as alterações no banco de dados
       ProductEntity savedEntity = repository.save(existingEntity);

        // Retornar o produto atualizado
        return new Product(savedEntity.getId(), savedEntity.getName(), savedEntity.getDescription(), savedEntity.getPrice(), savedEntity.getQuantityStock(), savedEntity.getCategoryProduct());
    }

    // Buscar produtos pelo nome
    public List<Product> getProductsByName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("O nome do produto não pode ser vazio.");
        }

        List<ProductEntity> entities = repository.findByNameContainingIgnoreCase(name);
        if (entities.isEmpty()) {
            System.out.println("Nenhum produto encontrado com o nome: " + name);
        } else {
            System.out.println("Produtos encontrados com o nome '" + name + "': " + entities.size());
        }
        return entities.stream()
                .map(entity -> new Product(entity.getId(), entity.getName(), entity.getDescription(), entity.getPrice(), entity.getQuantityStock(), entity.getCategoryProduct()))
                .collect(Collectors.toList());
    }
}