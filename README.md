# graphql-example

Simple example using [GraphQL](http://graphql.org/) with cars and engines.

GraphQL just deals with the querying. The HTTP server is run using spark java: http://sparkjava.com/

GraphQL allows you to define a schema, describing types and the relationships between the types.
As well as that you define what queries and mutations can be executed, these are then bound to methods.
Types can just be mapped to POJOs and as long as getters and setters match the names of the fields within the
.graphql file, they are automatically mapped.

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

and a mutation. Updating an engine

```graphql
mutation {
  updateEngine(id: 1, capacity: 200000) {
    id
    capacity
  }
}
```

## What is good about it

- Client specifies what fields they want without creating multiple endpoints. Same API different fields returned by app consumer and desktop.
- Avoids client making multiple calls. e.g Getting an engine ID and then making another call to get the engine details
- Can see what fields are being requested by consumers, meaning fields can be safely removed. Suggestion is to not create new versions of an API and instead not making non breaking changes. e.g. Deprecating fields rather than removing until the field is no longer being requested anymore.
- Simple, standardized way of retrieving, updating and inserting data
- Self documenting API with the .graphsql file.
- Can introspect a server endpoint to identify available types, fields, queries and mutations. Also displays which fields are deprecated. Can see this in the documentation tab when using GraphQL IDE.
- Can easily create mocks of a GraphQL endpoint with tools like: https://github.com/APIs-guru/graphql-faker
