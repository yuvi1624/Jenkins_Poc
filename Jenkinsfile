def server = Artifactory.server 'Artifactory -  4.15.0'
def mavenBuild = Artifactory.newMavenBuild()
def buildInfo

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
	    
	  //stage('SonarQube Integration')  {
	  //   steps {
	//	     withSonarQubeEnv('Sonar') {
          //      sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.5.0.1254:sonar'
           //   }
	   //  }
	 // }
	    
	 stage('Uploading to Artifactory') {
		 steps {
			 scripts {
				 mavenBuild.deployer releaseRepo: 'libs-release-local', snapshotRepo: 'libs-snapshot-local', server: server
				 mavenBuild.resolver releaseRepo: 'Jenkins_Poc_releases', snapshotRepo: 'Jenkins_Poc_snapshots', server: server
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

