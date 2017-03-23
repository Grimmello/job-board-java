import java.util.Map;
import java.util.HashMap;
import java.util.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";
    Category programming = new Category("Programming");
    Category automotive = new Category("Automotive");
    Category programming = new Category("Retail");
    Category programming = new Category("Office");

    // home page
    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      // jobs and our categories

      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    // category page
    get("/category/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Category category = Category.find(Integer.parseInt(request.params(":id")));
      model.put("category", category);
      model.put("template", "templates/category.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    // job page
    get("/category/:id/job/:jobid", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Category category = Category.find(Integer.parseInt(request.params(":id")));
      Job job = Job.find(request.params(":jobid"));
      model.put("category", category);
      model.put("job", job);
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
      Category category = Category.find(Integer.parseInt(request.queryParams("categoryId")));
      String title = request.queryParams("title");
      int categoryID = Integer.parseInt(request.queryParams("category"));
      String description = request.queryParams("description");
      String name = request.queryParams("name");
      String number = request.queryParams("number");
      String email = request.queryParams("email");
      List<String> contacts = new ArrayList<String>();
      contacts.addAll(Arrays.asList(name, number, email));

      Job job = new Job(title, category, description, contacts);
      if(categoryID == 1) {
        programming.mJobs.addJob(job);
      } else if (categoryID == 2) {
        automotive.addJob(job);
      } else if (categoryID == 3) {
        retail.addJob(job);
      } else if (categoryID == 4) {
        office.addJob(job);
      }
      category.mJobs.addJob(job);
      model.put("category", category);
      model.put("template", "templates/job.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
