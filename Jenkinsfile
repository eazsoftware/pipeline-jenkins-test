#!groovy
pipeline {
    agent any
    tools {
        maven 'maven-3.5.0'
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }

        stage ('Build') {
            steps {
                sh 'mvn -Dmaven.test.failure.ignore=true install' 
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml' 
                }
            }
        }
        
        stage("Tagging Version"){
            when {
                // Branch is develop
                expression {
                    return env.BRANCH_NAME == 'develop'
                }
            }
            steps{
                echo 'Tagging Version'
                sh 'mvn release:clean release:prepare'
                script{
                    sh "git describe --tags \$(git rev-list --tags --max-count=1) > version.txt"
                    taggedVersion = readFile "version.txt"
                    echo "Tagged Version ${taggedVersion}"
                }
                echo "Pushing tag ${taggedVersion} to Master"
                sh "git checkout master"
                sh "git pull"
                sh "git merge --no-edit tags/${taggedVersion}"
                sh "git push"
            }
        }
        
    }
}
