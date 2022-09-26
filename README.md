# dpttransportationapi

A Spring Boot project to build the backend to the Department of Transportation API for Zones and Trips data.

Java version 11.

The data was stored in the database using a Spring Batch job (https://github.com/gabriel-ramalho-albuquerque/transpotautoloader)

The database used is MySQL and the schema name is "transportation" (localhost:3306/transportation).

The database tables and data was created by the Spring Batch job.

Has also a Postman collection in the "postman" folder.

### Database relationships diagram

![Alt text](https://raw.githubusercontent.com/gabriel-ramalho-albuquerque/dpttransportationapi/main/docs/database_relationship_diagrams.PNG?sanitize=true)

### API docs

http://localhost:8181/v3/api-docs

### Swagger UI

http://localhost:8181/swagger-ui/index.html

## API Documentation

#### Return a list of the first 5 zones order by number of total pickups or the number of total drop-offs

```http
  GET /api/v1/location/top-zones
```

| Parameter   | Type       | Description                           |
| :---------- | :--------- | :---------------------------------- |
| `order` | `string` | values can be "dropoffs" or "pickups" |

#### Return the sum of the pickups and drop-offs in just one zone and one date.

```http
  GET /api/v1/location/zone-trips
```

| Parameter   | Type       | Description                           |
| :---------- | :--------- | :------------------------------------------ |
| `zone`      | `long` | value must be the zone id of any of the available zones |
| `date`      | `date` | value must be a date |

### Return data from the yellow trip file with pagination + filtering and multiple sort

```http
  GET /api/v1/trip/list-yellow
```

| Parameter   | Type       | Description                           |
| :---------- | :--------- | :------------------------------------------ |
| `page`      | `long` | page number |
| `size`      | `long` | size of the items list |
| `sort`      | `string` | sorting string (example: sort=id,pickupDateTime) |
| `id`      | `long` | trip id |
| `pickupDate`      | `date` | trip pick up date |
| `dropoffDate`      | `date` |trip drop off date |

### TODO

- Implement exception handling 
- Add HATEOAS
- Try to fix the trip controller test bug that always return an empty list
- Try to change the native queries to JPQL queries
- Add performance tests
- Docker
