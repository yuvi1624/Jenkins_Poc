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
          
         stage('Build') { 
            steps {
                sh 'mvn clean install -U'
                  }
              }
        }

   } 

