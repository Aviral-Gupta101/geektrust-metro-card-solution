pipeline {
    agent {
        docker {
            image 'coremedia/maven:4.0.0'
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
//                 publishHTML (target: [
//                     reportDir: 'target/site',
//                     reportFiles: 'surefire-report.html',
//                     reportName: 'Surefire Test Report',
//                     icon: 'https://img.icons8.com/?size=100&id=123822&format=png&color=000000',
//                     keepAll: false,
//                 ])

                publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'target/site', reportFiles: 'surefire-report.html', reportName: 'Surefire Test Report', reportTitles: '', useWrapperFileDirectly: true])
            }
        }
    }
}
