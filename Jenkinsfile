// getGitChanges() => podría ser una funcion de groovy
//CODE_CHANGES = getGitChanges()

/* +++++ VARIABLES DE ENTORNO DE JENKINS +++++ */
//http://localhost:8080/env-vars.html/ 
def gv 

pipeline {
    agent any
    /*environment {
        NEW_VERSION = '1.3.0'
        SERVER_CREDENTIALS = credentials('server-credentials')
    }*/
    parameters {
        string(name: 'VERSION', defaultValue: '', description:'version to deploy on prod')
        choice(name: 'VERSION', choices: ['1.1.0','1.2.0','1.3.0'], description: '')
        booleanParam(name: 'executeTests', defaultValue: true, description: '')
    }
    stages {
        stage("init"){
            steps{
               script {
                   gv = load "script.groovy"
               }
            }
        }
        stage("testloco"){
            steps{
               echo "Estoy re loco"
            }
        }
        stage("build"){
            steps{
               script {
                   gv.buildApp()
               }
            }
        }
        stage("test"){
            when {
                expression {
                    //env.BRANCH_NAME == 'dev' || BRANCH_NAME == 'master'
                    //params.executeTests == true
                    params.executeTests
                }
            }
            steps{
                script {
                   gv.testApp()
                }
            }
        }
        stage("deploy"){
            steps{
                script {
                   gv.deployApp()
               }
            }
        }
    }
    /*post {
        always {
            // esto se va a ejecutar siempre si importar si se completan los pasos o no
        }
        success {
            // Solo si todo sale bien
        }
        failure {
            // Si falla se ejecuta este bloque
        }
    }*/
}
