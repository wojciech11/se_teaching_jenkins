/*
Umieść w swoim repozytorim teaching-jenkins:
 jenkins/tools/create_user.groovy
*/

/* 
# create a user 
docker exec -i -t jenkins-wsb /bin/bash

cd /var/jenkins_home

export ADMIN_USER=admin
export ADMIN_PASSWORD=$(cat ./secrets/initialAdminPassword)

export USER_NAME=monika
export USER_PASS=secret
export USER_DSC="Frontend inz"

java -jar ./war/WEB-INF/jenkins-cli.jar -s http://127.0.0.1:8080/ groovy \
  --username ADMIN_USER --password ADMIN_PASSWORD \
  tools/create_user.groovy \
    ${USER_NAME} \
    ${USER_NAME} \
    ${USER_DSC}
*/

import hudson.model.*
import hudson.security.*
import hudson.tasks.Mailer

def userId = args[0]
def password = args[1]
def email = args[2]
def instance = jenkins.model.Jenkins.instance
def existingUser = instance.securityRealm.allUsers.find {it.id == userId}

if (existingUser == null) {
    def user = instance.securityRealm.createAccount(userId, password)
    user.addProperty(new Mailer.UserProperty(email));

    def strategy = (GlobalMatrixAuthorizationStrategy) instance.getAuthorizationStrategy()
    strategy.add(Hudson.READ, userId)
    instance.setAuthorizationStrategy(strategy)
    instance.save()
} 