OAuth?
Oauth is an JWT based authorization framework.  

The grant type here we are going to see is Authorization Code, So it needs user intervention to grant access for the authorize request

The main endpoints involved here is
/authorize
  GET /authorize?response_type=code&client_id=s6BhdRkqt3&state=xyz
        &redirect_uri=https%3A%2F%2Fclient%2Eexample%2Ecom%2Fcb HTTP/1.1
    Host: server.example.com

    Response would contain the authorization code. and state value remains same as like the request

/token
 POST /token HTTP/1.1
     Host: server.example.com
     Authorization: Basic czZCaGRSa3F0MzpnWDFmQmF0M2JW -> base64 encoded of (username:password)
     Content-Type: application/x-www-form-urlencoded

     grant_type=authorization_code&code=SplxlOBeZQQYbYS6WxSbIA 
     &redirect_uri=https%3A%2F%2Fclient%2Eexample%2Ecom%2Fcb

Response would contains the JWT toke.





Oauth Integration with springboot

step1 : Add dependency
     <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-oauth2-client</artifactId>
        </dependency>

step2: create REST endpoint
create a sample controller class, here we have created a class called controller which is having two endpoints like the below
   
    @GetMapping("/appKey") - some sort of secret key so only authorized user can access 

    @GetMapping("/aboutApp") - anyone can view

step3: we are going to secure /appkey endpoint using Github. Who are all having github account they can view the key. 
we are going to creation configuration class which is going to filter the inflow requests. 
http
                .authorizeHttpRequests()
                        .requestMatchers("/aboutApp","/","").permitAll()
                        .anyRequest().authenticated()
                        .and()
                                .oauth2Login();



How to Run the app?
Checkout the code.
Run as a Java application.
Visit http://localhost:8080/aboutApp to view the description.
Visit http://localhost:8080/appKey - it will prompt for authorization as this is a protected endpoint. As this is Auth code grant, user has to authorize then only he will be able to view the response.
Summary:
You've successfully integrated OAuth 2.0 Authorization Code flow into your Spring Boot application.





   

