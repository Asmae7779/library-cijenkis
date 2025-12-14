pipeline {
    agent any

    stages {
        stage('Build & Test') {
            steps {
                sh 'mvn clean package'
            }
        }
    }

    post {
        success {
            emailext (
                    subject: "✅ SUCCESS : ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                    body: """
Le build Jenkins a réussi.

Projet : ${env.JOB_NAME}
Build  : ${env.BUILD_NUMBER}
Commit : ${env.GIT_COMMIT}
URL    : ${env.BUILD_URL}
""",
                    to: "TON_EMAIL@gmail.com"
            )
        }

        failure {
            emailext (
                    subject: "❌ FAILURE : ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                    body: """
Le build Jenkins a échoué.

Projet : ${env.JOB_NAME}
Build  : ${env.BUILD_NUMBER}
URL    : ${env.BUILD_URL}
""",
                    to: "asmaeelyakoubi73@gmail.com"
            )
        }
    }
}
