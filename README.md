# Prices Challenge Service

Service which exposes features in order to get prices information.

## Application design overview

This service has been developed using hexagonal architecture and TDD (Test-Driven Development).
The main project structure consists of the following directories:

- application: Here primary adapters can be found, such as typical REST controllers, message consumers for RabbitMQ or Kafka...
- domain: Core of the business. Domain entities and use cases are located here. This part of the code is framework-agnostic.
- infrastructure: Here secondary adapters can be found, such as database operations, publishing messages in messaging systems...

### Database Structure

After evaluating the requirements, the database has been created with the following structure:

#### Table: brand

| Column Name | Data Type        | Constraints         |
|-------------|------------------|---------------------|
| id          | bigint           | NOT NULL, AUTO_INCREMENT, PRIMARY KEY |
| name        | varchar(16)      | NOT NULL            |

#### Table: price

| Column Name | Data Type        | Constraints         |
|-------------|------------------|---------------------|
| id          | bigint           | NOT NULL, AUTO_INCREMENT, PRIMARY KEY |
| brand_id    | bigint           | NOT NULL, FOREIGN KEY (brand_id) REFERENCES brand(id) |
| start_date  | datetime         | NOT NULL            |
| end_date    | datetime         | NOT NULL            |
| price_list  | bigint           | NOT NULL            |
| product_id  | bigint           | NOT NULL            |
| priority    | int              | NOT NULL            |
| price       | double           | NOT NULL            |
| currency    | varchar(4)       | NOT NULL            |

#### Database content

##### Table: brand

| id  | name  |
|-----|-------|
| 1   | ZARA  |

##### Table: price

| id  | brand_id | start_date          | end_date            | price_list | product_id | priority | price | currency |
|-----|----------|---------------------|---------------------|------------|------------|----------|-------|----------|
| 1   | 1        | 2020-06-14 00:00:00 | 2020-12-31 23:59:59 | 1          | 35455      | 0        | 35.50 | EUR      |
| 2   | 1        | 2020-06-14 15:00:00 | 2020-06-14 18:30:00 | 2          | 35455      | 1        | 25.45 | EUR      |
| 3   | 1        | 2020-06-15 00:00:00 | 2020-06-15 11:00:00 | 3          | 35455      | 1        | 30.50 | EUR      |
| 4   | 1        | 2020-06-15 16:00:00 | 2020-12-31 23:59:59 | 4          | 35455      | 1        | 38.95 | EUR      |

### Configuration
- MS_PORT: Microservice server port (default 8080)
- MS_SWAGGER_HOST: Host where swagger starts (default localhost)
- MS_SWAGGER_PORT: Port where swagger starts (default 8080)

### Maven wrapper installation
To install maven wrapper, execute the following command:
```
mvn wrapper:wrapper
```

### Deployment
```
./mvnw spring-boot:run
```

### Unit tests
To run the unit tests, execute the following command:
```
./mvnw clean test
```

### Integration tests
To run unit and integration tests, execute the following command:
```
./mvnw clean verify
```

### API Docs
API docs can be accessed at the following link: http://localhost:8080/prices/swagger-ui/api-docs

### Swagger
The Swagger tool can be accessed by default at the following link:

http://localhost:8080/swagger-ui/index.html

### Curl commands to test application
In order to test this commands, application must be running.

Test 1:
```
curl -X GET "http://localhost:8080/api/v1/prices?productId=35455&brandId=1&applicationDate=2020-06-14T10:00:00" -H "Accept: application/json"
```
Test 2:
```
curl -X GET "http://localhost:8080/api/v1/prices?productId=35455&brandId=1&applicationDate=2020-06-14T16:00:00" -H "Accept: application/json"
```
Test 3:
```
curl -X GET "http://localhost:8080/api/v1/prices?productId=35455&brandId=1&applicationDate=2020-06-14T21:00:00" -H "Accept: application/json"
```
Test 4:
```
curl -X GET "http://localhost:8080/api/v1/prices?productId=35455&brandId=1&applicationDate=2020-06-15T10:00:00" -H "Accept: application/json"
```
Test 5:
```
curl -X GET "http://localhost:8080/api/v1/prices?productId=35455&brandId=1&applicationDate=2020-06-16T21:00:00" -H "Accept: application/json"
```

Another option to test the application is to use the 'Try it out' button on the provided Swagger link