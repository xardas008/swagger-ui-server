# Swagger Ui Server

This Spring Boot Application provides the possibility to serve a swagger ui for multiple
service api endpoints.

## Configuration

The only parameter you need to provide is the swagger resources list.

Inside of _application.properties_ you can set the following property:

```
swagger.resources={'service1':'http://server:port/path/to/swagger.json~1.0','service2':'http://seerver:port/path/to/swagger.json~2.0'}
```

The property consists of key / value pairs whereas the key is the name of the service.

The value has the following syntax

```
http(s)://server:port/path/to/swagger.json~1.0
```

The ~ is the delimiter between the server url and the version of the api.