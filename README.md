Full Name : Ufuk Sahinduran

Project Title :  Sky-API(mockAPI-/articles) Technical Testing Framework.

Installation guide: This is a maven project. so It's assumed that the host running this code have Java and maven
installed and JAVA_HOME already set. Here is the guide for maven installation just in
link : https://maven.apache.org/install.html Project get all dependencies from maven repository.
So no additional installation needed. The tools are managed by adding dependencies' to pom.xml file which are
for this framework and test.

pom.xml file:
Below are the dependencies are being used for this project :
Cucumber Java:https://mvnrepository.com/artifact/io.cucumber/cucumber-java
Cucumber JUnit:https://mvnrepository.com/artifact/io.cucumber/cucumber-junit
RestAssured library:https://mvnrepository.com/artifact/io.rest-assured
Github Java Faker:https://mvnrepository.com/artifact/com.github.javafaker/javafaker
SchemaValidator:https://mvnrepository.com/artifact/io.rest-assured/json-schema-validator
Jackson library :https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind
Cucumber Reports plugins:https://plugins.jenkins.io/cucumber-reports/


                       API Testing:
api_services Package:
    Articles class:I have created methods and variables for articles endPoint.
    ArticleBody class: I have created a java object by using Encapsulation concept and then converted it to a json object
        by using Jackson library in order to create an Article body. it is calling as Serialization, and the class is also 
        calling as  POJO.

runner Package:
    CukesRunner class: This class is for running my test by using cucumber options which contains
        plugins(cucumber reports), features (feature file pathway), glue (step definitions pathway) tags and dryRun.


step_def Package:
    Hook class: this class is for running before and after methods for each and every scenario.
        I have added scenario names, base Url in before method and  reset() RestAssured in after method.

   ArticlesStepDef class:  This class contains object of Articles class in order to use instance methods variables from
        the class.It also contains instance methods as scenarios' test steps.

utilities Package:
    ConfigurationReader class: this class is for reading data from Config file.

resources: this directory is for storing feature file which contains test scenarios.
    feature directory:
     articles.feature file: Storing test scenarios, steps and the data for articles endpoint by using Gherkin syntax.

configuration.properties: This is the file that I stored base Url.

pom.xml:
    Below are the dependencies are being used for this project :
    Cucumber Java, Cucumber JUnit, RestAssured library, Faker, SchemaValidator,Jackson, Cucumber Reports plugins.

                        Notes
1- I have executed get scenarios successfully because the endpoint supports HTTP GET requests.
2- Creating a new article scenario is failed because of the endpoint doesn't support HTTP POST request
3- Updating an article scenario is failed because of the endpoint doesn't support HTTP PUT request.
4- Deleting an existing article scenario is failed because of endpoint doesn't support DELETE request.
I have executed scenarios all HTTP requests (GET, POST, PUT, DELETE).

This framework can execute "mvn clean verify" command in terminal then it runs and generate html and cucumber reports
at the end of the execution.
