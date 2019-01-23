** Callsign: Backend Exercise
/*
1. Design and implement a simple API that provides the user with the functionality of
authentication.
2. The API should be easy to understand and integrate with. RESTful is a welcomed
approach.
3. The language must be Java and you can use any framework/libraries such as Spring
Boot, Dropwizard, Jackson, etc.
4. Don’t worry about persistence as data can be handled solely in memory.
5. You should make your code production-ready as much as possible.
6. The project should have a brief description of how to run the service and interact with
its API.
7. It shouldn’t take you more than a couple of hours to complete the exercise as this is
going to be the basis for your face-to-face interview.
8. When done, please send us your project via email to recruitment@callsign.com.
*/

**Solution
I didn't have any experience on authentication rest services. I created an Spring Boot rest service, including spring security.

*SpringSecurityConfig
Set up the spring security valid user and password and checking authentication user has those values.
The values for a valid user and password are defined as properties in application.properties file. Their labels are "url.admin.user" and "url.admin.password" 

*CallSignController
This is the main rest controller. I created 3 methods inside, but the important one is getAuthenticatedUser.
This method just create an User using the user credentials but with an empty password. Once this user is created, it is returned in the response.

*CallSignService
Interface that defines the contract that the Services should have.

*CallSignServiceImpl
Class that implements the contract. By the moment, the class is creating a new User with the authenticated user name, and an empty password.



*CallSignControllerTest
Test to check that the rest service is being called with an user/pass and it returns a new user with the same name and empty password as I defined in CallSignServiceImpl

P.D:
I also checked it using Postman, creating a GET call to http://localhost:8080/login and using Basic Authorization with Username=admin and Password=password