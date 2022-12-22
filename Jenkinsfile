pipeline{
    agent any
    stages{
        stage("checkout"){
            steps{
                bat "git clone https://github.com/shubh1sinha/multi-ticket-application.git"
            }
        }
        
        stage("Package-Application"){
            steps{
				sh " /home/azureuser/apache-maven-3.8.6/bin/mvn clean package"
                sh "pwd"
            }
        }
		
        stage("Dockerize User-Microservice"){
            steps{
			    dir('user-microservice') {
				    sh "cd"
                    sh "pwd"
                    sh "sudo docker build -t shubh1sinha/user-microservice:1.1 ."
                }
			    dir('multi-ticket-booking-application') {
				    sh "cd"
                    sh "pwd"
                }
            }
        }

        stage("Dockerize Bus-Microservice"){
            steps{
			    dir('user-bus-microservice') {
				    sh "cd"
                    sh "pwd"
                    sh "sudo docker build -t shubh1sinha/user-bus-microservice:1.1 ."
                }
			    dir('multi-ticket-booking-application') {
				    sh "cd"
                    sh "pwd"
                }
            }
        }
		
		stage("Dockerize Train-Microservice"){
            steps{
			    dir('user-train-microservice') {
				    sh "cd"
                    sh "pwd"
                    sh "sudo docker build -t shubh1sinha/user-train-microservice:1.1 ."
                }
			    dir('multi-ticket-booking-application') {
				    sh "cd"
                    sh "pwd"
                }
            }
        }
		
		stage("Dockerize Hotel-Microservice"){
            steps{
			    dir('user-hotels-microservice') {
				    sh "cd"
                    sh "pwd"
                    sh "sudo docker build -t shubh1sinha/user-hotels-microservice:1.1 ."
                }
			    dir('multi-ticket-booking-application') {
				    sh "cd"
                    sh "pwd"
                }
            }
        }
		stage("Dockerize Order-Microservice"){
            steps{
			    dir('user-order-api-gateway') {
				    sh "cd"
                    sh "pwd"
                    sh "sudo docker build -t shubh1sinha/user-order-api-gateway:1.1 ."
                }
			    dir('multi-ticket-booking-application') {
				    sh "cd"
                    sh "pwd"
                }
            }
        }

		stage("Dockerize Controller-Microservice"){
            steps{
			    dir('user-frontend-service') {
				    sh "cd"
                    sh "pwd"
                    sh "sudo docker build -t shubh1sinha/user-frontend-service:1.1 ."
                }
			    dir('multi-ticket-booking-application') {
				    sh "cd"
                    sh "pwd"
                }
            }
        }
		
		stage("Pushing Images"){
            steps{
                sh " sudo docker push shubh1sinha/user-microservice:1.1"
                sh " sudo docker push shubh1sinha/shubh1sinha/user-bus-microservice:1.1"
                sh " sudo docker push shubh1sinha/shubh1sinha/user-train-microservice:1.1"
                sh " sudo docker push shubh1sinha/user-hotels-microservice:1.1"
                sh " sudo docker push shubh1sinha/user-order-api-gateway:1.1"
                sh " sudo docker push shubh1sinha/user-frontend-service:1.1"
            }
        }

        stage("helm-chart"){
            steps{
                        sh 'pwd'
                        sh 'cp -R helm/* .'
						sh 'ls -ltr'
                        sh 'pwd'
                        sh '/usr/local/bin/helm upgrade --install eureka-app eureka'
						sh '/usr/local/bin/helm upgrade --install user-app user'
                        sh '/usr/local/bin/helm upgrade --install bus-app bus'
                        sh '/usr/local/bin/helm upgrade --install train-app train'
                        sh '/usr/local/bin/helm upgrade --install hotel-app hotel'
						sh '/usr/local/bin/helm upgrade --install order-app order'
						sh '/usr/local/bin/helm upgrade --install frontend-app frontend'
            }
        }
		
		stage("Kubernetes-check-pods"){
            steps{
				sh 'sudo docker image ls'
                sh 'helm list'
                sh 'kubectl get pods'
                sh 'kubectl get svc'
            }
        }
		
    }
 }