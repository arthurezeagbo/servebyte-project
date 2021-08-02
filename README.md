# servebyte-project
#APPLICATION SET-UP PROCEDURES
1. Install git on your system
2. Clone the repository by opening command prompt and run git clone https://github.com/arthurezeagbo/servebyte-project.git
3. Open postman or any other application that can run HTTP Requests
4. Start/run the application
5. Application port is configured to 8081
5. Make HTTP Requests to below endpoints:
  Search restaurants by city: GET http://localhost:8081/restaurant/city/{id}
  Select restaurant by id:   GET http://localhost:8081/restaurant/{id}
  Select a meal:              GET http://localhost:8081/restaurant/meals/{id}
  Make payment:              POST  http://localhost:8081/payment
                              {
                                "amount": 20000,
                                "email" : "testemail@gmail.com"
                              }
