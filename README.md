# Busy Flights
BusyFlights is a flights search solution which aggregates flight results initially from 2 different suppliers (CrazyAir and ToughJet). 
This application will return the following content:
```json
[
  {
    "airline": "Vueling Airlines",
    "supplier": "ToughJet",
    "fare": 175.75,
    "departureAirportCode": "LHR",
    "destinationAirportCode": "CDG",
    "departureDate": [2017, 6, 12, 0, 0],
    "arrivalDate": [2017, 6, 21, 0, 0]
  },
  {
    "airline": "Air France",
    "supplier": "CrazyAir",
    "fare": 190,
    "departureAirportCode": "LGW",
    "destinationAirportCode": "CDG",
    "departureDate": [2017, 6, 12, 1, 0]
   },
    ...
]
```

### Build
**Building in a local environment:**
- Clone the code from the repository:
```
git clone https://github.com/hchaves82/busyflights.git
```
- Go to the folder that the code was cloned and type
```
mvn clean install
```

### Run wiremock to simulate the providers
- Download wiremock-standalone-2.6.0.jar
- Enter the folder of the jar and create the subfolders __files and mappings
- Put crazyair.json and toughjet.json files in the mappings folder
- Run wiremock-standalone-2.6.0.jar
```
java -jar wiremock-standalone-2.6.0.jar --port 9090
```

### Run Server application
- Go to the folder that the code was cloned and type
```
1 - cd busyflights
2 - mvn spring-boot:run
```

### Executing
- Use Postman
- Enter the informations below: 
- Method: POST
- url: http://localhost:8080/search
- Hearders: Content-Type=application/json
- Body:
```
{
	"origin":"LHR",
	"destination":"CDG",
	"departureDate": "2017-06-12T10:21:30",
	"returnDate":"2017-06-30T10:21:30",
	"numberOfPassengers": 2
}
