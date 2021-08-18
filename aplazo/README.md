$ docker build -t aplazo:lates .

$ docker-compose up —build

Service /health
$ curl --location --request GET 'localhost:8081/health'

Service calculate payments
$ curl --location --request POST 'localhost:8081/generatePayment' --header 'Content-Type: application/json' --data-raw '{
    "amount":100,
    "terms":5,
    "rate":10
}'

Service return all credits
$ curl --location --request GET 'localhost:8081/credits’
