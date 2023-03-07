job("nodejs docker example") {
    scm {
        git("https://github.com/qkransrb/jenkins-app.git") { node ->
            node / gitConfigName("qkransrb")
            node / gitConfigEmail("qkransrb90@gmail.com")
        }
    }

    triggers {
        scm("H/S * * * *")
    }

    wrappers {
        nodejs("nodejs")
    }

    steps {
        dockerBuildAndPublish {
            repositoryName("qkransrb90/app")
            tag("latest")
            registryCredentials("dockerhub")
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}