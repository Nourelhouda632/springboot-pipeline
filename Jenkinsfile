pipeline {
    agent any

    stages {
        stage('Cloner le projet') {
            steps {
                git url: 'https://github.com/Nourelhouda632/springboot-pipeline.git', branch: 'main'
            }
        }

        stage('Build Maven') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Analyse SonarQube') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh 'mvn sonar:sonar -Dsonar.projectKey=springboot-pipeline -Dsonar.host.url=http://localhost:9000'
                }
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t nourelhouda632/springboot-app .'
            }
        }

        stage('Docker Push') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
                    sh 'docker push nourelhouda632/springboot-app'
                }
            }
        }
    }
}
