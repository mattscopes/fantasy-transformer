# Fantasy Transformer

Transforms fantasy sports APIs (currently just with Sleeper API) into unambiguous, viewable data.

## Features

- Modern React-based dashboard with clean, intuitive UI
- Integrates with Sleeper fantasy sports API
- Caches API responses for performance
- RESTful endpoints for league, player, roster, and user data
- Responsive design that works on desktop and mobile
- Component-based architecture for easy maintenance

## Getting Started

### Prerequisites

- Java 17+
- Maven 3.8+
- Node.js 18+ and npm (for frontend development)
- Git

### Setup

Clone the repository:
```bash
git clone git@github.com:mattscopes/sleeper-transform.git
cd fantasy-transformer
```

Build and run the application:
```bash
./mvnw spring-boot:run
```

The app will start on [http://localhost:8080](http://localhost:8080).

### Frontend Development

To work on the React frontend with hot-reload:

```bash
cd frontend
npm install
npm run dev
```

This starts the Vite dev server on `http://localhost:5173` with API proxy to the Spring Boot backend.

To build the frontend for production:
```bash
cd frontend
npm run build
```

This compiles the React app and outputs to `src/main/resources/static/`.

## Usage

Open `http://localhost:8080` in your browser to view the modern React dashboard.

Enter a Sleeper league ID to view:
- League information
- Team rosters with starters, bench, reserves, and taxi squad
- Player details in interactive cards
- Responsive layout for any screen size

API endpoints are available under `/api/` (see `TransformerController.java` for details).

## Testing

Run all tests:
```bash
./mvnw test
```

## Technology Stack

**Backend:**
- Spring Boot 3.5.5
- Java 17
- Maven

**Frontend:**
- React 19
- Vite 7
- Modern CSS with gradients and animations
