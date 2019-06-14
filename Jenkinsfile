pipeline {
    agent none
        stages {
        stage('checking out') {
            agent { label 'master' }
            steps { 
             echo "Checking out Code"
              
            }
        }
            stage('Compile Code') {
            agent { label 'master' }
                steps { 
             echo "Building Image in Utility Container"
                    sh 'chmod 777 /var/lib/jenkins/workspace/Service-Now/geckodriver'
              
            }
            }
			
            stage('Running Test') {
            agent { label 'master' }
                steps {
			timeout(45) {
             wrap([$class: 'Xvfb', additionalOptions: '', assignedLabels: '', autoDisplayName: true, debug: true, displayNameOffset: 0, installationName: 'XVFB', parallelBuild: true, screen: '1024x758x24', timeout: 25]) {
                    sh 'sudo su -c "chmod 777 /var/lib/jenkins/workspace/Service-Now/geckodriver && mvn install" '
                    
            }
		}
	    }
            }
	}
			 post {
    always {
	    node('master') {
      sh '''curl --user admin:Rcyber!@#4  --header "Content-Type:application/json"  --header "Accept: application/json"  --request POST  --data '{"short_description":"Incident Reported using Jenkins and Curl", "description":"This build has been processed using Jenkins. You can find out rest of the details here: '$BUILD_URL' " }' https://dev49841.service-now.com//api/now/table/incident'''
    }
  }
			 }	 
            
           
        
}
