# graphql-example

Simple example using GraphQL with cars and engines.

## Run and Query

Start the server up

```shell
./gradlew run
```

Queries:

- Makes of all cars: http://localhost:4567/graphql?query={cars{make}}
- All cars selecting all attributes: http://localhost:4567/graphql?query={cars{make,model,engine{capacity,fuel}}}
- Find Volkswagon car: http://localhost:4567/graphql?query={car(make:"Volkswagon"){make,model}}
- All engines: http://localhost:4567/graphql?query={engines{capacity,fuel}}
