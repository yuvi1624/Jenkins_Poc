pipeline {
agent any        
    stages{
        stage('Source code Pull') {
            steps{
                    git url "https://github.com/yuvi1624/Jenkins_Poc"
               }
            }
          
         stage('Build') { 
            steps {
                sh 'mvn -B -DskipTests clean package'
                  }
              }
        }
    }  
