# demo-spring-native

✨Service : /get-all ✨

```sh
curl --location --request GET 'http://localhost:8080/get-all'
```

✨Service : /get ✨

```sh
curl --location --request POST 'http://localhost:8080/get' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id" : "1"
}'
```

✨Service : /create ✨

```sh
curl --location --request POST 'http://localhost:8080/create' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id" : "2",
    "name" : "User",
    "mobile" : "012345678",
    "email" : "user@hotmail.com"
}'
```

✨Service : /update ✨

```sh
curl --location --request POST 'http://localhost:8080/update' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id" : "1",
    "name" : "admin eiei",
    "mobile" : "-",
    "email" : "admin@hotmail.com"
}'
```

✨Service : /delete ✨

```sh
curl --location --request POST 'http://localhost:8080/delete' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id" : "1"  
}'
```
