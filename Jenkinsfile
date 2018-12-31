def server = Artifactory.server('Artifactory - 4.15.0')
def mavenBld = Artifactory.newMavenBuild()
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
	    
	 stage('Artifactory Build') {
		 steps {
			 script {
				 mavenBld.tool = 'Maven'
				 mavenBld.resolver null
				 mavenBld.deployer releaseRepo: 'Jenkins_Poc_releases', snapshotRepo: 'Jenkins_Poc_snapshots', server: server
				// mavenBld.resolver releaseRepo: 'Jenkins_Poc_releases', snapshotRepo: 'Jenkins_Poc_snapshots', server: server
				 buildinfo = mavenBld.run pom: 'pom.xml', goals: 'clean install -s settings.xml -Dmaven.repo.local=.repository -Dmaven.test.failure.ignore=true -B -U -Prelease'
			 }
		 }
	 }
			
         stage('Build') { 
            steps {
		    script {
			    sh 'mvn clean install -U'
		    }
	    }
	 }
    }
}
