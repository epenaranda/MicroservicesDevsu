# MicroservicesDevsu

## Introduction

This is a basic JAVA companion app (*CLI*) for Software Development 3, allowing the  **CRUD** of users.

## Requirements

This app works with **MySLQ**. For simplicity, we recommend using **Docker**:

Pull Image:
```shell
docker pull mysql:latest
```

Run Container:
```shell
docker run -d --name my_sql_container -e MYSQL_ROOT_PASSWORD=docker -p 3307:3306 mysql
```
