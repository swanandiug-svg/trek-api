# Trek API

A REST API for discovering and managing Indian trekking and cycling routes, built with Spring Boot and PostgreSQL.

## Tech Stack
- Java 24
- Spring Boot 3.5.1
- PostgreSQL
- Maven

## How to Run Locally

1. Clone the repo
2. Create a PostgreSQL database called `trekdb`
3. Create a `.env` file in the root with:
4. 4. Run the project from IntelliJ or with `mvn spring-boot:run`
5. API will be available at `http://localhost:8080`

## API Endpoints

### Trails
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /trails | Get all trails |
| GET | /trails/{id} | Get trail by ID |
| POST | /trails | Create a new trail |
| PUT | /trails/{id} | Update a trail |
| GET | /trails/filter/difficulty/{difficulty} | Filter by difficulty |
| GET | /trails/filter/state/{state} | Filter by state |
| GET | /trails/filter/distance/{distance} | Filter by max distance |
| GET | /trails/filter/difficulty/{difficulty}/state/{state} | Filter by difficulty and state |
| GET | /trails/search?name={name} | Search trails by name |
| GET | /trails/sort/distance | Sort by distance ascending |
| GET | /trails/sort/elevation | Sort by elevation descending |

### Favourites
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /favourites/{username} | Get favourites for a user |
| POST | /favourites/{username}/{trailId} | Add a trail to favourites |
| DELETE | /favourites/{favouriteId} | Remove a favourite |



