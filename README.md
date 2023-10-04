# Prices Challenge Service

Service which exposes features in order to get prices information.

### Configuration
- MS_PORT: Microservice server port (default 8080)
- MS_SWAGGER_HOST: Host where swagger starts (default localhost)
- MS_SWAGGER_PORT: Port where swagger starts (default 8080)

### Deployment
```
mvn spring-boot:run
```

### Unit tests
To run the unit tests, execute the following command:
```
mvn clean test
```

### API Docs
API docs can be accessed at the following link: http://localhost:8080/prices/swagger-ui/api-docs

### Swagger
The Swagger tool can be accessed by default at the following link:

http://localhost:8080/swagger-ui/index.html