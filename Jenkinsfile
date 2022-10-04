pipeline {
    agent none
    stages {
        stage('Build Jar') {
            steps {
                sh "mvn clean package -DskipTests"
                sh "mvn dependency:copy-dependencies"
            }
        }
        stage('Build Image') {
            steps {
                sh "docker build -t docker-selenium-project -f ./DockerFile ."
            }
        }
        stage('Push Image') {
            steps {
               withCredentials([usernameColonPassword(credentialsId: 'dockerHub', passwordVariable: 'pass', usernameVariable: 'user')]){
               		sh "docker login --username=${user} --password=${pass}"
               		sh "docker push radhika2022/docker-selenium-project:latest"
               }
            }
        }
    }
}
