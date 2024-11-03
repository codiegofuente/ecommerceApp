# Ecommerce Application

Ecommerce Application para un proceso de selección.

### Deployment
Ha sido desarrollado usando Java 17 y Springboot 2.7.5.
Para desplegarlo es necesario situarse en el directorio raíz del proyecto y ejecutar los siguientes comandos:
~~~ bash
mvn clean install
mvn spring-boot:run

~~~

### Test
Para ejecutar los test realziados es necesario situarse en el directorio raíz del proyecto y ejecutar los siguientes comandos:
~~~ bash
mvn test
~~~

### Run
Si desea realizarse una petición al servicio, basta con hacer una petición HTTP al siguiente endpoint ... Esta petición
puede realizarse con diversas herramientas como POSTMAN, CURL o mismamente desde un navegador WEB
~~~ bash
Navergador WEB
http://localhost:8081/ecommerce/product/info?date=2020-06-14T10:00:00-00:00&productId=35455&brandId=1
CURL
curl -ik -X GET "http://localhost:8081/ecommerce/product/info?date=2020-06-14T10:00:00-00:00&productId=35455&brandId=1"
~~~

## Output
~~~ bash
HTTP/1.1 200
Content-Type: application/json
Transfer-Encoding: chunked
Date: Sun, 03 Nov 2024 13:13:46 GMT

{"productId":35455,"brandId":1,"priceList":1,"startDate":"2020-06-14T00:00:00+02:00","endDate":"2020-12-31T23:59:59+01:00","price":35.5,"curr":"EUR"}
~~~
