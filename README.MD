## Run the project
```
sbt clean run
```

## Test service with wrk tool
send request with 50 threads, 100 active connections, 5 seconds long:
```
wrk -t50 -c100 -d5s http://127.0.0.1:8080/greeting/1
```
