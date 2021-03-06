# Trustly Challenge 

### Challenge:
Develop an API that returns the total number of lines and the total number of bytes of all the files of a given public Github repository, grouped by file extension.


# Author 

### Caio de Souza Moreira - Linkedin - https://www.linkedin.com/in/caiodesouzamoreira/


# Requirements:

 ``` 
 
•	Your API must be written using Java 8 or newer, ECMAscript 2015 or newer, or C# 8.0;
•	Data must be retrieved from Github website by using web scraping techniques. Do not use Github’s API;
•	Do not use web scraping libraries. We would like to know your ideas on how it can be done;
•	Your API must support thousands of concurrent requests;
•	We think it’s ok if the first request to a particular repository takes some time to respond (since you depend on Github website response times), but we don’t expect the subsequent requests to be long;
•	We don’t expect to get timeout errors;
•	We must understand your code and use your API without having to ask you any questions. Our primary language is English so please use it on comments and documentation;
•	We’d like to see SOLID principles in your solution;
•	You are free to choose your API contracts (parameters and response formats) but we’d like to be able to integrate it with any other existing solutions;
•	You don’t need to persist any data (but feel free to do it if you want);
•	We’d like to see at least one automated test;
•	You must deploy your solution to a cloud provider like Amazon AWS or Heroku and send us the link to access it. It’s a plus if you publish a Docker image with your application (including its dependencies) in a registry like Docker Hub and let us know how to get it.  

 ``` 

# How to use it :
### This app is hosted at Heroku .
You should send a GET Request with two Request Parameters , like the example below :
       https://trustly-challenge.herokuapp.com/github/repository?owner={owner}&repo={repositoryname}

# Request Examples:


• https://trustly-challenge.herokuapp.com/github/repository?owner=caiodsouza22&repo=test-hearthstone

• https://trustly-challenge.herokuapp.com/github/repository?owner=caiodsouza22&repo=ServiceOrder-system

• https://trustly-challenge.herokuapp.com/github/repository?owner=elastic&repo=elasticsearch

