package m101j.mongodb.week1;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 * Created by gopis on 10/29/2015.
 */
public class SparkRoute {

    public static void main(String[] args) {
        Spark.get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                return "Hello World";
            }
        });

        Spark.get(new Route("/team") {
            @Override
            public Object handle(Request request, Response response) {
                return "India";
            }
        });

        Spark.get(new Route("/echo/:name"){
            @Override
            public Object handle(Request request, Response response) {
                System.out.print(request.params("name"));
                if("Captain".equals(request.params("name")) ) {
                    System.out.print("Test2");
                    return "Captain : Virat";
                }
                if("Opener".equals(request.params("name")) ) {
                    return "Opener : Rohit";
                }
                if("Keeper".equals(request.params("name")) ) {
                    return "Keeper :Dhoni";
                }
                return request.params("Invalid Request [Captain,Opener,Keeper]");
            }
        });

    }
}
