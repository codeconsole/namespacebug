# Grails 7.0.0-M4 Class Resolution Order Bug

Compare the output order of the following:
```
./gradlew clean :bootRun
```
results in:
```
4 classes detected.
namespacebug.BootStrap
namespacebug.UrlMappings
namespacebug.Application
namespacebug.UserController
Grails application running at http://localhost:8080 in environment: development
```

```
./gradlew clean :bootJar --warning-mode none && java -jar build/libs/namespacebug-0.1.jar 
```
results in:
```
4 classes detected.
namespacebug.Application
namespacebug.BootStrap
namespacebug.UrlMappings
namespacebug.UserController
Grails application running at http://localhost:8080 in environment: production
```

### BUT ACTUALLY bootJar is COMPLETELY RANDOM

```
% ./gradlew clean :bootRun
4 classes detected.
namespacebug.Application
namespacebug.BootStrap
namespacebug.UrlMappings
namespacebug.UserController
Grails application running at http://localhost:8080 in environment: production
^C%                                                                                                                                                                              
% ./gradlew clean :bootJar --warning-mode none && java -jar build/libs/namespacebug-0.1.jar 

BUILD SUCCESSFUL in 3s
19 actionable tasks: 16 executed, 3 up-to-date
4 classes detected.
namespacebug.Application
namespacebug.BootStrap
namespacebug.UrlMappings
namespacebug.UserController
Grails application running at http://localhost:8080 in environment: production
^C%                                                                                                                                                                              
% ./gradlew clean :bootRun                                                                  

> Task :bootRun
4 classes detected.
namespacebug.Application
namespacebug.UrlMappings
namespacebug.BootStrap
namespacebug.UserController
Grails application running at http://localhost:8080 in environment: development
<============-> 95% EXECUTING [7s]
> :bootRun
^C%                                                                                                                                                                              
% ./gradlew clean :bootJar --warning-mode none && java -jar build/libs/namespacebug-0.1.jar 

BUILD SUCCESSFUL in 3s
19 actionable tasks: 16 executed, 3 up-to-date
4 classes detected.
namespacebug.Application
namespacebug.UserController
namespacebug.BootStrap
namespacebug.UrlMappings
Grails application running at http://localhost:8080 in environment: production
```

## Notice above the position of UserController changes in subsequent jar running with no code changes