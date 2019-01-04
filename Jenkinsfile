def server = Artifactory.server 'Artifactory - 4.15.0'
def mavenBld = Artifactory.newMavenBuild()
def buildinfo = Artifactory.newBuildInfo()

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
	    
	  /*stage('JUnit Test') {
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
		     withSonarQubeEnv('Sonar') {
                sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.5.0.1254:sonar'
              }
	    }
	  }*/
	    
	  stage('Build') { 
            steps {
		    script {
			    sh 'mvn clean install -U'
		    }
	    }
	 }
	    
	 stage('Upload to Artifactory') {
		 steps {
			 script {
				 //mavenBld.resolver = null
				 mavenBld.resolver server: server, releaseRepo: 'Jenkins_Poc_releases', snapshotRepo: 'Jenkins_Poc_snapshots'
				 mavenBld.deployer releaseRepo: 'libs-release-local', snapshotRepo: 'libs-snapshot-local', server: server
				 //mavenBld.deployer.artifactDeploymentPatterns.addExclude("pom.xml")
				 mavenBld.tool = 'Maven'
				 buildinfo = mavenBld.run pom: 'pom.xml', goals: 'clean install', buildInfo: buildinfo
				 buildinfo.retention maxBuilds: 3, maxDays: 7, deleteBuildArtifacts: true
				 //buildInfo.env.capture = true
				 server.publishBuildInfo buildinfo
			 }
		 }
	 }
    }
}
