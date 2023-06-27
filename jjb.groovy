pipeline {
    agent { 
        node {label 'slave-2'} 
    }

    stages {
        stage('Prepare job definition') {
            steps {
                script {
                    cleanWs()

                    pipelineConfig = readYaml file: "${WORKSPACE}/params/${params.pipeline_parameter_file_path}"
                    // jenkinsJobTemplate = "${pipelineConfig.parameters.general.jenkinsJobTemplate}"

                    echo "${pipelineConfig.test}"
                }
            }
        }
    }
}
