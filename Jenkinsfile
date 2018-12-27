pipeline {
agent any        
    tools {
	jdk "jdk"
	maven "Maven"
    }
    stages{
        stage('Source code Pull') {
            steps{
                    git url: 'https://github.com/yuvi1624/Jenkins_Poc'
               }
            }
	    
	  stage('JUnit Test') {
	    steps {
		    sh 'mvn test'
	          }
		  post {
			  always {
				  junit 'target/surefire-reports/*.xml'
			  }
		  }
	  }
	    
	  stage('SonarQube Integration')  {
	     steps {
		     withSonarQubeEnv('Sonar-3.5.0.1254') {
                sh 'mvn clean package'
              }
	     }
	  }
		  
         stage('Build') { 
            steps {
                sh 'mvn clean install -U'
                  }
              }
        }

   } 

