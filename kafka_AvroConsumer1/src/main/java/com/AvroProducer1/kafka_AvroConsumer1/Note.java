package com.AvroProducer1.kafka_AvroConsumer1;

public class Note {

	/*
	issue face
	1> I have created same avro file in producer and consumer and compile it.but at consumer
	   side we are not able to de-serialize the order(class) data?
	 -> because schema-registry only share the schemaId and shema formate to validate data are correct or not at both end
	    but when we share data to broker using producer where we use avro serializer at other
	    we are not able to de-serialize the order data because both avro file even formate
	    are same jave considered it as different file because it load by different classloader
	    and kafka send data in binary formate not java object
	    
	    solution - create one common place called avro-module as create in project
	               and give pom.xml file and avro file. than compile it you get order.java
	               file than just add dependency of avro-module in producer and consumer
	               data perfectly serialize and de-serialize
	               
	  */             
}