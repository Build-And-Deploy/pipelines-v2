
def call() {

  pipeline {
    agent any

    stages {

      stage('Clean Workspace') {
        steps {
          deleteDir()
        }
      }

      stage('Checkout SCM') {
        steps {
          checkout scm
        }
      }
      
      stage('PWD') {
        steps {
          sh "pwd"
          }
        }

      // stage('Pull') {
      //   steps {
      //     sh 'docker pull $IMAGE'
      //   }
      // }

      // stage('Run') {
      //   steps {
      //     sh '''
      //       docker rm -f $CONTAINER_NAME || true
      //       docker run -d --name $CONTAINER_NAME -p $PORT:$PORT $IMAGE_NAME
      //       sleep 3
      //     '''
      //   }
      // }

      // stage('Test cURL') {
      //   steps {
      //     sh '''
      //     echo "Testing app http://localhost:$PORT"
      //     curl -f http://localhost:$PORT || exit 1
      //     '''
      //   }
      // }

      // stage('Last Clean') {
      //   steps {
      //     sh 'docker rm -f $CONTAINER || true'
      //   }
      // }
    }
  }
}
