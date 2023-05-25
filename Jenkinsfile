pipeline {
    agent any
    tools {
        maven 'maven-3.9.2'
    }

    stages {
        stage('1-Build jar') {
            steps {
                script {
                    echo "Building......."
                    sh   "mvn packege"
                }
            }
        }
        stage('2-Build image') {
            steps {
                 script {
                    echo "Building the docker image..."
                    withCredentials([usernamePassword(credentialsId: 'DockerHub Auth', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]){
                        sh 'docker build -t devdjangoreact/jenkins-app:jva-2.0 .'
                        sh 'echo $PASSWORD | docker login -u $USERNAME --password-stdin'
                        sh 'docker push devdjangoreact/jenkins-app:jva-2.0'
                    }
                }
            }
        }
        stage('3-push') {
            steps {
                 script {
                    'echo "Ok"'
                }
            }
        }
   }
}
