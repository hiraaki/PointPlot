package controllers;
import models.*;
import com.fasterxml.jackson.databind.*;
import play.libs.Json;
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

            Esquina Ponto = Json.fromJson(json,Esquina.class);

            if(Ponto==null){
                return badRequest("Missing parameter [Rua1]");
            } else {
                //String Rua1 = ponto.getRua1().getNome();
                //String Rua2 = ponto.getRua2().getNome();
                //ObjectNode result= Json.newObject();
                //result.put();

                return ok(Json.toJson(Ponto));

            }
        }

    }

}
