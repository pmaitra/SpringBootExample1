pipeline{
  agent any
  tools {
        maven 'Maven'
        jdk 'JDK8'
  }
  stages{
    stage('SCM Checkout'){
      steps{
        git 'https://github.com/pmaitra/SpringBootExample1.git'
      }
    }
    stage('Compile Package'){
      steps{
        //def mavenhome = tool name: 'Maven', type: 'maven'
        //sh "${mavenhome}/bin/mvn clean package"
        sh 'mvn clean package'
        }
    }
    stage('Email Notification'){
      steps{
        mail bcc:'', body:'Email from Jenkins pipeline build and deploy', subject:'Jenkins Job', to: 'pradipta.maitra@gmail.com'
      }
     }
  }
  post {
    failure {
        mail to: 'pradipta.maitra@gmail.com',
             subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
             body: "Something is wrong with ${env.BUILD_URL}"
    }
  }
}
