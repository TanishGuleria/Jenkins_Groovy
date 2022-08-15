def call(body)
{
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body()
    pipeline{
    agent any
    stages {
        stage ('build'){
            steps {
                sh 'echo "shared lib "'
                sh '''
                    echo "multi sahred lib"
                    
                '''
            }
        }
    }
}
}