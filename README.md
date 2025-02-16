# Spring Boot 3 - Kotlin Modulith Template

This is a template project for a Spring Boot 3 application written in Kotlin. It is based on the modulith architecture pattern.

## Features
- [ ] Does not work
## References used to create this project
- [modulith](https://github.com/edreyer/modulith)
- [codecentric's blog](https://www.codecentric.de/wissens-hub/blog/modularization-the-easy-way-spring-modulith-with-kotlin-and-hexagonal-architecture)

## Goal of this project
```mermaid
flowchart TD
    %% Global nodes
    Client["Client Requests"]:::client
    ServerModule["Modulith Application (Server Module)"]:::server
    CommonModule["Common Module"]:::common
    MongoDB["MongoDB"]:::db

    %% Connections from Client to Server Module
    Client -->|"calls"| ServerModule

    %% order Bounded Context
    subgraph "Order Bounded Context"
        orderAPI["Order API"]:::api
        orderInbound["Order Inbound Adapter (Web API)"]:::inbound
        orderApp["Order Application & Workflows"]:::app
        orderDomain["Order Domain"]:::domain
        orderOutbound["Order Outbound Adapter (Persistence)"]:::outbound
    end

    %% Payment Bounded Context
    subgraph "Payment Bounded Context"
        paymentAPI["Payment API"]:::api
        paymentInbound["Payment Inbound Adapter (Web API)"]:::inbound
        paymentApp["Payment Application & Workflows"]:::app
        paymentDomain["Payment Domain"]:::domain
        paymentOutbound["Payment Outbound Adapter (Persistence)"]:::outbound
    end

    %% User Bounded Context
    subgraph "User Bounded Context"
        userAPI["User API"]:::api
        userInbound["User Inbound Adapter (Web API)"]:::inbound
        userApp["User Application & Workflows"]:::app
        userDomain["User Domain"]:::domain
        userOutbound["User Outbound Adapter (Persistence)"]:::outbound
    end

    %% Server Module integrates with each Bounded Context API
    ServerModule -->|"registers"| orderAPI
    ServerModule -->|"registers"| paymentAPI
    ServerModule -->|"registers"| userAPI

    %% order context flow
    orderAPI -->|"to"| orderInbound
    orderInbound -->|"triggers"| orderApp
    orderApp -->|"invokes"| orderDomain
    orderDomain -->|"persists via"| orderOutbound
    orderOutbound -->|"saves to"| MongoDB
    orderApp -.->|"uses"| CommonModule

    %% Payment context flow
    paymentAPI -->|"to"| paymentInbound
    paymentInbound -->|"triggers"| paymentApp
    paymentApp -->|"invokes"| paymentDomain
    paymentDomain -->|"persists via"| paymentOutbound
    paymentOutbound -->|"saves to"| MongoDB
    paymentApp -.->|"uses"| CommonModule

    %% User context flow
    userAPI -->|"to"| userInbound
    userInbound -->|"triggers"| userApp
    userApp -->|"invokes"| userDomain
    userDomain -->|"persists via"| userOutbound
    userOutbound -->|"saves to"| MongoDB
    userApp -.->|"uses"| CommonModule

    %% Styles
    classDef client fill:#F5DEB3,stroke:#333,stroke-width:2px;
    classDef server fill:#DDA0DD,stroke:#333,stroke-width:2px;
    classDef api fill:#D8BFD8,stroke:#333,stroke-width:2px;
    classDef inbound fill:#ADD8E6,stroke:#333,stroke-width:2px;
    classDef app fill:#90EE90,stroke:#333,stroke-width:2px;
    classDef domain fill:#FFEB99,stroke:#333,stroke-width:2px;
    classDef outbound fill:#FFA07A,stroke:#333,stroke-width:2px;
    classDef common fill:#D3D3D3,stroke:#333,stroke-width:2px;
    classDef db fill:#E6E6FA,stroke:#333,stroke-width:2px;
```