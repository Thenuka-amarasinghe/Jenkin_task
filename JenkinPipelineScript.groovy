pipeline {
    agent any
    
    environment {
        DIRECTORY_PATH = "D:\\Deakin\\SIT753\\Task_5_1"
        TESTING_ENVIRONMENT = "SIT753"
        PRODUCTION_ENVIRONMENT = "Thenuka"
    }
    
    stages {
        stage('Build') {
            steps {
                echo "Fetching source code from ${env.DIRECTORY_PATH}"
                echo "Compiling the code and generating any necessary artifacts"
            }
        }
        stage('Test') {
            steps {
                echo "Running unit tests"
                echo "Running integration tests"
            }
        }
        stage('Code Quality Check') {
            steps {
                echo "Checking the quality of the code"
            }
        }
        stage('Deploy') {
            steps {
                echo "Deploying the application to ${env.TESTING_ENVIRONMENT}"
            }
        }
        stage('Approval') {
            steps {
                script {
                    echo "Waiting for manual approval..."
                    sleep 10
                }
            }
        }
        stage('Deploy to Production') {
            steps {
                echo "Deploying the code to ${env.PRODUCTION_ENVIRONMENT}"
            }
        }
    }
    post{
        success{
            echo "Pipeline successfully executed"
        }
        failure{
            echo "Pipeline failed"
        }
    }
}
