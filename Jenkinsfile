pipeline {
    agent {
        label 'liga_windows_agent'
    }

    parameters {
        booleanParam(name: 'USE_SELENOID', defaultValue: false, description: 'Use Selenoid for remote execution')
        string(name: 'SELENOID_URL', defaultValue: 'http://selenoid:4444/wd/hub', description: 'Selenoid hub URL')
        string(name: 'BROWSER_VERSION', defaultValue: 'latest', description: 'Browser version for Selenoid')
        booleanParam(name: 'ENABLE_VIDEO', defaultValue: true, description: 'Enable video recording in Selenoid')
    }

    environment {
        LOCAL_DRIVER_PATH = 'C:\\Users\\mkalugin\\Desktop\\Internship_project\\Liga_internship\\src\\main\\resources\\chromedriver.exe'
        ALLURE_RESULTS = 'target/allure-results'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Test') {
            steps {
                script {
                    def mvnCmd = "mvn test " +
                        "-Duse.selenoid=${params.USE_SELENOID} " +
                        "-Dselenoid.url=${params.SELENOID_URL} " +
                        "-Dbrowser.version=${params.BROWSER_VERSION} " +
                        "-Denable.video=${params.ENABLE_VIDEO}"

                    if (!params.USE_SELENOID) {
                        mvnCmd += " -Dwebdriver.chrome.driver=${LOCAL_DRIVER_PATH}"
                    }

                    bat(script: mvnCmd, returnStdout: true)
                }
            }
            post {
                always {
                    archiveArtifacts artifacts: 'target/**/*', allowEmptyArchive: true
                }
            }
        }

        stage('Allure Report') {
            when {
                expression { fileExists('target/allure-results') }
            }
            steps {
                allure includeProperties: false,
                    jdk: '',
                    results: [[path: 'target/allure-results']]
            }
        }
    }

    stage('Publish Video Links') {
        when {
            expression { params.USE_SELENOID }
        }
        steps {
            script {
                def log = bat(script: 'type target\\surefire-reports\\*.txt', returnStdout: true)
                def videoUrls = log.readLines().findAll { it.contains('VIDEO URL:') }

                if (!videoUrls.isEmpty()) {
                    writeFile file: 'video_links.html', text: """
                    <html><body>
                        <h2>Selenoid Video Recordings</h2>
                        <ul>
                            ${videoUrls.collect { url -> "<li><a href='${url.replace('VIDEO URL: ', '')}'>${url}</a></li>" }.join('\n')}
                        </ul>
                    </body></html>
                    """
                    archiveArtifacts artifacts: 'video_links.html'
                }
            }
        }
    }

    post {
        always {
            cleanWs()
        }
        failure {
            emailtext body: 'Сборка ${BUILD_URL} завершилась с ошибкой',
                subject: 'FAILED: Job ${JOB_NAME} - Build ${BUILD_NUMBER}',
                to: 'team@example.com'
        }
    }
}