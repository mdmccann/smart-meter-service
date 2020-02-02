# smart-meter-service

Directions for use:
1) Run project in IDE or build and execute the .jar
2) Perform a GET request on localhost:8080/api/smart/reads/{accountNumber}
    * Using accountNumber=000000001 will return two SmartMeterReading records
    * Using accountNumber=000000002 will return a single SmartMeterReading record
