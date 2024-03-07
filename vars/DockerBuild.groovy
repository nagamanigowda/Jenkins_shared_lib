def call(String project, String ImageTag, String hubUser){
    sh """
      docker image build -t ${hubUser}/${project} .
      Docker image tag ${hubUser}/${project}  ${hubUser}/${project}:${ImageTag}
      Docker image tag ${hubUser}/${project}  ${hubUser}/${project}:latest
      """
   
}



