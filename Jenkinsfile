pipeline 
{
    agent any
    
    tools{
    	maven 'maven'
        }
        
    environment{
   
        BUILD_NUMBER = "${BUILD_NUMBER}"
   
    }
    

    stages 
    {
        stage('Build') 
        {
            steps
            {
                 git 'https://github.com/jglick/simple-maven-project-with-tests.git'
                 bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }
            post 
            {
                success
                {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
        stage("Deploy to QA"){
            steps{
                echo("deploy to qa done")
            }
        }
          
          stage("GO Rest Regression API test"){
            steps{
                catchError(buildResult:'SUCCESS', stageResult:'FAILURE'){
                	git 'https://github.com/RupeshChandraSingh/GoRestRestAssured.git'
                	bat "mvn clean install =Dsurefire.suiteXmlFiles=src/test/resources/testRunners/goRestTestRunner.xml"
                }
            }
        }
    }
}