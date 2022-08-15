def call(body)
{
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body()
    pipeline{
        agent any
        options{
            buildDiscarder(logRotator(numToKeepStr: '2'))
            timeout(time: 1, unit: 'HOURS')
            disableConcurrentBuilds()
        }
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