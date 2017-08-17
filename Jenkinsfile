node {
    stage("Determine Steps") {
        git 'https://github.com/maddinenisri/spring-camel-ftp.git'
    }
    stage("Build") {
        withEnv([
            "JAVA_HOME=${tool 'jdk1.8'}",
            "PATH+MAVEN=${tool 'maven-3.5.0'}/bin:${env.JAVA_HOME}/bin"
        ]) {
            sh "mvn clean package"
        }
    }
    stage("Promote Build") {
        
    }
    stage("Deploy to Dev") {
        
    }
}
