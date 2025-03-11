# Currency Conversion Service

Este projeto faz parte do **Bootcamp Bradesco - Java Cloud Native** da [DIO (Digital Innovation One)](https://www.dio.me), com o objetivo praticar os padrões de projeto Singleton, Strategy e Facade utilizando **Spring Boot**, **JPA com H2** e integração com API externa utilizando o **Spring OpenFeign**. Além disso, o projeto utiliza **Swagger (springdoc-openapi)** para documentação interativa das APIs.

## 📌 Descrição do Projeto

O sistema realiza a conversão de moedas em tempo real utilizando a [API Frankfurter](https://www.frankfurter.app/), persiste os dados de conversão e os clientes que realizaram as operações.

## 🚀 Tecnologias Utilizadas
- Java 17+
- Spring Boot
- Spring Data JPA
- Banco de Dados H2 (em memória)
- Spring OpenFeign (para integração com API externa)
- Swagger (springdoc-openapi)

## 📋 Requisitos
- Java 17 ou superior instalado
- Maven instalado

## 📜 Instruções para Execução

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/currency-conversion-service.git
```

2. Navegue até o diretório do projeto:
```bash
cd currency-conversion-service
```

3. Execute o projeto com o Maven:
```bash
mvn spring-boot:run
```

## 📚 Documentação da API com Swagger

Após iniciar a aplicação, acesse a documentação interativa no endereço:

```
http://localhost:8080/swagger-ui.html
```

Nesta interface, você poderá:
- Visualizar todos os endpoints disponíveis.
- Realizar testes diretamente pela interface.
- Ver detalhes sobre as requisições e respostas esperadas.

## 🔗 Endpoints Principais

- **POST /conversion** – Realiza uma nova conversão de moeda.
- **GET /conversion** – Lista todas as conversões realizadas.
- **GET /conversion/availableCurrencies** – Lista todas as moedas disponíveis para conversão.

## 🎯 Exemplo de Requisição e Resposta

### POST `/conversion`
**Requisição:**
```json
{
    "name": "John Doe",
    "base": "USD",
    "amount": 100.0,
    "target": "EUR"
}
```

**Resposta:**
```json
{
    "amountBase": 100.0,
    "base": "USD",
    "amountTarget": 92.5,
    "target": "EUR",
    "date": "2024-01-01",
    "name": "John Doe"
}
```

### GET `/conversion/availableCurrencies`
**Resposta:**
```json
{
    "USD": "United States Dollar",
    "EUR": "Euro",
    "BRL": "Brazilian Real"
}
```

## 🧩 Padrões de Projeto Utilizados
- **Singleton**: Para garantir instâncias únicas em configurações globais.
- **Strategy**: Para permitir múltiplas estratégias de conversão (pode ser estendido).
- **Facade**: Simplificação da lógica de conversão, chamando serviços e persistência de forma unificada.

## 🏆 Contribuição
Sinta-se à vontade para abrir issues ou pull requests se desejar contribuir!

---

Feito com ❤️ para fins educacionais!

