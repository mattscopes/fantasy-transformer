# Fantasy Transformer

Transforms fantasy sports APIs into unambiguous, viewable data.

## Features

- Integrates with Sleeper fantasy sports API
- Caches API responses for performance
- RESTful endpoints for league, player, roster, and user data
- Modular Spring Boot architecture

## Getting Started

### Prerequisites

- Java 21+
- Maven 3.8+
- Git

### Setup

Clone the repository:
git clone git@github.com:mattscopes/sleeper-transform.git cd fantasy-transformer

Build and run the application:
./mvnw spring-boot:run

The app will start on [http://localhost:8080](http://localhost:8080).

## Usage

Open `http://localhost:8080` in your browser to view the UI.

API endpoints are available under `/api/` (see `TransformerController.java` for details).

## Testing

Run all tests:

./mvnw test
