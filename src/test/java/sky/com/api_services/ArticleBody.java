package sky.com.api_services;


import java.util.Arrays;

public class ArticleBody {

/*
{
        "id": "1",
        "createdAt": "2020-10-27T19:10:01.232Z",
        "title": "title 1",
        "sensitive": false,
        "topics": [
            "business",
            "politics",
            "technology"
        ],
        "image": null,
        "priority": 89
    }
 */
private String title;
    private Boolean isSensitive;
    private String[] topics;
    private String image;
    private Integer priority;


public ArticleBody(){

}


public ArticleBody (String title, Boolean isSensitive, String[] topics, String image, Integer priority){
    this.title=title;
    this.isSensitive= isSensitive;
    this.topics= topics;
    this.image=image;
    this.priority=priority;
}

public ArticleBody(String title,Boolean isSensitive){
    this.title= title;
    this.isSensitive= isSensitive;
}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getSensitive() {
        return isSensitive;
    }

    public void setSensitive(Boolean sensitive) {
        isSensitive = sensitive;
    }

    public String[] getTopics() {
        return topics;
    }

    public void setTopics(String[] topics) {
        this.topics = topics;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "ArticleBody{" +
                "title='" + title + '\'' +
                ", isSensitive=" + isSensitive +
                ", topics=" + Arrays.toString(topics) +
                ", image='" + image + '\'' +
                ", priority=" + priority +
                '}';
    }


}
