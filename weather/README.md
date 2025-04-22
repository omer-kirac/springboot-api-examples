# Weather API Service

# Project idea https://roadmap.sh/projects/weather-api-wrapper-service

This project is a Spring Boot based service that connects to an external weather API and optimizes the results with Redis caching.

## Features

- City-based weather data
- Reduced API calls with caching (Redis)
- Automatic cache refresh with 6-hour TTL

## Technologies

- Spring Boot 3.4.4
- Spring Data Redis
- Java 17
- Maven

## Getting Started

### Requirements

- JDK 17
- Maven
- Redis

### Running the Application

```bash
mvn spring-boot:run
```

## API Usage

### Get Weather for a City

```
GET /weather?city={city_name}
```

**Example:**
```bash
curl "http://localhost:8080/weather?city=Istanbul"
```

**Sample Response:**
```json
{
  "datetime": "2023-09-30",
  "address": "Istanbul, Turkey",
  "temperature": 22.7,
  "conditions": "Partly cloudy",
  "description": "Partly cloudy throughout the day with a chance of showers."
}
```

## Configuration

The application can be configured in the `application.properties` file:

```properties
# API configuration
weather.api.url=https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/{city}
weather.api.key=YOUR-API-KEY

# Redis configuration
spring.data.redis.host=localhost
spring.data.redis.port=6379
redis.ttl.hours=6
```

## Caching Strategy

- Weather data is cached for 6 hours
- Requests for the same city within 6 hours are responded from the cache without reaching the API
- Data is automatically updated when the TTL expires

## Contributing

1. Fork this repository
2. Create a feature branch (`git checkout -b new-feature`)
3. Commit your changes (`git commit -am 'Added new feature'`)
4. Push to the branch (`git push origin new-feature`)
5. Create a Pull Request

## License

This project is licensed under the [MIT License](LICENSE). 
