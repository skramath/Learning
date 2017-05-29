package m101j.mongodb.week1;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gopis on 10/14/2015.
 */
public class FreemarkerSpark {

    public static void main(String[] args) {
        Spark.get(new Route("/hello") {
            @Override
            public Object handle(Request request, Response response) {
                StringWriter sWriter = new StringWriter();
                Configuration configuration = new Configuration();
                configuration.setClassForTemplateLoading(HelloFreemarkerTemplate.class, "/");
                try {
                    Template helloTemplate = configuration.getTemplate("template.ftl");
                    Map<String, Object> helloMap = new HashMap<String, Object>();
                    helloMap.put("name", "Free Maper");
                    helloTemplate.process(helloMap, sWriter);
                    System.out.println(sWriter);
                    return sWriter;

                } catch (Exception exe) {
                    exe.printStackTrace();
                }
                return sWriter;
            }
        });


    }
}