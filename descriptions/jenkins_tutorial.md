## Jenkins

[Инструкция по установке в Docker](https://www.jenkins.io/doc/book/installing/docker/)

1) Скачать `Docker Desktop`
2) В терминале внести комманду: (Создать сеть с именем `jenkins`)
```bash
   docker network create jenkins
```
3) Запустить `docker:dind` Docker image

```bash
    docker run --name jenkins-docker --rm --detach ^
      --privileged --network jenkins --network-alias docker ^
      --env DOCKER_TLS_CERTDIR=/certs ^
      --volume jenkins-docker-certs:/certs/client ^
      --volume jenkins-data:/var/jenkins_home ^
      --publish 2376:2376 ^
      docker:dind
```
4) Создать `Dockerfile` :

```bash
FROM jenkins/jenkins:2.492.2-jdk17
USER root
RUN apt-get update && apt-get install -y lsb-release
RUN curl -fsSLo /usr/share/keyrings/docker-archive-keyring.asc \
  https://download.docker.com/linux/debian/gpg
  # Chrome instalation 
RUN curl -LO  https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
RUN apt-get install -y ./google-chrome-stable_current_amd64.deb  
RUN rm google-chrome-stable_current_amd64.deb
# Check chrome version
RUN echo "Chrome: " && google-chrome --version

RUN echo "deb [arch=$(dpkg --print-architecture) \
  signed-by=/usr/share/keyrings/docker-archive-keyring.asc] \
  https://download.docker.com/linux/debian \
  $(lsb_release -cs) stable" > /etc/apt/sources.list.d/docker.list
RUN apt-get update && apt-get install -y docker-ce-cli
USER jenkins
RUN jenkins-plugin-cli --plugins "blueocean docker-workflow"
```

5) Собрать образ : (Находиться в папке с `Dockerfile`)

```bash
   docker build -t myjenkins-blueocean:2.492.2-1 .
```

6) Запустить собранный образ :

```bash
docker run --name jenkins-blueocean --restart=on-failure --detach ^
  --network jenkins --env DOCKER_HOST=tcp://docker:2376 ^
  --env DOCKER_CERT_PATH=/certs/client --env DOCKER_TLS_VERIFY=1 ^
  --volume jenkins-data:/var/jenkins_home ^
  --volume jenkins-docker-certs:/certs/client:ro ^
  --publish 8080:8080 --publish 50000:50000 myjenkins-blueocean:2.492.2-1
```

7) Следовать инструкциям в `Setup wizard`

8) Установить необходимые плагины :
```plaintext
Allure Jenkins plugin
Pipeline plugin
Pipeline Graph View Plugin
Pipeline: Stage View Plugin
Copy Artifact plugin
Dark Theme
Docker pipeline
Labeled Pipeline Steps plugin
```

9) Настроить внутри `Jenkins` - `Gradle 8.1` для проекта.
   В `Manage` -> `Configure Jenkins` -> `Tools` -> `Gradle`

10) Настроить локального агента `Jenkins` для `Windows` :

- Перейти в `Manage Jenkins` > `Nodes`.
- Нажать `New Node`.
- Указать имя узла (например, `windows-agent`).
- Выбрать `Permanent Agent`.
- Скачать `JAR`-файл агента.

```bash
curl.exe -sO http://localhost:8080/jnlpJars/agent.jar
```

- Открыть командную строку.
- Перейти в директорию, где находится `JAR`-файл.
- Запустить агент:
```bash
  java -jar agent.jar -url http://localhost:8080/ -secret <ВАШ_SECRET_KEY> -name "SKIP_test" -workDir "C:\Jenkins"
 ```

- Убедится, что агент подключен.

Чтобы использовать `Windows-агент` в  `Jenkinsfile`, нужно указать его его в секции `agent`:
(`Pipeline` для примера)

```groovy
pipeline {
   parameters {
      booleanParam(name: 'USE_SELENOID', defaultValue: false)
      string(name: 'SELENOID_URL', defaultValue: 'http://selenoid:4444/wd/hub')
   }
   stages {
      stage('Test') {
         steps {
            script {
               bat "mvn test -Duse.selenoid=${params.USE_SELENOID} -Dselenoid.url=${params.SELENOID_URL}"
            }
         }
      }
   }
}
```

11) Запуск `Pipeline`

- Перейти в `New Item`.
- Выберать `Pipeline`.
- Указать имя (например, `gradle-project`).
- В разделе `Pipeline` выбрать `Pipeline script` и вставить `pipeline`, указанный выше.
- Нажать `Build Now`.
- Убедится, что сборка и тесты выполняются на Windows-агенте.

12) Генерация `SSH keys` :
TODO

# Jenkins data:
- Username - Maxim
- Pass - maxmax1823