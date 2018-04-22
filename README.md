# small-booking-backend

## Getting started

This is an back-end of the app named Small Booking App. The app was developed as a final project of SWD, which is shorts for Software Architect and Design, at school. It provide APIs to a front-end app written in C# (.NET MVC) and a mobile app written in React Native.

- Starter: bootstraped using SPRING INITIALIZR
- Security: JWT as authentication and authorization
- Datebase: Postgresql deployed on Heroku
- ORM: Hibernate as JPA
- Patterns: Repository and Specification
- Others: Static meta modeling for type-safe query


### Installation
```mvn clean install```

### Running
A note on run.sh (on Mac/Linux): It contains some export statements to needed variables to local evironment including database credentials in order to make connection. These values are only valid to your current session and will be removed after your machine gets rebooted.
 - Make sure your run.sh have execution permission, or you simply type ```sudo chmod +x run.sh```
 - And then:
```./run.sh```

If you are a Windows user, execute the similar: ```run.bat``` (I haven't tested yet because I have no development environment set up. If you are successful running with this script, happy to you. If you aren't, your may get some help from google or others. PRs are welcomed to make this run from your script ^_^).

### Stopping
```Ctrl + C```

## Enjoying

### Visit swagger doc at: ```http://localhost:8080/swagger-ui.html#!/```

## References:

- [SPRING INITIALIZR](https://start.spring.io/)
- [JWT Authentication](https://auth0.com/blog/implementing-jwt-authentication-on-spring-boot/)
- [Simple Specification Pattern](http://www.baeldung.com/rest-api-search-language-spring-data-specifications). For deep understanding, visit [Java design pattern - Specification](https://github.com/iluwatar/java-design-patterns/tree/master/specification)
- [Static meta modeling](https://docs.oracle.com/javaee/6/tutorial/doc/gjiup.html)
- [Java Practices](http://www.javapractices.com/) by John O'Hanley is recommended. You may learn lots of things from his website.
