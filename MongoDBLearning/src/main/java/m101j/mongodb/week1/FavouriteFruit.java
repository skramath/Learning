package m101j.mongodb.week1;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gopis on 11/2/2015.
 */
public class FavouriteFruit {

    public static void main(String[] args) {
        System.out.println("Entered");
        Spark.get(new Route("/select_fruit") {

            public Object handle(Request request, Response response) {
                Configuration configuration = new Configuration();
                configuration.setClassForTemplateLoading(FavouriteFruit.class, "/");
                try {
                    Template helloTemplate = configuration.getTemplate("postRequestTemplate.ftl");
                    StringWriter sWriter = new StringWriter();
                    Map<String, Object> helloMap = new HashMap<String, Object>();
                    helloMap.put("fruits", Arrays.asList("Orange", "Mango", "Anar"));
                    helloTemplate.process(helloMap, sWriter);
                    return sWriter;
                } catch (Exception exe) {
                    exe.printStackTrace();
                }
                return "Invalid HTML";
            }
        });

        Spark.post(new Route("/favourite_fruit") {
            @Override
            public Object handle(Request request, Response response) {
                if(request.queryParams("fruit")!=null){
                    return "Your Favourite Fruit is "+request.queryParams("fruit");
                }
                return "Invalid Selection";
            }
        });
    }
}
