pipeline {
    agent any

    triggers {
        pollSCM('* * * * *')
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out source code'
                checkout scm
            }
        }

        stage('Build and Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Package') {
            steps {
                bat 'mvn package'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying packaged application to local deploy folder'
                bat 'if not exist deploy mkdir deploy'
                bat 'copy /Y target\\automated-code-testing-pipeline-1.0-SNAPSHOT.jar deploy\\app.jar'
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
        success {
            echo 'Build, tests, packaging and deployment completed successfully!'
        }
        failure {
            echo 'Pipeline failed. Check the console output.'
        }
    }
}