Spring boot microservice application
====================================

This small Spring Boot application acting as a kind of blueprint for a typical microservice.
It contains following components:

* A demo REST controller which takes 5 arguments as request parameters/headers and sends the response back as an JSON
* API versioning via content type negotiation and vendor specific MIME types
* Swagger SpringMVC integration for generated API documentation
* An index.html file using swagger-ui for browsing the API documentation including Javascript test client

Initial setup
-------------

1. `gradle build`
2. `gradle bootRun`
3. [http://localhost:9000/swagger-ui/index.html](http://localhost:9000/swagger-ui/index.html) shows the API documentation provided by swagger-ui
4. If need to test how controller works, uses prepared HTTP requests in file [test_requests.http](src/test/resources/test_requests.http)