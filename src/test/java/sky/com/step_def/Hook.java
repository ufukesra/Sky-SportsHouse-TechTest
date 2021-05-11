package sky.com.step_def;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import sky.com.utilities.ConfigurationReader;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.reset;

public class Hook {

    @Before
    public void setup(Scenario scenario){
        System.out.println(scenario.getSourceTagNames());
        System.out.println(scenario.getName());
        System.out.println("BEFORE");

            baseURI= ConfigurationReader.get("base_URI");


    }

    @After
    public void teardown(Scenario scenario){

            reset();
        System.out.println("AFTER");
    }
}


