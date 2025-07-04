# Currency Converter

A lightweight, extensible **Currency Converter API** built with **Java Spring Boot**. This service fetches real-time exchange rates from external APIs and converts currencies on demand.

## Features

- Convert between major currencies using real-time exchange rates
- Integrates with external APIs
- RESTful endpoints for currency conversion
- Caffeine caching for improved performance

## Tech Stack
- Java 17+
- Spring Boot 3+
- Maven
- Caffeine Cache

## API Endpoints

### Convert Currency

**POST** `/api/convert`

#### Request Body

```
{
  "fromCurrency": "EUR",
  "toCurrency": "USD",
  "amount": 100
}
```

#### Response

```
{
  "fromCurrency": "EUR",
  "toCurrency": "USD",
  "amount": 100,
  "convertedAmount": 117.67,
  "conversionRate": 1.1767
}
```

## How to run locally

1. Clone the repository
```
git clone https://github.com/babafemiolatona/currency-converter.git
cd currency-converter
```
2. Build and run
```
./mvnw clean install
./mvnw spring-boot:run
```
3. Test the API
   
  You can use Postman or curl:
```
curl -X POST http://localhost:8080/api/convert \
  -H "Content-Type: application/json" \
  -d '{"from":"USD", "to":"EUR", "amount":100}'

```

## API Documentation (Swagger)

Once the app is running, you can explore and test the API using Swagger UI:

**Swagger UI**:  
[http://localhost:8000/swagger-ui/index.html](http://localhost:8000/swagger-ui/index.html)

**OpenAPI Docs (JSON)**:  
[http://localhost:8000/v3/api-docs](http://localhost:8000/v3/api-docs)
