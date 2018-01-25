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
        withCredentials([usernamePassword(credentialsId: 'e383ee23-4270-40c5-ac9d-a4620e18e2cf', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
            sh "echo $PASSWORD"
            sh """
            export AWS_ACCESS_KEY_ID=$USERNAME
            export AWS_SECRET_ACCESS_KEY=$PASSWORD
            export ANSIBLE_HOSTS=/etc/ansible/ec2.py
            export EC2_INI_PATH=/etc/ansible/ec2.ini
            /etc/ansible/ec2.py --list
            ansible -u ec2-user tag_Name_mymicroec2 -m ping
            """
        }
    }
}
