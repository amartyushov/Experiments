## Allure gradle plugin expertise:

``` 
plugins {
       id "io.qameta.allure" version "2.5"
   }
   
   apply plugin: 'io.qameta.allure'
   
   allure { 
       autoconfigure = true
       version = '2.6.0'
   }
   
   configurations {
       agent
   }
   
   test {
       doFirst {
           jvmArgs "-javaagent:${configurations.agent.singleFile}"
       }
       useTestNG()
   }
```

## Generating allure data for allure binaries

First you need to execute tests itself to generate build/allure-results folder.  
For this you need gradle plugin     
```
gradle clean test
```


## Generating report using system wide binaries 
Now you need to take generated data and make a report:  
first install binaries system wide using packet manager
```
brew install allure
```

then using these binaries serve the generated files and make a report  
```
allure serve build/allure-report
```
    
## Generating report using local binaries 
gradle plugin has task `allureReport`, which is basically downloads (task `downloadAllure`) 
allure binaries to folder `.allure` (under the hood)    
```groovy
gradle allureReport
```
`allureReport` task generates all html/js/css to `build/reports/allure-report`  
Also there is a task `allureServe`, which generates html and starts webserver with this data 
(but it does not download allure binaries under the hood)  

```groovy
gradle allureServe
```

## Jenkins integration

Allure has jenkins plugin, which is responsible for report generation [LINK](https://github.com/jenkinsci/allure-plugin).  
In order to operate this plugin requires allure commandline (binaries), which should be installed into jenkins.
```
Global Tool Configuration -> Allure Commandline (e.g. using maven)
```

As an idea you can use html publisher jenkins plugin to expose generated allure report,  
plus do not forget about jenkins security about css and js. But native way with jenkins plugin 
seems to be more convenient.

It is required to install jenkins-wide allure binaries for jenkins allure plugin, it will not work with binaries 
from `.allure/` folder of job workspace

#### Attempt: workaround for allure jenkins plugin
In theory there is a workaround to not install jenkins wide allure binaries (but it did not work for me)  
Steps are:
1. gradle clean test
2. gradle allureReport
3. .allure/allure-2.4.1/bin/allure serve build/allure-results
4. html publisher for build/reports/allure-report/
This does not work => step 3 hangs

### Freestyle job
Allure plugin can be generated on `Post-build actions`, just specify path as `build/allure-results`
    
### Pipeline
Code snippet to use allure jenkins plugin  
Put a label `myLabel` to master or slave before.

```groovy
pipeline {
  agent {
    node {
      label 'myLabel'
      customWorkspace '/var/jenkins_home/local_files/allure'
    }
  }
  
  tools {
     gradle "gradle"
}

  stages {
    stage('Example Build') {
      steps {
        sh 'gradle clean test'
      }
      post {
        always {
            allure includeProperties: false, jdk: '', results: [[path: 'build/allure-results']]
        }
        }
    }
  }
}
```    
    