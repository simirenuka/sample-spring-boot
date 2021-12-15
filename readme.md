## About
Simple springboot app with in-memory database

## Database
* In-memory database used - H2
* H2 access - http://localhost:8081/h2-console
* Data loaded from /sample-spring-boot/src/main/resources/import.sql

## Executable
* java -jar contacts-app.jar

## End point uri (examples)
* Get all phone numbers - 			localhost:8081/demo/contacts
* Get a particular phone contact - 	localhost:8081/demo/contacts/222222
* Activate a phone number - 			localhost:8081/demo/contacts/222222/activate
* Search for contact name - 			localhost:8081/demo/contacts/search?firstname=Rob&lastname=Parker

