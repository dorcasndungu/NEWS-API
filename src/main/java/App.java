import com.google.gson.Gson;
import models.dao.departmentDaoImplementation;
import models.dao.newsDaoImplementation;
import models.dao.userDaoImplementation;
import models.pojos.Department;
import models.pojos.News;
import models.pojos.User;
import org.sql2o.Sql2o;

import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    public static void main(String[] args) {

        port(getHerokuAssignedPort());
        staticFileLocation("/public");


        String connectionString = "jdbc:postgresql://ec2-34-224-226-38.compute-1.amazonaws.com:5432/d6sdssjq0gjq1j";
        Sql2o sql2o = new Sql2o(connectionString, "sijmtrtbgxdpuf", "3cbdda7a3cd94ade587bbb7dca620e8af765790329303b5baede5ada677a951c");


        departmentDaoImplementation departmentDaoImplementation = new departmentDaoImplementation(sql2o);
        userDaoImplementation userDaoImplementation = new userDaoImplementation(sql2o);
        newsDaoImplementation newsDaoImplementation = new newsDaoImplementation(sql2o);
        Gson gson = new Gson();

        //Add new Departments
        post("/departments/new", (request, response) -> {
            Department department = gson.fromJson(request.body(), Department.class);
            departmentDaoImplementation.add(department);
            response.status(201);
            return gson.toJson(department);
        });

        //Get all Departments
        get("/departments", (request, response) -> {
            return gson.toJson(departmentDaoImplementation.getAllDeparts());
        });

        //Get departments by id;
        get("/departments/:id", (req, res) -> {
            int departId = Integer.parseInt(req.params("id"));
            return gson.toJson(departmentDaoImplementation.findById(departId));
        });


        //Create new USer
        post("/users/new", (request, response) -> {
            User user = gson.fromJson(request.body(), User.class);
            userDaoImplementation.add(user);
            response.status(201);
            return gson.toJson(user);
        });

        //Get all Users
        get("/users", (req, res) -> {
            return gson.toJson(userDaoImplementation.getAllUsers());
        });

        //Get USers by id;
        get("/users/:id", (req, res) -> {
            int userId = Integer.parseInt(req.params("id"));
            return gson.toJson(userDaoImplementation.findById(userId));
        });


        //Get USers by department;
        get("/users/departments/:departId", (req, res) -> {
            int departId = Integer.parseInt(req.params("departId"));
            return gson.toJson(userDaoImplementation.findUsersByDepart(departId));
        });


        //Create News
        post("/news/new", (request, response) -> {
            News news = gson.fromJson(request.body(), News.class);
            newsDaoImplementation.add(news);
            response.status(201);


            return gson.toJson(news);
        });

        //Get all news
        get("/news", (req, res) -> {
            return gson.toJson(newsDaoImplementation.getAllNews());
        });

        //Get News by id;
        get("/news/:id", (req, res) -> {
            int newsId = Integer.parseInt(req.params("id"));
            return gson.toJson(newsDaoImplementation.findById(newsId));
        });


        //Get News by department;
        get("/news/departments/:departId", (req, res) -> {
            int departId = Integer.parseInt(req.params("departId"));
            return gson.toJson(newsDaoImplementation.findNewsByDepart(departId));
        });


        //FILTERS
        after((req, res) ->{
            res.type("application/json");
        });




    }


}
