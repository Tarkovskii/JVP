.PHONY: build run drun

build:
	mvn package

run:
	java -cp target/app-jar-with-dependencies.jar tutorial.Main

drun: build
	docker compose -f deploy/docker-compose.yaml up --build