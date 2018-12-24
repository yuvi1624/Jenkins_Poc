pipeline {
agent none        
    stages{

	//stage('Initialize')
	//		    {
        //def dockerHome = tool 'Docker'
        //def mavenHome  = tool 'Maven'
        //env.PATH = "${dockerHome}:${mavenHome}/bin:${env.PATH}"
        //}

        stage('Build') {
	agent {
          docker {
//	    label 'docker'
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
		}
	    }
            steps {
                sh 'mvn -B -DskipTests clean package'
                  }
    	    }
       }
    }  
