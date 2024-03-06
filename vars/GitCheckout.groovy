def call(Map stageParams){

    checkout([
        $class: 'GitSCM',
        banches : [[name : stagePrams.branch]],
        userRemoteConfigs : [[url : stageParams.url]]

    ])
}

