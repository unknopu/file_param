pipeline {
    agent { 
        node {label 'slave-2'} 
    }

    stages {
        stage('Prepare job definition') {
            steps {
                script {
                    sh 'echo "=============================="'
                    sh 'echo "${WORKSPACE}"'
                    sh 'ls -lth'
                    sh 'echo "$$==============================$$"'

                    pipelineConfig = readYaml file: "${WORKSPACE}/config.yaml"
                    // pipelineConfig = readYaml file: "${WORKSPACE}/params/${params.pipeline_parameter_file_path}"
                    // jenkinsJobTemplate = "${pipelineConfig.parameters.general.jenkinsJobTemplate}"
                    
                    sh 'echo "---==============================---"'
                    echo "configVal: " + pipelineConfig['test']
                    echo "configVal: " + pipelineConfig['general']['one']
                    sh 'echo "---==============================---"'
                    echo "configVal: " + pipelineConfig.test
                    echo "configVal: " + pipelineConfig.general.one
                    sh 'echo "---==============================---"'

                }
            }
            post {
                always { 
                    cleanWs()
                }
            }
        }
    }
}
