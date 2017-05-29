package m101j.mongodb.week1;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gopis on 10/14/2015.
 */
public class HelloFreemarkerTemplate {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloFreemarkerTemplate.class,"/");
        try{
            Template helloTemplate = configuration.getTemplate("template.ftl");
            StringWriter sWriter = new StringWriter();
            Map<String,Object> helloMap = new HashMap<String,Object>();
            helloMap.put("name","Free Maper");
            helloTemplate.process(helloMap,sWriter);
            System.out.println(sWriter);


        }catch(Exception exe){
            exe.printStackTrace();
        }


    }
}
