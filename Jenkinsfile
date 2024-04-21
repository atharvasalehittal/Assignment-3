pipeline {
   environment {
        registryCredential = 'dockercred'
        TIMESTAMP = new Date().format("yyyyMMdd_HHmmss")
    }
   agent any
   tools {
    maven 'Maven 3.9.6'
}

   stages {
    stage('Maven Clean') {
            steps {
               script{
                sh 'mvn clean'
               }
            }
        }
        stage('Maven Install') {
            steps {
               script{
                sh 'mvn install -DskipTests'
            }
            }
        }
      stage('Build Docker Image') {
         steps {
            script{
               docker.withRegistry('',registryCredential){
                  def customImage = docker.build("attusale21/studentsurvey:${env.TIMESTAMP}")
               }
            }
         }
      }

      stage('Push Image to Dockerhub') {
         steps {
            script{
               docker.withRegistry('',registryCredential){
                  sh "docker push attusale21/studentsurvey:${env.TIMESTAMP}"
               }
            }
         }
      }
      stage('Deploying to Rancher to single node(deployed in 3 replicas)') {
         steps {
            script{
               sh "kubectl set image deployment/springdeployment container-0=attusale21/studentsurvey:${env.TIMESTAMP} -n default"
            }
         }
      }
   }
}
