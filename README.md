osgi-example [![Build Status](https://travis-ci.org/teverett/osgi-example.png?branch=master)](https://travis-ci.org/teverett/osgi-example)
============

A simple example which publishes an OSGI service

Building & testing
------

Simply use maven:

`mvn clean package`

#### The bundle jar files are  #### 

Apache Felix Tutorial Example 1 - Service Event Listener Bundle

service-event-listener-bundle : ServiceListener, BundleListener

Apache Felix Tutorial Example 2 - Dictionary Service Bundle

dictionary-service-bundle

#### Installing and running in Felix #### 
------

Firstly get the Felix framework from [http://felix.apache.org/downloads.cgi](http://felix.apache.org/downloads.cgi)

Secondly extract the Felix runtime and copy the jar file into the `/mybundles/` directory (e.g. service-event-listener-bundle-1.0-SNAPSHOT.jar and dictionary-service-bundle-1.0-SNAPSHOT.jar.

Finally, run felix

`java -jar bin\felix.jar`




Download and unzip into felix-framework-6.0.1
cd felix-framework-6.0.1
`java -jar bin\felix.jar`

```
felix:install mybundles/osgi-rest-1.0-SNAPSHOT.jar
```
```
lb
START LEVEL 1
   ID|State      |Level|Name
    0|Active     |    0|System Bundle (6.0.1)|6.0.1
    1|Active     |    1|jansi (1.17.1)|1.17.1
    2|Active     |    1|JLine Bundle (3.7.0)|3.7.0
    3|Active     |    1|Apache Felix Bundle Repository (2.0.10)|2.0.10
    4|Active     |    1|Apache Felix Gogo Command (1.0.2)|1.0.2
    5|Active     |    1|Apache Felix Gogo JLine Shell (1.1.0)|1.1.0
    6|Active     |    1|Apache Felix Gogo Runtime (1.1.0)|1.1.0
   22|Active  |    1|dictionary-service-bundle (1.0.0.SNAPSHOT)|1.0.0.SNAPSHOT
   23|Active     |    1|service-event-listener-bundle (1.0.0.SNAPSHOT)|1.0.0.SNAPSHOT
```
