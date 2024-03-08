// def call(String project, String ImageTag, String hubUser){
    
//     sh """
//      docker image build -t ${hubUser}/${project} . 
//      docker image tag ${hubUser}/${project} ${hubUser}/${project}:${ImageTag}
//      docker image tag ${hubUser}/${project} ${hubUser}/${project}:latest
     
//     """
//  }

def call(String aws_account_id, String region, String ecr_repo_name){
    
    sh """
     docker build -t ${ecr_repo_name} . 
     docker tag ${ecr_repo_name} :latest ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repo_name} :latest
     
     """
}


 
        


