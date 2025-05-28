
def call() {

  pipeline {
    agent any

    stages {

      stage('Test Print') {
        steps {
          echo "Running pipeline..."
        }

      }

    }


  }

}
