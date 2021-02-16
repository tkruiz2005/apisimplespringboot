# apisimplespringboot

Api simple con basic authenticacion

Administrador: admin/admin

Usuario: user/user


# build proyect
mvn install

# build images personajes
docker build -t personajes .

# run images personajes
docker run -it -p 8080:8080 personajes

# post 
localhost:8080/api/personajes

# Get all personajes
localhost:8080/api/personajes

# Swagger
http://localhost:8080/swagger-ui.html

