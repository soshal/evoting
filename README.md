# evoting
# E-Voting System Microservices Architecture

This project implements an electronic voting system using a microservices architecture with Spring Boot. The system includes multiple services that communicate with each other through an API Gateway and are registered with a Eureka Service Discovery server.

## System Architecture

![Microservices Architecture Diagram](https://i.imgur.com/JKQmQ7E.png)

The system consists of the following services:

1. **Eureka Server** - Service discovery and registration
2. **API Gateway** - Single entry point for all client requests
3. **Voter Service** - Manages voter registration and information
4. **Candidate Service** - Manages candidate information
5. **Election Service** - Handles election creation and voting process
6. **Result Service** - Calculates and provides election results

## Technologies Used

- Java 17
- Spring Boot 3.x
- Spring Cloud (Eureka, Gateway, OpenFeign)
- H2 Database (in-memory)
- Lombok
- Maven

## Getting Started

### Prerequisites

- Java 17 JDK
- Maven 3.8+
- IDE (IntelliJ IDEA, Eclipse, or VS Code recommended)

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/e-voting-system.git
   cd e-voting-system
   ```

2. Build all services:
   ```bash
   mvn clean install
   ```

### Running the System

Start the services in the following order:

1. Eureka Server:
   ```bash
   cd eureka-server
   mvn spring-boot:run
   ```

2. API Gateway:
   ```bash
   cd api-gateway
   mvn spring-boot:run
   ```

3. Voter Service:
   ```bash
   cd voter-service
   mvn spring-boot:run
   ```

4. Candidate Service:
   ```bash
   cd candidate-service
   mvn spring-boot:run
   ```

5. Election Service:
   ```bash
   cd election-service
   mvn spring-boot:run
   ```

6. Result Service:
   ```bash
   cd result-service
   mvn spring-boot:run
   ```

## Service Ports

| Service           | Port |
|-------------------|------|
| Eureka Server     | 8761 |
| API Gateway       | 8080 |
| Voter Service     | 8081 |
| Candidate Service | 8082 |
| Election Service  | 8083 |
| Result Service    | 8084 |

## API Endpoints

All endpoints are accessed through the API Gateway at `http://localhost:8080`

### Voter Service
- `POST /api/voters` - Register a new voter
- `GET /api/voters` - Get all voters
- `GET /api/voters/{id}` - Get voter by ID
- `GET /api/voters/by-government-id/{governmentId}` - Get voter by government ID

### Candidate Service
- `POST /api/candidates` - Add a new candidate
- `GET /api/candidates` - Get all candidates
- `GET /api/candidates/{id}` - Get candidate by ID

### Election Service
- `POST /api/elections` - Create a new election
- `POST /api/elections/vote` - Cast a vote
- `GET /api/elections/{electionId}/votes` - Get votes for an election

### Result Service
- `GET /api/results/{electionId}` - Get election results

## H2 Database Console

Each service has an in-memory H2 database with a web console accessible at:

- Voter Service: `http://localhost:8081/h2-console`
- Candidate Service: `http://localhost:8082/h2-console`
- Election Service: `http://localhost:8083/h2-console`
- Result Service: `http://localhost:8084/h2-console`

JDBC URL: `jdbc:h2:mem:<service>Db` (e.g., `jdbc:h2:mem:voterDb` for Voter Service)
Username: `sa`
Password: (leave empty)

## Testing the System

1. Register voters:
   ```bash
   curl -X POST -H "Content-Type: application/json" -d '{"name":"John Doe","email":"john@example.com","governmentId":"ID123456"}' http://localhost:8080/api/voters
   ```

2. Add candidates:
   ```bash
   curl -X POST -H "Content-Type: application/json" -d '{"name":"Alice Smith","party":"Green Party","position":"President"}' http://localhost:8080/api/candidates
   ```

3. Create an election:
   ```bash
   curl -X POST -H "Content-Type: application/json" -d '{"name":"2023 Presidential Election","startTime":"2023-11-01T08:00:00","endTime":"2023-11-01T20:00:00","active":true}' http://localhost:8080/api/elections
   ```

4. Cast votes:
   ```bash
   curl -X POST -H "Content-Type: application/json" -d '{"electionId":1,"voterId":1,"candidateId":1}' http://localhost:8080/api/elections/vote
   ```

5. Check results:
   ```bash
   curl http://localhost:8080/api/results/1
   ```

## Future Enhancements

1. Add authentication and authorization with JWT
2. Implement proper input validation
3. Add comprehensive error handling
4. Write unit and integration tests
5. Containerize services with Docker
6. Deploy to Kubernetes
7. Add monitoring with Spring Boot Actuator and Prometheus
8. Implement distributed tracing with Zipkin
9. Add message queue for asynchronous communication
10. Implement database persistence with PostgreSQL

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Spring Boot and Spring Cloud teams
- Microservices architecture patterns
- Open source community contributions
