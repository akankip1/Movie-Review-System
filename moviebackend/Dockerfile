FROM docker/whalesay:latest
LABEL Name=movieapi Version=0.0.1
RUN apt-get -y update && apt-get install -y fortunes
EXPOSE 3000
CMD ["sh", "-c", "/usr/games/fortune -a | cowsay"]
