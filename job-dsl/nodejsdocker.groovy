job("nodejs docker example") {
    scm("https://github.com/qkransrb/jenkins-app.git") { node ->
        node / gitConfigName("qkransrb")
        node / gitConfigEmail("qkransrb90@gmail.com")
    }

    triggers {
        scm("H/S * * * *")
    }

    wrappers {
        nodejs("nodejs")
    }

    steps {
        dockerBuildAndPush {
            repositoryName("qkransrb90/app")
            tag("${GIT_REVISION,length=9}")
            registryCredentials("dockerhub")
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}