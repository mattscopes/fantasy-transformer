# Fantasy Sports Dashboard

Transforms fantasy sports APIs (currently only sleeper API) into an all-in-one, easy-to-use dashboard.

## Features

- `backend/` \- Java 21 / Spring Boot / Maven service that:
    - Calls the Sleeper API via `SleeperClient`.
    - Transforms Sleeper models into internal models in `TransformerService`.
    - Exposes a REST API (via `TransformerController`) to serve league data.
- `frontend/` \- React + Vite that:
    - Lets users search for leagues.
    - Displays league info, teams, and players.
    - Uses components in `src/components/` (e.g. `LeagueSearch`, `LeagueInfo`, `TeamCard`, `Modal`, `Header`, `Footer`).

## Getting Started

### Prerequisites

Backend requirements:
- Java 17+
- Maven 3.8+

Frontend requirements:
- Node.js 18+
- npm 11+

### Setup

Clone the repository:
git clone git@github.com:mattscopes/fantasy-sports-dashboard.git
cd fantasy-sports-dashboard

### Run App (Without Docker)

#### Run Backend

Navigate to `/backend` directory

Build and run the application:
./mvnw spring-boot:run

#### Run Frontend

Navigate to `/frontend` directory

npm install
npm run dev

[//]: # (### Run App &#40;With Docker&#41;)

[//]: # ()
[//]: # (#### Create Network)

[//]: # ()
[//]: # (`docker network create fantasy-sports-dashboard-network'`)

[//]: # ()
[//]: # (#### Run Backend)

[//]: # ()
[//]: # (Navigate to `/backend` directory)

[//]: # ()
[//]: # (`mvn clean install`)

[//]: # (`docker build -t backend .`)

[//]: # ()
[//]: # ([//]: # &#40;`docker run -p 8080:8080 backend`&#41;)
[//]: # (`docker run --name backend-app --network fantasy-sports-dashboard-network -p 8080:8080 -d backend`)

[//]: # ()
[//]: # (#### Run Frontend)

[//]: # ()
[//]: # (Navigate to `/frontend` directory)

[//]: # ()
[//]: # (`docker build -t frontend .`)

[//]: # ()
[//]: # ([//]: # &#40;`docker run -p 5173:5173 frontend`&#41;)
[//]: # (`docker run --name frontend-app --network fantasy-sports-dashboard-network -p 5173:5173 -d frontend`)

## Usage

Open `http://localhost:5173` in your browser to view the UI.

API endpoints are available under `http://localhost:8080/api/` (see `TransformerController.java` for details).

## Testing

Run all backend tests:

./mvnw test

## Future Improvements

- Containerize the application using Docker, and enable the ability to pass in one or multiple league IDs as environment variables.
- Implement league matchups, playoff picks, and draftable players views.
- Add more detailed player statistics (potentially web-scraping ESPN).
- Feed player statistics in AI model for trade suggestions.
- Enhance UI/UX with more features and better design.
- Add support for more fantasy sports APIs.
