.PHONY: build run drun

drun:
	docker compose -f deploy/docker-compose.yaml up --build