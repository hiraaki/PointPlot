package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public Result index() {
        return ok(index.render("Plot"));
    }
    public Result savePoint(){
        JsonNode json = request().body().asJson();
        if(json == null) {
            return badRequest("Expecting Json data");
        } else {
            String Rua1 = json.findPath("Rua1").textValue();
            if(Rua1 == null) {
                return badRequest("Missing parameter [Rua1]");
            } else {
                return ok("Hello " + Rua1);
            }
        }

    }

}
