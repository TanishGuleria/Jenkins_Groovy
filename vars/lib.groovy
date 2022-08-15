def call(body)
{
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body()
    pipeline{
    agent any
    stages {
        stage ('build'){
            steps {
                sh 'echo "hello world"'
                sh '''
                    echo "multi steps shell"
                    ls
                '''
            }
        }
    }
}
}