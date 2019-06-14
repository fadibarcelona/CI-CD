pipeline {
    agent none
        stages {
        stage('checking out') {
            agent { label 'wcsv9' }
            steps { 
             echo "Checking out Code"
              
            }
        }
            stage('Compile Code') {
            agent { label 'master' }
                steps { 
             echo "Building Image in Utility Container"
                    sh 'chmod 777 geckodriver'
              
            }
            }
			
            stage('Running Test') {
            agent { label 'master' }
                steps { 
             
                    sh 'mvn install '
                    
            }
            }
			 post {
    always {
      sh 'curl --user admin:Rcyber!@#4 \
 --header "Content-Type:application/json" \
 --header "Accept: application/json" \
 --request POST \
 --data '{"short_description":"Incident Reported using Jenkins and Curl", "description":"This build has been processed using Jenkins Pipeline. You can find out rest of the details here: '$BUILD_URL' " }' \
  https://dev49841.service-now.com//api/now/table/incident'
    }
  }
		 
            
 }           
        
}
