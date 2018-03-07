# graphql-example

Simple example using GraphQL with cars and engines.

Example uses static data stored in the classes within the repositories package.
This could easily be amended to fetch live data from a database.

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

Or to run queries easier use GraphQL IDE: https://github.com/andev-software/graphql-ide

Just set the environment URL to http://localhost:4567/graphql and the method to get.

```graphql
{
  cars {
    make
    model
    engine {
      fuel
      capacity
    }
  }
}
```

## Advantages

- Client specifies what fields they want without creating multiple endpoints. Same API different fields returned by app consumer and desktop.
- Avoids client making multiple calls. e.g Getting an engine ID and then making another call to get the engine details
- Can see what fields are being requested by consumers, meaning fields can be safely removed
- Simple, standardized way of retrieving, updating and inserting data
- Self documenting API with the .graphsql file.
