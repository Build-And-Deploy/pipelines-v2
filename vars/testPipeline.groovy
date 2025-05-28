
def call() {

  pipeline {
    agent any

    environment {
      IMAGE = 'brendanddev/node-app'
      CONTAINER = 'node-app'
      PORT = '3001'
    }

    stages {

      stage('Clean Workspace') {
        steps {
          deleteDir()
        }
      }

      stage('Pull') {
        steps {
          sh 'docker pull $IMAGE'
        }
      }

      stage('Run') {
        steps {
          sh '''
            docker rm -f $CONTAINER_NAME || true
            docker run -d --name $CONTAINER_NAME -p $PORT:$PORT $IMAGE_NAME
            sleep 3
          '''
        }
      }

      stage('Test cURL') {
        steps {
          sh '''
          echo "Testing app http://localhost:$PORT"
          curl -f http://localhost:$PORT || exit 1
          '''
        }
      }

      stage('Last Clean') {
        steps {
          sh 'docker rm -f $CONTAINER || true'
        }
      }
    }
  }
}
