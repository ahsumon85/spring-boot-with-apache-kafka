# spring-boot-kafka

### Install and Run Kafka: 
To download Kafka, go to the Kafka website https://kafka.apache.org/downloads. Extract the contents of this compressed file into a folder of your preference.
Inside the Kafka directory, go to the bin folder. Here you’ll find many bash scripts that will be useful for running a Kafka application. If you are using Windows, you also have the same scripts inside the windows folder. This tutorial uses Linux commands, but you just need to use the equivalent Windows version if you’re running a Microsoft OS.

### Start Zookeeper to Manage Your Kafka Cluster:
Let’s start a Zookeeper instance! Inside the bin folder in your Kafka directory, run the following command:

`./zookeeper-server-start.sh ../config/zookeeper.properties`

### Run a Kafka Broker: 
The next step is to run the broker itself. From another terminal, run the following command from the bin folder:

`./kafka-server-start.sh ../config/server.properties`

### Create a Kafka Topic:
Now that you have the broker and Zookeeper running, you can specify a topic to start sending messages from a producer. You’re going to run a command inside the bin folder, just like you did in the previous steps:

`./kafka-topics.sh --create --topic myTopic -zookeeper \ localhost:2181 --replication-factor 1 --partitions 1`

### import Spring-boot-kafka project:
`$ mvn clean install`
`$ mvn spring-boot:run`
or spring-boot-kafka project import in IDE

### Run spring-boot-kafka project
Your Java app now has both a Kafka producer and a consumer, so let’s test it all together! Restart your application, and go to postman or browser and enter URL for cunsumer messages by kafka topic `http://localhost:8080/kafka/messages`

Right now, no information is being returned. The reason is pretty simple: your consumer is configured only to receive new messages and you haven’t sent a new message yet. Let’s fix this problem by going to your web browser and accessing `http://localhost:8080/kafka/produce?message=Message sent by my App!.` and send message by producer to kafka broker.
