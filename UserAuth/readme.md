Setup:

  -download the repo as zip
  
  -import the zip to sts ide (file->import->general-archive File)
  
  -set username and password for mysql database in application.properties file(src/main/resource)
  
  -run the project as springboot project
  
  
  
  Api Calls:
  
    -localhost:8080/auth/register
    
    
    ![Screenshot (2)](https://user-images.githubusercontent.com/120358700/228586101-257c8519-de0d-4193-b128-c6da941aea22.png)
    
    
      #call this api with request body as in above image, this api with register a new user and return a jwt token which can be used to call further apis
      
      #the role in request body can be any one of "USER"(ready only permission: public api call) or "ADMIN"(read,write,delete permission : private api call)
      
      #Copy the jwt token returned for further calls
      
      
      
   -localhost:8080/auth/authenticate
   
   ![Screenshot (3)](https://user-images.githubusercontent.com/120358700/228587762-1f123694-e007-4e49-9000-d58666d72fe5.png)
   
    #set the request body as shown in image to authenticate a user(user has been registered or not)
    
    #if jwt token is returned then user is authenticated or logged in otherwise not
    
    
      
  -localhost:8080/user/read
  
  ![Screenshot (4)](https://user-images.githubusercontent.com/120358700/228590028-1d1e4517-d617-4053-ac32-7656c1aef2ac.png)
  
    #this is a public api
    
    #under authorization tab in postman select bearer token and paste the token returned in authenticate api
    
    #Users with either of both role will get the result as a string "read" as both the roles have read permissions 
    
    
      
  -localhost/8080/user/write
  
  ![Screenshot (5)](https://user-images.githubusercontent.com/120358700/228590051-886cb22d-674e-4752-aaec-8fa4daae9709.png)
  
    #this is a private api
    
    #under authorization tab in postman select bearer token and paste the token returned in authenticate api
    
    #Users with only ADMIN role will get the result as a string "write" as only it has write permissions 
    
