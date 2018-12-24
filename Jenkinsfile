pipeline {

 agent none
    stages {

    stage('Initialize')
    {
        def dockerHome = tool 'Docker'
        def mavenHome  = tool 'Maven'
        env.PATH = "${dockerHome}:${mavenHome}/bin:${env.PATH}"
    }

    stage('Checkout') 
    {
        checkout scm
    }

      stage('Build') 
           {
            sh 'uname -a'
            sh 'mvn -B -DskipTests clean package'  
	}
     }
}      
    