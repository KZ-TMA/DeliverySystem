### The REST API for Delivery System 


**Standalone run this service for dev (not war packaging, it is allow redefining http port and spring-boot configs as jdbc path and etc.):**
**Use one of following:**
1. **Use Idea Spring boot runner**:
    - Open `Run/Debug Configurations`
    - Select main `Application` class
    - VMOptions - e.g. `-Dserver.port=8090` (for http port)
    - Program arguments - `--spring.config.location=e:\application.properties` (if exists external spring boot configs)
     e.g `jpa/properties`
    
2. **Maven spring boot plugin (this may be used from command line or Idea maven runner)**:
    `mvn spring-boot:run -Dserver.port=8090 -Dspring.config.location=file:///e:\application.properties`


 ### First get token:

 * client: jwtclientid
 * secret: XY7kmzoNzl100
 * Admin username and password: "admin" and "EmbeddedAdmin4DeliveringSystem"
 * Example of resource accessible to anonimous users:  http://localhost:8080/api/hello
 * Example of resource accessible to only an admin user:  http://localhost:8080/api/users

 1. Generate an access token

   Use the following generic command to generate an access token:
   `$ curl client:secret@localhost:8080/oauth/token -d grant_type=password -d username=user -d password=pwd`

   For admin, run:
   `curl jwtclientid:XY7kmzoNzl100@localhost:8080/api/oauth/token -d grant_type=password -d username=admin -d password=EmbeddedAdmin4DeliveringSystem`
    You'll receive a response similar to below

    `
    {
      "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidGVzdGp3dHJlc291cmNlaWQiXSwidXNlcl9uYW1lIjoiYWRtaW4uYWRtaW4iLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXSwiZXhwIjoxNDk0NDU0MjgyLCJhdXRob3JpdGllcyI6WyJTVEFOREFSRF9VU0VSIiwiQURNSU5fVVNFUiJdLCJqdGkiOiIwYmQ4ZTQ1MC03ZjVjLTQ5ZjMtOTFmMC01Nzc1YjdiY2MwMGYiLCJjbGllbnRfaWQiOiJ0ZXN0and0Y2xpZW50aWQifQ.rvEAa4dIz8hT8uxzfjkEJKG982Ree5PdUW17KtFyeec",
      "token_type": "bearer",
      "expires_in": 43199,
      "scope": "read write",
      "jti": "0bd8e450-7f5c-49f3-91f0-5775b7bcc00f"
    }`

 2. Use the token to access resources through your RESTful API

    * Access content available only to an admin user

        Use the generated token  as the value of the Bearer in the Authorization header as follows:
        `curl  http://localhost:8080/api/users -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidGVzdGp3dHJlc291cmNlaWQiXSwidXNlcl9uYW1lIjoiYWRtaW4uYWRtaW4iLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXSwiZXhwIjoxNDk0NDU0MjgyLCJhdXRob3JpdGllcyI6WyJTVEFOREFSRF9VU0VSIiwiQURNSU5fVVNFUiJdLCJqdGkiOiIwYmQ4ZTQ1MC03ZjVjLTQ5ZjMtOTFmMC01Nzc1YjdiY2MwMGYiLCJjbGllbnRfaWQiOiJ0ZXN0and0Y2xpZW50aWQifQ.rvEAa4dIz8hT8uxzfjkEJKG982Ree5PdUW17KtFyeec" `

        The response will be: a array of users if their exists