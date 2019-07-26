docker logs -f -t --tail 1000  java-1
docker-compose stop $(docker ps -a -q)
docker stop $(docker ps -a -q)