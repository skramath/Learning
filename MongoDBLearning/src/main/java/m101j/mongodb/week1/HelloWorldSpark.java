package m101j.mongodb.week1;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 * Created by gopis on 10/14/2015.
 */
public class HelloWorldSpark {

    public static void main(String[] args) {
        Spark.get(new Route("/hello") {
            @Override
            public Object handle(Request request, Response response) {

                get("/", (q, a) -> IOUtils.toString(Spark.class.getResourceAsStream("/path/to/index.html")));
                return "Hello World From Sparkie";

            }
        });
    }
    private String renderContent(String htmlFile) {
        new String(Files.readAllBytes(Paths.get(getClass().getResource(htmlFile).toURI())), StandardCharsets.UTF_8);
    }
}
