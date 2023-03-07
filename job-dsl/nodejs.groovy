job("nodejs example") {
    scm {
        git("https://github.com/qkransrb/jenkins-app.git") { node ->
            node / gitConfigName("qkransrb")
            node / gitConfigEmail("qkransrb90@gmail.com")
        }
    }
    
    trigger {
        scm("H/S * * * *")
    }

    wrappers {
        nodejs("nodejs")
    }

    steps {
        shell("npm install")
    }
}