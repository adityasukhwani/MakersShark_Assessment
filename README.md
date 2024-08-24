**Task:**

Makersharks is building a search page where buyers can search for manufacturers based on their customised requirements. We're building a proof of concept for the search API.

To run the application perform the following steps :-
1) Clone the repository, Open it in any IDE (Note- Project uses JAVA17)
2) Run the class MakersSharkAssessmentApplication. If it does not run clean maven and install
3) Open Postman or Insomnia.
   a) Create a post request page. Enter the api - http://localhost:8080/api/supplier/query
   b) Go to the body section enter the raw json body to send as parameter to the api
   
   ![image](https://github.com/user-attachments/assets/b0cf4750-d4e8-467f-9547-dee5c930d75f)
   
   You can change the values of location, natureofbusiness and manafacturing process
   c) Click on send you will see the results of the api. Which gives us the a list of X number of manufacturer(s) in a given location, with a specific nature of business, and the capability to perform a specific manufacturing process.
   
   ![image](https://github.com/user-attachments/assets/cbbcd540-6d10-4f0f-92f2-b2a8839f97c5)

4) Or you can use cURL Commands to run -  
curl -X POST http://localhost:8080/api/supplier/query \
-H "Content-Type: application/json" \
-d '{
    "location": "India",
    "natureOfBusiness": "MEDIUM_SCALE",
    "manufacturingProcesses": "MOULDING"
}'

TODO for he project-
1) Implementing security auth for the endpoints (Using Spring security)
2) Unit tests and Swagger UI
   
