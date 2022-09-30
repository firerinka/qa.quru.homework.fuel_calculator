# Fuel calculator
## Requirements:
- docker

### Running PostgreSQL docker image:
```
docker pull postgres
docker run --name some-postgres -p 5432:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=qa_quru_fuel_calculator -d -v "$(pwd)"/src/main/resources:/docker-entrypoint-initdb.d qa_quru_fuel_calculator
```

### Running application
Before running application run PostgreSQL docker image first. Run application afterwards.

By defaule GUI interface is running.
For console interface use CLI argument:
```
-i console
```




