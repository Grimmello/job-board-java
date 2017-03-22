import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    // home page
    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    // category page
    get("/category", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/category.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    // job page
    get("/job", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/job.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    // job-form page
    get("/job-form", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/job-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    // job-form submit
    post("/job-form", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String category = request.queryParams("category");
      String title = request.queryParams("title");
      String description = request.queryParams("description");
      String name = request.queryParams("name");
      String number = request.queryParams("number");

      Job job = new Job(title, description);
      model.put("job", job);
      model.put("template", "templates/job.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
