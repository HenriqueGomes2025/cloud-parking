# -cloud-parking

## Run database
docker run --name parking-db -p 5432:5432 -e POSTGRES_DB=parking -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=123 -d postgres:10-alpine

## Stop database 
docker stop parking-db

## Start database
docker start parking-db


## Terminal
docker exec -it parking-db bash

psql -U admin -d parking


