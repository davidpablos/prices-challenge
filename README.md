# Prices Challenge Service

Service which exposes features in order to get prices information.

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