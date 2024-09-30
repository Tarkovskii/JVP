## Как это запустить с нуля

### Проверить/установить java

Выполняем:

```bash
java -version
javac -version
```

Должно выдать версию, если нет, то [идем ставить](https://www.oracle.com/java/technologies/downloads/)


### Проверить/установить maven

Выполняем:

```bash
mvn --version
```

Если не отдает версию, то [идем ставить](https://maven.apache.org/install.html)


### Сбилдить проект

Собираем проект:

```bash
mvn package
```

Убеждаемся, что есть файл `envs` с корректными переменными (шаблон в `envs_template`) и переменные импортированы.

Запускаем приложение:

```bash
java -cp target/{app_name.jar} {path_to_main_class}
```




## Детали реализации

Для сборки используется плагин `maven-assembly-plugin`.
Позволяет собирать проект в один большой jar, что позволяет не собирать нужные либы самому.



## Туториалы по инструментам

[maven](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)