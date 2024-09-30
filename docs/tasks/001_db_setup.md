# Задача 1

Нужно поднять постгрю (PostgreSQL) в докере, подключиться к ней через DBeaver и выполнить `select 1`.

## Как поднять постгрю в докере

Образ с постгрей можно найти в инете гуля что-то вроде `posgres docker iamge` или что-то подобное на русском.
Скорее всего, при заупуске образа можно будет использовать переменные окружения, чтобы настроить дефлотного пользователя и базу данных.
Либо, в образ уже может быть зашиты дефолтные настройки и нужно просто внимательно прочитать.

В результате должно быть запущен контейнер с постгрей. (не забываем прокинуть порт, чтобы можно было достучаться до постгри с локальной машины)

## Как установить DBeaver

https://dbeaver.io/

## Как подключиться к постгре и выполнить запрос

1. Погуглить `как подлючиться к постгре через dbeaver`
2. Создать новый скрипт и выполнить `select 1`

В результате должна вернуться таблица с одной колонкой и одной строкой, в которой будет значение `1`