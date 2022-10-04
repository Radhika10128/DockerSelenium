pipeline {
    agent any
    stages {
        stage('Build Jar') {
            steps {
                sh 'mvn clean package -DskipTests'
                sh 'mvn dependency:copy-dependencies'
            }
        }
        stage('Build Image') {
            steps {
                sh 'docker build -t radhika2022/docker-selenium-project -f ./DockerFile .'
            }
        }
        stage('Push Image') {
            steps {
               withCredentials([string(credentialsId: 'dockerHub', variable: 'dockerhubpwd')]) {
                   sh 'docker login -u radhika2022 -p ${dockerhubpwd}'

                }
                   sh 'docker push radhika2022/docker-selenium-project'
            }
        }
    }
}
