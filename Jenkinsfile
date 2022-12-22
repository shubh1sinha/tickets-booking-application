pipeline{
    agent any
    stages{
        stage("checkout"){
            steps{
                bat "git clone https://github.com/shubh1sinha/multi-ticket-booking-application.git"
            }
        }
        
         stage("package"){
            steps{
            bat "mvn clean package -DskipTests"
            }
        }
        
        stage("dockerize"){
            steps{
            bat "docker-compose up"
            }
        }
    }
 }