FROM jenkins/jenkins:lts

USER root

RUN apt-get update;
RUN apt-get install make -qq && \
    apt-get install python-pip -qq

#USER jenkins