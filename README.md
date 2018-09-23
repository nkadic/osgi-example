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



####Apache Felix Tutorial Example 6 ####
####Example 6 - Spell Checker Service Bundle ####


```
alexk@DESKTOP-A1AJKU5 C:\SW\felix-6.0.1\felix-framework-6.0.1
$ java -jar bin/felix.jar
____________________________
Welcome to Apache Felix Gogo

g! felix:install mybundles/spell-checker-service-bundle-1.0-SNAPSHOT.jar                                                                                                               
00:03:20Ex1: Bundle with location  file:/C:/SW/felix-6.0.1/felix-framework-6.0.1/mybundles/spell-checker-service-bundle-1.0-SNAPSHOT.jar INSTALLED.Bundle ID: 26

g! lb                                                                                                                                                                                  
00:03:40START LEVEL 1
   ID|State      |Level|Name
    0|Active     |    0|System Bundle (6.0.1)|6.0.1
    1|Active     |    1|jansi (1.17.1)|1.17.1
    2|Active     |    1|JLine Bundle (3.7.0)|3.7.0
    3|Active     |    1|Apache Felix Bundle Repository (2.0.10)|2.0.10
    4|Active     |    1|Apache Felix Gogo Command (1.0.2)|1.0.2
    5|Active     |    1|Apache Felix Gogo JLine Shell (1.1.0)|1.1.0
    6|Active     |    1|Apache Felix Gogo Runtime (1.1.0)|1.1.0
   22|Active     |    1|dictionary-service-bundle (1.0.0.SNAPSHOT)|1.0.0.SNAPSHOT
   23|Active     |    1|service-event-listener-bundle (1.0.0.SNAPSHOT)|1.0.0.SNAPSHOT
   26|Installed  |    1|spell-checker-service-bundle (1.0.0.SNAPSHOT)|1.0.0.SNAPSHOT
g! start 26                                                                                                                                                                            
00:03:44Ex1: Bundle with location  file:/C:/SW/felix-6.0.1/felix-framework-6.0.1/mybundles/spell-checker-service-bundle-1.0-SNAPSHOT.jar RESOLVED.
g!                                                                                                                                                                                     
00:03:51
```

####Apache Felix Tutorial Example 9 ####
####Example 9 - Spell Checker Service using Declarative Services ####

```
g! felix:install mybundles/spell-checker-service-using-declarative-services-1.0-SNAPSHOT.jar                                                                                           
00:25:00Bundle ID: 28Ex1: Bundle with location  file:/C:/SW/felix-6.0.1/felix-framework-6.0.1/mybundles/spell-checker-service-using-declarative-services-1.0-SNAPSHOT.jar INSTALLED.

g! start 28                                                                                                                                                                            
00:25:05Ex1: Bundle with location  file:/C:/SW/felix-6.0.1/felix-framework-6.0.1/mybundles/spell-checker-service-using-declarative-services-1.0-SNAPSHOT.jar RESOLVED.
Ex1: Bundle with location  file:/C:/SW/felix-6.0.1/felix-framework-6.0.1/mybundles/spell-checker-service-using-declarative-services-1.0-SNAPSHOT.jar STARTED.
g!                                                                                                                                                                                     00:25:12g!                                                                                                                                                                                     00:25:26g!                                                                                                                                                                                     00:25:26g! lb                                                                                                                                                                                  00:25:27START LEVEL 1
   ID|State      |Level|Name
    0|Active     |    0|System Bundle (6.0.1)|6.0.1
    1|Active     |    1|jansi (1.17.1)|1.17.1
    2|Active     |    1|JLine Bundle (3.7.0)|3.7.0
    3|Active     |    1|Apache Felix Bundle Repository (2.0.10)|2.0.10
    4|Active     |    1|Apache Felix Gogo Command (1.0.2)|1.0.2
    5|Active     |    1|Apache Felix Gogo JLine Shell (1.1.0)|1.1.0
    6|Active     |    1|Apache Felix Gogo Runtime (1.1.0)|1.1.0
   22|Active     |    1|dictionary-service-bundle (1.0.0.SNAPSHOT)|1.0.0.SNAPSHOT
   23|Active     |    1|service-event-listener-bundle (1.0.0.SNAPSHOT)|1.0.0.SNAPSHOT
   26|Active     |    1|spell-checker-service-bundle (1.0.0.SNAPSHOT)|1.0.0.SNAPSHOT
   28|Active     |    1|spell-checker-service-using-declarative-services (1.0.0.SNAPSHOT)|1.0.0.SNAPSHOT
g!                                                                                                                                                                                     00:25:28
```