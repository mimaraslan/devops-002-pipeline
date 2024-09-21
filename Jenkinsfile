pipeline {
    agent any

    tools{
        jdk 'JDK17'
        maven 'Maven3'
    }

    stages {

        stage('Build Maven') {
            steps {
            checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/mimaraslan/devops-002-pipeline']])

            // sh 'mvn clean install'
              bat 'mvn clean install'
            }
        }


        stage('Docker Image') {
            steps {
            //  sh 'docker build  -t mimaraslan/my-application:latest  .'
               bat 'docker build  -t mimaraslan/my-application:latest  .'
            }
        }


        stage('Docker Image to DockerHub') {
            steps {
              script{
                    withCredentials([string(credentialsId: 'dockerhub', variable: 'dockerhub')]) {

                         //  sh 'echo docker login -u mimaraslan -p DOCKERHUB_TOKEN'
                         // bat 'echo docker login -u mimaraslan -p DOCKERHUB_TOKEN'

                         // sh 'echo docker login -u mimaraslan -p ${dockerhub}'
                           bat 'echo docker login -u mimaraslan -p ${dockerhub}'

                         // sh 'docker image push  mimaraslan/my-application:latest'
                           bat 'docker image push  mimaraslan/my-application:latest'
                    }
                }
            }
        }

        stage('Deploy to Kubernetes'){
            steps{
                kubernetesDeploy (configs: 'deployment-service.yml', kubeconfigId: 'kubernetes')
            }
        }


    }
}
