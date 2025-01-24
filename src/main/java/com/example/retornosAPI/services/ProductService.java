package com.example.retornosAPI.services;

import com.example.retornosAPI.models.Product;
import com.example.retornosAPI.models.ProductEntity;
import com.example.retornosAPI.repositories.ProductRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private static ProductRepository repository = new ProductRepository() {
        @Override
        public List<ProductEntity> findByNameContainingIgnoreCase(String name) {
            return List.of();
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends ProductEntity> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends ProductEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
            return List.of();
        }

        @Override
        public void deleteAllInBatch(Iterable<ProductEntity> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Long> longs) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public ProductEntity getOne(Long aLong) {
            return null;
        }

        @Override
        public ProductEntity getById(Long aLong) {
            return null;
        }

        @Override
        public ProductEntity getReferenceById(Long aLong) {
            return null;
        }

        @Override
        public <S extends ProductEntity> List<S> findAll(Example<S> example) {
            return List.of();
        }

        @Override
        public <S extends ProductEntity> List<S> findAll(Example<S> example, Sort sort) {
            return List.of();
        }

        @Override
        public <S extends ProductEntity> List<S> saveAll(Iterable<S> entities) {
            return List.of();
        }

        @Override
        public List<ProductEntity> findAll() {
            return List.of();
        }

        @Override
        public List<ProductEntity> findAllById(Iterable<Long> longs) {
            return List.of();
        }

        @Override
        public <S extends ProductEntity> S save(S entity) {
            return null;
        }

        @Override
        public Optional<ProductEntity> findById(Long aLong) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Long aLong) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Long aLong) {

        }

        @Override
        public void delete(ProductEntity entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Long> longs) {

        }

        @Override
        public void deleteAll(Iterable<? extends ProductEntity> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public List<ProductEntity> findAll(Sort sort) {
            return List.of();
        }

        @Override
        public Page<ProductEntity> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends ProductEntity> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends ProductEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends ProductEntity> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends ProductEntity> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends ProductEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }
    };

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
                .orElseThrow(() -> new RuntimeException("Product not found"));
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
        repository.deleteById(id);
    }

    // Atualizar um produto existente
    public static ProductEntity updateProduct(Long id, Product updatedProduct) {
        // Verificar se o produto existe
        ProductEntity existingEntity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product with ID " + id + " not found"));

        // Atualizar os dados do produto
        existingEntity.setName(updatedProduct.name());
        existingEntity.setDescription(updatedProduct.description());
        existingEntity.setPrice(updatedProduct.price());
        existingEntity.setQuantityStock(updatedProduct.quantityStock());
        existingEntity.setCategoryProduct(updatedProduct.categoryProduct());

        // Salvar as alterações no banco de dados
      //  ProductEntity savedEntity = repository.save(existingEntity);

        // Retornar o produto atualizado
        return repository.save(existingEntity);
                //new Product(savedEntity.getId(), savedEntity.getName(), savedEntity.getDescricao(), savedEntity.getPrice(), savedEntity.getQuantidadeEstoque(), savedEntity.getCategoria());
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