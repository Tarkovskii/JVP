.PHONY: build run drun

build:
	mvn package -DskipTests

run:
	java -cp target/app-jar-with-dependencies.jar com.example.workJVP.WorkJvpApplication

drun:
	docker compose -f deploy/docker-compose.yaml up --build