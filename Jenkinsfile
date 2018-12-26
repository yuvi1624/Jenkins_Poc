pipeline {
agent any        
    tools {
	jdk "Java-1.8"
	maven "Maven-3.5.4"
    }
    stages{
        stage('Source code Pull') {
            steps{
                    git url: 'https://github.com/yuvi1624/Jenkins_Poc'
               }
            }
          
         stage('Build') { 
            steps {
                sh 'mvn -B -DskipTests clean package'
                  }
              }
        }

   } 

