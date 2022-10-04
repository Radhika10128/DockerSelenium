pipeline {
    agent none
    stages {
        stage('Build Jar') {
            steps {
                bat "mvn clean package -DskipTests"
                bat "mvn dependency:copy-dependencies"
            }
        }
        stage('Build Image') {
            steps {
                bat "docker build -t docker-selenium-project -f ./DockerFile ."
            }
        }
        stage('Push Image') {
            steps {
               withCredentials([usernameColonPassword(credentialsId: 'dockerHub', passwordVariable: 'pass', usernameVariable: 'user')]){
               		bat "docker login --username=${user} --password=${pass}"
               		bat "docker push radhika2022/docker-selenium-project:latest"
               }
            }
        }
    }
}