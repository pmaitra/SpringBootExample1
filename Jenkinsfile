node{
  stage('SCM Checkout'){
    git 'https://github.com/pmaitra/SpringBootExample1.git'
  }
  stage('Compile Package'){
    def mavenhome = tool name: 'Maven', type: 'maven'
    sh "${mavenhome}/bin/mvn clean package"
  }
  stage('Email Notification'){
    mail bcc:'', body:'Email from Jenkins pipeline build and deploy', subject:'Jenkins Job', to: 'pradipta.maitra@gmail.com'
  }
  post {
    failure {
        mail to: 'pradipta.maitra@gmail.com',
             subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
             body: "Something is wrong with ${env.BUILD_URL}"
    }
  }
}
