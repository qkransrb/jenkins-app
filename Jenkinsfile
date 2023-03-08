node {
    def commit_id

    stage("Preparation") {
        checkout scm
        sh "git rev-parse --short HEAD > .git/commit-id"
        commit_id = readFile(".git/commit-id").trim()
    }

    stage("Test") {
        nodejs(nodeJSInstallationName: "nodejs") {
            sh "npm install --only-dev"
            sh "npm test"
        }
    }

    stage("Docker build / push") {
        docker.withRegistry("https://registry.hub.docker.com", "dockerhub") {
            def app = docker.build("qkransrb90/app:${commit_id}", ".").push()
        }
    }
}