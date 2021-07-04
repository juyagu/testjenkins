def buildApp() {
    echo 'Building the applicaciton...'
}

def testApp(){
    echo 'testing the application'
}

def deployApp(){
    echo 'deploying the application'
     echo "deploying version ${params.VERSION}"
}



return this