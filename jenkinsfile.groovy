pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Build en cours'
            }
        }
    }

    post {
        success {
            emailext (
                subject: "BUILD SUCCESS : ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: "Le build a réussi.\n\nLien : ${env.BUILD_URL}",
                to: "asmaeelyakoubi73@gmail.com"
            )
        }

        failure {
            emailext (
                subject: "BUILD FAILED : ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: "Le build a échoué.\n\nLien : ${env.BUILD_URL}",
                to: "tonemail@gmail.com"
            )
        }
    }
}
