# apisimplespringboot

# Resume simple api

# build proyect
mvn install

# build images personajes
build -t personajes .

# run images personajes
docker run -it -p 8080:8080 personajes

# post 
localhost:8080/api/personajes

# Get all personajes
localhost:8080/api/personajes



