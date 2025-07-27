# gRPC

**Purpose:**  
gRPC is a modern, high-performance Remote Procedure Call (RPC) framework that helps build scalable APIs and microservices.

**What it is:**  
It uses Protocol Buffers (protobuf) to define services and message types and supports multiple languages.

**When to use:**  
- Building efficient client-server communication  
- Inter-service communication in microservices  
- Real-time data streaming

**Basic Example:**  
```java
// Define service in .proto file
syntax = "proto3";

service HelloService {
  rpc sayHello (HelloRequest) returns (HelloResponse);
}

message HelloRequest {
  string name = 1;
}

message HelloResponse {
  string message = 1;
}

// Server-side implementation (Java)
public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {
  @Override
  public void sayHello(HelloRequest req, StreamObserver<HelloResponse> responseObserver) {
    String greeting = "Hello, " + req.getName();
    HelloResponse reply = HelloResponse.newBuilder().setMessage(greeting).build();
    responseObserver.onNext(reply);
    responseObserver.onCompleted();
  }
}
