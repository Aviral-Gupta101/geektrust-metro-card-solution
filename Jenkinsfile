pipeline {
    agent {
        docker {
            image 'coremedia/maven:4.0.0'
//             args '-v $WORKSPACE:/workspace'  // Mount workspace
            reuseNode true
        }
    }
    stages {
        stage('Build & Test') {
            steps {
                sh 'mvn clean test surefire-report:report-only'
            }
        }
        stage('Publish Report') {
            steps {
                publishHTML (target: [
                    reportDir: 'target/site',
                    reportFiles: 'surefire-report.html',
                    reportName: 'Test Report',
                    keepAll: true
                ])
            }
        }
    }
}
