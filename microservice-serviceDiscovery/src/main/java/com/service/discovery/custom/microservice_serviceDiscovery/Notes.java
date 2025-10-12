package com.service.discovery.custom.microservice_serviceDiscovery;

public class Notes {

	/*
	
	------------------------------------------------SERVICEDISCOVERY IMPLEMENTION-----------------------------------------------------------

Eureka is a service registry solution provided by Netflix and used widely in Spring Cloud microservices. It helps microservices 
discover each other without hardcoding network locations. Instead of calling a fixed hostname and port, one service can simply call
another using its logical service name
 
How service discovery work internally -> 

create two microservice 7,8 and add dependency eureka-client when we add eureka-client it emit one request in each interval of 30sec 
request url - /eureka/apps/{applicationName} here applicationName is name of application given in application.properites
above url is serviceDiscovery server url . client extract data of client server data contain some information like that

POST /eureka/apps/MICROSERVICE7-SERVICE
{
  "instance": {
    "hostName": "eureka",
    "app": "MICROSERVICE7-SERVICE",
    "ipAddr": "172.18.0.3",
    "status": "UP",
    "port": 8087,
    "vipAddress": "microservice7-service",
    "metadata": {...}
  }
}

this information sent to serviceDiscovery server in every 30sec and serviceDiscovery store that information in map. map structure like that

Map<String, Map<String, Lease<InstanceInfo>>> registry;

outer key hold - value of app(say applicationName like as per above json is "	microservice7-service) 
internal key - value of ipAddar(which is ip assign to docker of application as per docker network)
internal value(Lease<InstanceInfo>) - contain all above json object

when we use microservice-8 to call internally microservice7 having url - String url = "http://MICROSERVICE7/micro7/microservice7/sdcheck";
here AFTER http we use "MICROSERVICE7" which is key of map when we call above url .service discovery extract value against it which is ip (app ip in docker network)
and we able to call services without ip

if we discissed further if eureka-client not sent this heartbeat(request every 30 sec) eureka server de-registered that instance 
we can increate timing for each request as well wait time till this instance can live

we can also create multiple instance of serviceDiscovery(node) and registered with each other so that if any one instance fail other instance
can cater request.

----------------explanation of some command used during create service discovery--------------------

to build all images given in docker-compose file and tha start container = docker-compose -f docker/microservice-serviceDiscovery.yml up -d

to build all images given in docker-compose file = docker-compose -f docker/microservice-serviceDiscovery.yml build

create instance indivisually = docker-compose -f docker/serviceDiscovery-docker-compose.yml up -d eureka1 eureka2 eureka3 microservice8
           ---- above we are building and creating instance of eureka1,2,3 and microservice8 other images will not build apart from this
		   
manually scale or say create instance at runtime = docker-compose -f docker/microservice_serviceDiscovery_test.yml up -d --scale microservice6=2
---- here when we run command docker take image of microservice6 from docker-compose file and create one extra instance if we mention 
     microservice6 = 3 it will create 2 more instance 
	 
	 once instance create it automatically registered by serviceDiscovery because we add dependency of eureka-client
	 
	 
Note:- when we call thirdparty instance using restTemplate which is annotated with @loadbalancer it fetch all detail of registered instance
       and store in local cache memory
	   
	   
each instance should contain these configuration in application.yml file


server:
  port: 0 # port on which app run internally in docker here we use 0 because we let docker know it run app randomly on startup

eureka:
  instance:                   # registred as instance have some metadata
    #appname: micro6-client
    metadata-map:
      version: 1.0.0
      env: dev
    instance-id: ${spring.application.name}:${random.value}          #we provide random value of instanceid so that we can create another instance at runtime otherwise if we do it throw error
    lease-renewal-interval-in-seconds: 60 # send heartbeat every 60s
    lease-expiration-duration-in-seconds: 180 # expire after 180s
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/  # url of eureka server if multiple eureka server is there mentation all eureka server url
    register-with-eureka: true                    # it tell client to send heartbeat request to registered themself if false it will not sent request
    fetch-registry: true                          # it allow client to fetch service-registry detail so that can call in round-robin manner

	
	
Apart from this we make one docker-compose file "microservice-serviceDiscovery.yml" in Docker folder in codebase explaination in file itself
	

--------------------------------------------SpringBoot LoadBalancer-------------------------

to create loadbalancer using springboot create one maven project add dependency of loadbalancer
what happen if we add loadbalancer dependency it able to fetch service-registry where all instance ip contain
and using this ip we can able to do balance load

to do load balance we create bean of restTemplate and make bean annotated with @loadbalancer which use round-robin algorithm to 
transfer load in multiple instance

create one controller class and define one method like below :-

@RequestMapping("/**")
    public String forward(HttpServletRequest request, HttpEntity<String> entity) {
        String path = request.getRequestURI().replace("/lb/micro8", "");
        String url = "http://MICROSERVICE8" + "/micro8"+path;
        return rest.getForObject(url, String.class);
        //return rest.exchange(url, HttpMethod.valueOf(request.getMethod()), entity, String.class);
    }
	
here above in requestmapping we mention "/**" - it accecpt two after /lb/micro8 after that inside method we extract those value after 
"/lb/micro8" and build url and call thirdparty service using serviceDiscovery provided instanceName



	*/
}
