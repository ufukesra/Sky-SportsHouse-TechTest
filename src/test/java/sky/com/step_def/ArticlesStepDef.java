package sky.com.step_def;

import io.cucumber.java.en.*;
import sky.com.api_services.Articles;

public class ArticlesStepDef {

    Articles articles = new Articles();


    @Given("send a get request to {string} endpoint")
    public void send_a_get_request_to_endpoint(String endPoint) {
        articles.getArticleList(endPoint);
    }

    @Then("verify articles with size {int} and status code {int}")
    public void verify_articles_with_size_and_status_code(Integer size, Integer statusCode) {
        articles.verifyArticles(size,statusCode);
    }

    @Then("verify response with status code {int}")
    public void verify_response_with_status_code(Integer statusCode) {
        articles.verifyInvalidEndPoint(statusCode);


    }

    @Then("validate the article response body with schema validation")
    public void validate_the_article_response_body_with_schema_validation() {
        articles.schemaValidation();
    }

    @Given("attempt a post request to {string} with valid article body")
    public void attempt_a_post_request_to_with_valid_article_body(String endPoint) {

        articles.createAnArticle(endPoint);

    }

    @Then("verify response with status code {int} and body properties")
    public void verify_response_with_status_code_and_body_properties(Integer statusCode) {

        articles.verifyCreatedArticleWithStatusCodeAndBody(statusCode);
    }

    @Given("attempt a put request with updated body to {string} endpoint for article {int}")
    public void attempt_a_put_request_with_updated_body_to_endpoint_for_article(String endPoint, Integer id) {

        articles.updateArticleTwo(endPoint,id);
    }

    @Then("verify  response with status code {int} and response body")
    public void verify_response_with_status_code_and_response_body(Integer statusCode) {
        articles.verifyUpdatedBodyWithStatusCodeAndResponseBody(statusCode);
    }

    @Given("attempt a delete request {string} endpoint for article {int}")
    public void attempt_a_delete_request_endpoint_for_article(String endPoint, Integer id) {
        articles.deleteExistingArticle(endPoint,id);

    }

    }