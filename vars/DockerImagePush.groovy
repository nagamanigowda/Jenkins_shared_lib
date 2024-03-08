//  def call(String project, String ImageTag, String hubUser){
//      withCredentials([usernamePassword(
//         credentialsId: 'docker_credentials', 
//         passwordVariable: 'PASS', 
//         usernameVariable: 'USER')])
//          {

//           sh "docker login -u '$USER' -p '$PASS'"
//          }
//      sh "docker image push ${hubUser}/${project}:${ImageTag}"
//      sh "docker image push ${hubUser}/${project}:latest"   
//   }


def call(String aws_account_id, String region, String ecr_repo_name){
    
    sh """

     def awsPassword = sh(script: 'aws ecr get-login-password --region ${region}', returnStdout: true).trim()
     sh "echo '$awsPassword' | docker login --username AWS --password-stdin ${aws_account_id}.dkr.ecr.${region}.amazonaws.com"
     docker push ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repo_name}:latest

     """
}



    
