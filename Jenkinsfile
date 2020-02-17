node{
  stage('SCM Checkout'){
    git 'https://github.com/pmaitra/SpringBootExample1.git'
  }
  stage('Compile Package'){
    def mavenhome = tool name: 'Maven', type: 'maven'
    sh "${mavenhome}/bin/mvn clean package"
  }
}
