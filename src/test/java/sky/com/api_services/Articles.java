package sky.com.api_services;

import static io.restassured.RestAssured.*;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class Articles {


    Response response;
    String title;
    boolean isSensitive;


    public void getArticleList(String endPoint){
        response= given()
                .contentType(ContentType.JSON).log().all().
                        when()
                .get(endPoint).prettyPeek();

    }

    public void verifyArticles(int size, int statusCode){

        response.then()
                .assertThat()
                .statusCode(statusCode).
                and()
                .header("Date",notNullValue())
                .header("Content-Type",is("application/json")).
                and()
                .body("id",hasSize(size));

    }

    public void verifyInvalidEndPoint(int statusCode){

        response.then()
                .assertThat()
                .statusCode(statusCode).
                and()
                .header("Content-Length",is("11"));
    }

    public void schemaValidation(){

        response.then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("articleTwo.json"));
    }


    /*
    I can create an article body with 2 different way
        1- Creating constructor of ArticleBody class an put the values same as below
            ArticleBody artB = new ArticleBody("title name", true,new String[]{"topic 1","topic 2","topic 3"},".jpng",24);

        2- Creating an object of Article body class and set the values

     */



    public  ArticleBody body(){
        Faker faker = new Faker();
        Random random = new Random();


        ArticleBody body = new ArticleBody();

        title= faker.job().title();
        body.setTitle(title);
        body.setImage(".jpng");
        body.setPriority(faker.number().numberBetween(1,100));

        //this part is not required, I would create it in order to get a dynamic body for effective API test

        boolean[] choices={true,false};
        int index = random.nextInt(choices.length);
        isSensitive=choices[index];
         body.setSensitive(isSensitive);

        //I can set any size of String array
        body.setTopics(new String[]{"football",faker.esports().game(),faker.esports().event(),"table tennis"});

        return body;
    }


    public void createAnArticle(String endPoint){

        response = given()
                            .contentType(ContentType.JSON).body(body()).
                    when()
                            .post(endPoint).prettyPeek();
    }


    public void verifyCreatedArticleWithStatusCodeAndBody(int statusCode){

        response.
                then()
                    .assertThat()
                    .statusCode(statusCode).
                and()
                    .body("sensitive",is(isSensitive))
                    .body("title", is(title));


    }



    public void updateArticleTwo(String endPoint, int id){
        Map<String, Object> updateBody= new HashMap<>();

        title = new Faker().job().title();
        updateBody.put("title",title);

        boolean[] sensitive={true,false};
        isSensitive=sensitive[new Faker().number().numberBetween(0,2)];
        updateBody.put("sensitive", isSensitive);

        response = given()
                        .contentType(ContentType.JSON).body(updateBody).log().all().
                    when()
                        .put(endPoint+id);

    }

    public void verifyUpdatedBodyWithStatusCodeAndResponseBody(int statusCode){
        response.then()
                    .assertThat()
                    .statusCode(statusCode).
                    and()
                    .body("title",is(title))
                    .body("sensitive",is(isSensitive));
    }


    public void deleteExistingArticle(String endPoint, int id){

        response=given()
                    .contentType(ContentType.JSON).log().all().
                when()
                    .delete(endPoint+id).prettyPeek();



    }






}
