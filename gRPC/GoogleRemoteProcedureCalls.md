# gRPC

## Purpose
gRPC (gRPC Remote Procedure Calls) is a modern, high-performance, open-source RPC framework developed by Google. It enables efficient communication between distributed systems, particularly microservices, by allowing client and server applications to communicate transparently.

## What It Is
- **IDL-Based RPC Framework:** gRPC uses **Protocol Buffers (Protobuf)** as its Interface Definition Language (IDL) to define the structure of messages and services.
- **Cross-Language Support:** Works with many languages including Java, Go, Python, C++, Node.js, Ruby, and more.
- **Built on HTTP/2:** gRPC uses HTTP/2 for transport, enabling features like:
  - Multiplexed streams (multiple calls over a single TCP connection)
  - Bi-directional streaming
  - Header compression
  - Low latency and high throughput

## Key Features
- **Strongly-Typed APIs:** Defined using Protobuf, which enforces contract-first development.
- **Code Generation:** Automatically generates client and server stubs in supported languages.
- **Streaming Support:**
  - Unary (single request–response)
  - Server streaming
  - Client streaming
  - Bi-directional streaming
- **Authentication & Security:** Supports SSL/TLS, token-based authentication, and integration with systems like OAuth2.
- **Load Balancing, Tracing & Monitoring:** Client-side load balancing and hooks for distributed tracing.
- **Pluggable Architecture:** Support for interceptors, custom serializers, and authentication mechanisms.

## When to Use gRPC
- Internal communication between microservices
- Real-time applications (e.g., chat, gaming, IoT)
- Low-latency, high-throughput APIs (e.g., ML inference, media)
- Replacing REST APIs for performance-critical components
- Efficient communication between polyglot services
- Mobile or edge environments where payload size and bandwidth efficiency matter

## Basic Example

### 1. Protobuf Service Definition (`hello.proto`)
```proto
syntax = "proto3";

package hello;

service HelloService {
  rpc SayHello (HelloRequest) returns (HelloResponse);
}

message HelloRequest {
  string name = 1;
}

message HelloResponse {
  string message = 1;
}
```

### 2. Java Server-Side Implementation
```java
public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {
  @Override
  public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
    String greeting = "Hello, " + request.getName();
    HelloResponse response = HelloResponse.newBuilder().setMessage(greeting).build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}
```

### 3. Java Client Usage
```java
ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                                               .usePlaintext()
                                               .build();

HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);

HelloRequest request = HelloRequest.newBuilder().setName("Alice").build();
HelloResponse response = stub.sayHello(request);

System.out.println(response.getMessage());
channel.shutdown();
```

## Comparison to REST

| Feature               | gRPC                             | REST                               |
|-----------------------|----------------------------------|------------------------------------|
| Protocol              | HTTP/2                           | HTTP/1.1                           |
| Message Format        | Protobuf (binary, compact)       | JSON (text-based, verbose)         |
| Performance           | High                             | Medium                             |
| Streaming Support     | Yes (built-in)                   | Limited (via SSE or WebSockets)    |
| Code Generation       | Strong                           | Weak (often manual)                |
| Browser Compatibility | Limited (requires gRPC-Web)      | Excellent                          |

## gRPC Ecosystem & Tools

- **gRPC-Web**: Enables gRPC calls from browsers using an HTTP/1.1-compatible wrapper.
- **Envoy Proxy**: Commonly used as a proxy and API gateway with gRPC.
- **Protocol Buffers Compiler (`protoc`)**: Generates code from `.proto` files.
- **gRPC Reflection**: Allows tools to discover services and methods at runtime.
- **Interceptors**: Middleware-like support for logging, authentication, etc.

## Drawbacks / Considerations

- Steeper learning curve than REST
- Not natively supported in browsers (requires `grpc-web`)
- Binary protocol makes debugging harder without tools like `grpcurl`
- Breaking changes to `.proto` files must be carefully managed

## Useful Tools

- **grpcurl** – CLI tool to invoke gRPC services  
- **Evans** – gRPC CLI client  
- **BloomRPC** – GUI client for gRPC  
- **protoc-gen-*** – Language-specific code generation plugins
