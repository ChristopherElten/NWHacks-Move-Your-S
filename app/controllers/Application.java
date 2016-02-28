package controllers;

import play.*;
import play.mvc.*;
import play.db.jpa.*;
import views.html.*;
import models.Item;
import play.data.Form;
import java.util.*;
import play.libs.Yaml;

import static play.libs.Json.*;

public class Application extends Controller {

    @Transactional
    public Result index() {
        Items[] items = ((List)Yaml.load("test-data.yml")).toArray();
        for(int i = 0; i < items.length; i++){
           JPA.em().persist(items[i]); 
        }
        // Yaml.load("test-data.yml");
        // JPA.em().persist(item);
        return ok("temp");
        // return ok(index.render());
    }

    @Transactional
    public Result addItem() {
        Item item = Form.form(Item.class).bindFromRequest().get();
        JPA.em().persist(item);
        return redirect(routes.Application.index());
    }

    @Transactional(readOnly = true)
    public Result getItems() {
        List<Item> items = (List<Item>) JPA.em().createQuery("select p from Item p").getResultList();
        return ok(toJson(items));
    }
}
