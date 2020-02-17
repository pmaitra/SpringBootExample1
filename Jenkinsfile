pipeline{
  agent any
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
        withMaven(
        // Maven installation declared in the Jenkins "Global Tool Configuration"
        Maven: 'maven'//,
        // Maven settings.xml file defined with the Jenkins Config File Provider Plugin
        // We recommend to define Maven settings.xml globally at the folder level using 
        // navigating to the folder configuration in the section "Pipeline Maven Configuration / Override global Maven configuration"
        // or globally to the entire master navigating to  "Manage Jenkins / Global Tools Configuration"
        //mavenSettingsConfig: 'my-maven-settings'
        ){ 
          sh 'mvn clean package'
        }
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
