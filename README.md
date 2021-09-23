# pangaea-assessment

The project runs on two servers. Publisher Server Port 8000 and Subscriber 9000


#To start the Publisher Server

cd Into publisher Directory

Run mvn clean install

cd into the target directory inside publisher 

Run java -jar publisher-0.0.1-SNAPSHOT.jar

#To start the Subscriber Server

cd Into subscriber Directory

Run mvn clean install

cd into the target directory inside subscriber

Run java -jar subscriber-0.0.1-SNAPSHOT.jar


# Create a subscription

curl -X POST "http://localhost:8000/subscribe/topic1" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"url\": \"http://localhost:9000/test1\"}"

#Publish message to topic

curl -X POST "http://localhost:8000/publish/topic1" -H "accept: */*" -H "Content-Type: application/json" -d "\"hello\""
