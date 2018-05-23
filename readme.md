#selfish

##Create postgre image:
docker run --name selfish_db -e POSTGRES_PASSWORD=selfish_password -d -p 6001:5432 postgres