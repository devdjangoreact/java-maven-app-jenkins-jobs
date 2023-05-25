def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'DockerHub Auth', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]){
        sh 'docker build -t devdjangoreact/jenkins-app:master-2.0 .'
        sh 'echo $PASSWORD | docker login -u $USERNAME --password-stdin'
        sh 'docker push devdjangoreact/jenkins-app:master-2.0'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this
