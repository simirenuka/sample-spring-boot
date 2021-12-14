Database
##-----------------------------------------------------------------------##
In-memory database used - H2
Url for accessing h2 - http://localhost:8081/h2-console
Data loaded from /sample-spring-boot/src/main/resources/import.sql

Executable
##-----------------------------------------------------------------------##
java -jar belong-contacts.jar


End point uri (examples)
##-----------------------------------------------------------------------##
Get all phone numbers - 			localhost:8081/demo/contacts
Get a particular phone contact - 	localhost:8081/demo/contacts/222222
Activate a phone number - 			localhost:8081/demo/contacts/222222/activate
Search for contact name - 			localhost:8081/demo/contacts/search?firstname=Daisy&lastname=Duck

