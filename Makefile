run_jenkins:
	docker run -d --name jenkins-wsb \
		-p 8080:8080 \
		-v $$(pwd)/jenkins:/var/jenkins_home:z \
		devops/jenkins

start_jenkins:
	docker start jenkins-wsb

bash_jenkins:
	docker exec -ti jenkins-wsb  /bin/bash

build_jenkins:
	docker build -t devops/jenkins -f Dockerfile .

show_me_password:
	cat jenkins/secrets/initialAdminPassword
