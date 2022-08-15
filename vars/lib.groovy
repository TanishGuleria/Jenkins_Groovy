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
                    dir('terraform/'){
                        script{
                            sh 'echo "shared lib "'
                            sh '''
                                chmod +x ./tf.sh
                                ./tf.sh
                    
                            '''
                        }
                    }
                }
            }
        }
    }
}