# Grails 7.0.0-M4 Class Resolution Order Bug

Compare the output order of the following:
```
./gradlew clean :bootRun
```

```
./gradlew clean :bootJar --warning-mode none && java -jar build/libs/namespacebug-0.1.jar 
```