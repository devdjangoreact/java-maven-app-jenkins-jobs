pipeline {
    agent {  }

    tools {
        maven 'maven-3.9.2'
    }


    stages {
        stage('1-Build jar') {
            steps {
                scrypt {
                    echo "Building......."
                    sh   "mvn packege"
                }
            }
        }
        stage('2-Build image') {
            steps {
                echo "Start of Stage Test"
                echo "Testing......."
                echo "End of Stage Build"
            }
        }
        stage('3-push') {
            steps {
                 scrypt {
                    echo "Building the docker image..."
                    withCredentials([usernamePassword(credentialsId: 'DockerHub Auth', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]){
                        sh 'echo $PASSWORD | docker login -u $USERNAME --password-stdin'
                        sh 'docker push devdjangoreact/jenkins-app:jva-2.0'
                    }
                }
            }
        }
   }
}