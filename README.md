# Redis Cache QA application (In Progress)

Q/A application with redis cache and Spring Boot

## Requirement
* Java 8
* Docker
* Postman
* Redis Desktop Manager

## Running the sample app

* Install and run Redis server
```
docker run -d -p 6379:6379 redis:latest
```
* Now run Spring Boot application using below command
```
mvn spring-boot:run
```
* Open postman or cURL and start hitting APIs :bowtie:

## Testing

* Let's add our first question
![Alt text](https://github.com/Nasruddin/redis-cache-qa/blob/master/images/add-question.JPG?raw=true "Adding question")

* We will add few answers as well
![Alt text](https://github.com/Nasruddin/redis-cache-qa/blob/master/images/add-answer3.JPG?raw=true "Adding answer")
![Alt text](https://github.com/Nasruddin/redis-cache-qa/blob/master/images/add-answer2.JPG?raw=true "Adding answer")

* Now try fetching questions with answers from Redis
![Alt text](https://github.com/Nasruddin/redis-cache-qa/blob/master/images/get-question-with-answer.JPG?raw=true "Getting question with answers")
![Alt text](https://github.com/Nasruddin/redis-cache-qa/blob/master/images/redis.JPG?raw=true "Redis screenshot")

## Contact
Nasruddin @iam_nasir

Email: nasruddin.java@gmail.com