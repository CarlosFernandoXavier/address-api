## Objective: ##

Get address by zipcode, by searching the viacep API


![simplescreenrecorder-2023-10-15_11 20 10 (online-video-cutter com)](https://github.com/CarlosFernandoXavier/address-api/assets/21314576/d0f74ed1-3c76-437c-97bd-024a105a7f98)






## Requirements to run by docker:

    - Maven;
    - Docker;
    
## Steps to run the program by docker:

    - Clone the project: https://github.com/CarlosFernandoXavier/address-api.git;
    - Open the terminal at the root of project;
      - Execute the command: mvn clean package
      - Execute the command: docker build -t address . 
      - Execute the command: docker run -p 8080:8080 address
   


## Requirements to run by IDE:

    - Java 11;
    - IDE (suggested intellij)
    - Lombok;
    - Maven;
    - Enable annotation processers from your IDE;
    
      
## Steps to run the program by IDE:

    - Clone the project: https://github.com/CarlosFernandoXavier/address-api.git;
    - Open the project in your IDE;
    - Execute the command: mvn clean install;
    - Execute the AddressApiApplication class;
    - Open Postman;
        - Import the curl;
        - Execute the request;
    

## Requirements to run by .jar:

    - Java 11;
    - Maven;

      
## Steps to run the program by .jar:

    - Clone the project: https://github.com/CarlosFernandoXavier/address-api.git;
    - Open the terminal at the this path: address-api/adapter/target
      - Execute the command: java -jar adapter-0.0.1-SNAPSHOT.jar

    
   
## Curl to make the request:
    curl --location 'localhost:8080/v1/get-address?zipcode=95603620'
    
## Link to access the user interface, when the application is running:
    http://localhost:8080/swagger-ui/index.html
