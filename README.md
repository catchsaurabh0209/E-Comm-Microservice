# E-Comm-Microservice

![Project Architecture](https://github.com/catchsaurabh0209/E-Comm-Microservice/blob/main/microservice.png)

## Overview
A E-Commerce backend by following microservice architecture.

## Services

### Product Service
- Utilizes MongoDB to store comprehensive product details.
  
### Order Service
- Leverages MySQL database for efficient order management, including order placement.

### Inventory Service
- Utilizes MySQL to manage inventory details and swiftly verify product availability.

### Notification Service
- Seamlessly sends notifications upon order placement, enhancing user engagement and experience.

## Key Features

### Eureka Service Discovery
- Deployed Eureka Discovery Server to facilitate service registration and discovery.
- Configured services as Eureka clients, enabling seamless inter-service sync communication.
- Implements fault tolerance, ensuring uninterrupted service in case of instance failure.

### Synchronous Communication
- Utilizes WebClient for robust synchronous communication between services, optimizing performance and reliability.

### Secure Authentication with Keycloak
- Implements Keycloak as the Authorization Server to authenticate incoming API requests to the API gateway, ensuring secure access.

### Resilience
- Incorporates Resilience4J to fortify system resilience, mitigating potential failures and ensuring continuous operation.

### Event-Driven Architecture with Kafka
- Embraces event-driven architecture with Kafka for asynchronous communication.
- Implements Kafka to dispatch notifications swiftly upon order placement through the notification service.

## Installation and Setup
- Clone the repository to your local machine.
- Configure each service according to the provided documentation.
- Ensure all dependencies are installed and configured.
- Run each service individually or deploy using your preferred containerization tool.

## Contributions
- Contributions are welcome! Please fork the repository and submit a pull request for review.

## Contact
For inquiries, connect on [LinkedIn](https://www.linkedin.com/in/suman-saurabh-433b00173/).

