## Objective: ##

Get address by zipcode, by searching the viacep API


## Running application: ##
There are four ways to execute this project:
- Codespace: idea online from github which you don't need install anything;
- Docker;
- Favorite IDE local;
- Jar;

## Running project by codespace: ##

### Step 1: ###

https://github.com/CarlosFernandoXavier/address-api/assets/21314576/c6d08783-8dbd-48a6-adb2-f76d9cc14eb1

### Step 2: ###
https://github.com/CarlosFernandoXavier/address-api/assets/21314576/066a85d8-93de-4f4c-bd3b-75a1c5dde304


## Running by Docker ##

### Requirements to run by docker: ###

    - Maven;
    - Docker;
    
### Steps to run the program by docker:

    - Clone the project: https://github.com/CarlosFernandoXavier/address-api.git;
    - Open the terminal at the root of project;
      - Execute the command: mvn clean package
      - Execute the command: docker build -t address . 
      - Execute the command: docker run -p 8080:8080 address
   

## Running by your favorie IDE: 

### Requirements to run by IDE:

    - Java 11;
    - IDE (suggested intellij)
    - Lombok;
    - Maven;
    - Enable annotation processers from your IDE;
    
      
### Steps to run the program by IDE:

    - Clone the project: https://github.com/CarlosFernandoXavier/address-api.git;
    - Open the project in your IDE;
    - Execute the command: mvn clean install;
    - Execute the AddressApiApplication class;
    - Open Postman;
        - Import the curl;
        - Execute the request;
    

## Running by .jar

### Requirements to run by .jar:

    - Java 11;
    - Maven;

      
### Steps to run the program by .jar:

    - Clone the project: https://github.com/CarlosFernandoXavier/address-api.git;
    - Open the terminal at the this path: address-api/adapter/target
    - Execute the command: java -jar adapter-0.0.1-SNAPSHOT.jar

    
   
## Curl to make the request:
    curl --location 'localhost:8080/v1/get-address?zipcode=95603620'
    
## Link to access the user interface, when the application is running local:
    http://localhost:8080/swagger-ui/index.html
