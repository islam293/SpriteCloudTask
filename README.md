# SpriteCloudTask

An automation project for the following environment:
* UI: <ins>http://www.uitestingplayground.com/</ins>
* API: <ins>https://petstore.swagger.io/</ins>

## Usage 

### **Local Run:**

* Prerequisites:  
-Java 8 or higher.  
-git.  

* Clone the repository. 
```bash
git clone https://github.com/islam293/SpriteCloudTask.git
 
cd SpriteCloudTask/
```

* Run the maven package file.  
```bash
mvn package -B --file pom.xml
```  

### **Run on GitHub:**  

* Go to Actions.  
* From the Workflows: Open "Java CI with Maven".    
* On the Workflows run: Click "Run workflow". 

### **Results:**  

* Results folder path is [here.] (https://github.com/islam293/SpriteCloudTask/blob/main/results/)  
* Local Result Report are found in "[$*Project Path*]\test-output"  
Note: If you have Allure Reports variable on your machine, you could generate allure report 
after running by the following command:  
```bash
allure generate
```   
* GitHub Results are found [here.] (https://islam293.github.io/SpriteCloudTask/)  
* Reports are shared with Callipo.pro [here.] (https://app.calliope.pro/profiles/4547/reports)  

## Explanations 

### **Calliopo.Pro:**  

* Improvement:  
-Calliope should have integration with more testing reports frameworks as Allure.

* •	Feature:  
-User Could select some specific reports to display, compare or delete.  
-Calliope supports more formats as html. 

### **Test Scenarios** 
Selection of which scenarios to automate was affected by 3 factors:    

* Severity:  
-The most critical scenarios that their failure will break the environment.

* Priority:  
-The Scenarios that would introduce bad experience for the user. 

* Usages:  
-The Scenarios that users will use the most. 

## What's Next  

* Coverage:  
-More test cases to be designed to increase test coverage.

* UI DDT:  
-Put more data specially for file and elements paths on external file to be easily changed without changing the code.

* API Pojo class:  
-Design the Api request using Pojo  classes to increase code readability and re-usability.