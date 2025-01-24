# Exercício de CRUD de Produtos

## Descrição:
Este projeto é uma API RESTful desenvolvida em Java com Spring Boot que implementa um CRUD (Create, Read, Update e Delete) para gerenciar produtos. A API permite realizar operações como adicionar, visualizar, atualizar e excluir produtos, além de buscar produtos por ID. É ideal para aprendizado e prática de conceitos de desenvolvimento backend.

## Pré-requisitos

Antes de começar, certifique-se de ter os seguintes itens instalados em sua máquina:

- [Java 17+](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven 3.8+](https://maven.apache.org/download.cgi)
- Uma IDE como [IntelliJ IDEA](https://www.jetbrains.com/idea/) ou [Eclipse](https://www.eclipse.org/ide/).


## Funcionamento:
Para utilizar o crud devemos usar o EndPoint em algum APIRest como o Thunder Client, o Postman ou outro de sua preferência.

## Estrutura do Código:
* **RetornosApiApplication():** Classe responsável por rodar o servidor h2 data base.
* **ProductController():** Classe que controla as Rotas dos EndPoints.
* **CategoryProduct():** Enum que contem a lista de categorias que os produtos podem ter.
* **Product():** Record dos produtos.
* **ProductEntity():** Classe que determina entidade Produtos.
* **ProductRepository():** Classe que extends o JPA.
* **ProductService():** Classe que contem os métodos dos produtos (createProduct, getProductById, getAllProducts, productExists, deleteProduct, updateProduct, getProductsByName)

## Como Executar o Código

Para executar o código, siga os passos abaixo:

### 1. Clonar o Repositório
Clone o repositório para o seu ambiente local:

```bash
git clone git@github.com:ericamoraesabdao/retornosAPI.git
```

### 2. Navegar até o Diretório do Projeto
Entre na pasta do repositório clonado:

```bash
cd retornosAPI
```

### 3. Abra sua IDE de preferência e execute o código no botão RUN na IDE.

## EndPoints

### createProduct

**URL:** /api/products

**Método:** POST

**Descrição:** Cadastra um novo produto.

**Body (JSON):**

    {
        "name": "Goiabada",
        "description": "Delicioso doce de goiaba feito da mais pura goiaba da serra",
        "price": 9.99,
        "quantityStock": 10,
        "categoryProduct": "ALIMENTOS"
    }

**Exemplo de Resposta:**

    {
        "id": 1,
        "name": "Goiabada",
        "description": "Delicioso doce de goiaba feito da mais pura goiaba da serra",
        "price": 9.99,
        "quantityStock": 10,
        "categoryProduct": "ALIMENTOS"
    }


### getProductById

**URL:** /api/products/{id}

**Método:** GET

**Descrição:** Retorna o produto determinado pelo ID.

**Exemplo de Resposta:**

    {
        "id": 1,
        "name": "Goiabada",
        "description": "Delicioso doce de goiaba feito com a mais pura goiaba da serra",
        "price": 9.99,
        "quantityStock": 15,
        "categoryProduct": "ALIMENTOS"
    }


### getAllProducts

**URL:** /api/products

**Método:** GET

**Descrição:** Retorna a lista de todos os produtos cadastrados.

**Exemplo de Resposta:**

    [
        {
            "id": 1,
            "name": "Goiabada",
            "description": "Delicioso doce de goiaba feito da mais pura goiaba da serra",
            "price": 9.99,
            "quantityStock": 10,
            "categoryProduct": "ALIMENTOS"
        },
        {
            "id": 2,
            "name": "Goiabada",
            "description": "Delicioso doce de goiaba feito com a mais pura goiaba da serra",
            "price": 9.99,
            "quantityStock": 15,
            "categoryProduct": "ALIMENTOS"
        }
    ]

### deleteProduct

**URL:** /api/products/{id}

**Método:** DELETE

**Descrição:** Exclui o produto selecionado pelo ID.


### updateProduct

**URL:** /api/products/{id}

**Método:** POST

**Descrição:** Atualizar um produto.

**Body (JSON):**

    {
        "name": "Goiabada",
        "description": "Delicioso doce de goiaba feito com a mais pura goiaba da serra",
        "price": 9.99,
        "quantityStock": 15,
        "categoryProduct": "ALIMENTOS"
    }

**Exemplo de Resposta:**

    {
        "id": 2,
        "name": "Goiabada",
        "description": "Delicioso doce de goiaba feito com a mais pura goiaba da serra",
        "price": 9.99,
        "quantityStock": 15,
        "categoryProduct": "ALIMENTOS"
    }


## Tecnologias Utilizadas
- **Java 17:** Linguagem de programação.
- **Spring Boot:** Framework para desenvolvimento de aplicações Java.
- **Spring Data JPA:** Para persistência de dados.
- **H2 Database:** Banco de dados em memória para desenvolvimento e testes.
- **Maven:** Gerenciador de dependências e automação de build.

## Autora

- **Erica Moraes Abdao**
