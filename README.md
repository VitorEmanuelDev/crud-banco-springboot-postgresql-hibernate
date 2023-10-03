# API_REST_Spring_Boot
API REST para cadastro de novos clientes

<div>
<a href="https://vitoremanueldev.medium.com/api-rest-com-spring-boot-2-spring-framework-hibernate-jpa-maven-e-postgresql-b81b5c7952a7" target="_blank">
	<img src="https://img.shields.io/badge/medium-black?&style=flat-square&logo=medium&logoColor=white" alt="medium">
</a>
</div>

commands with docker:

Setting up your database

step 1: docker-compose down

step 2: docker-compose build

step 3: docker-compose up -d --force-recreate 

Veryfing database in container:

step 1: docker exec -it 'image id' psql 'user name' 'database name'

step 2: \dt

step 3: select * from 'database name';

Build and run spring boot app

step 1: docker build -t crud-banco-springboot-postgresql-hibernate:latest .  

step 2: docker run -p 8080:8080 --network=host crud-banco-springboot-postgresql-hibernate

Verify app logs:

docker logs springboot-postgresql

Verify network

docker network inspect 'my network'


