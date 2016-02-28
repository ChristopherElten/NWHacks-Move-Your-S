package controllers;

import play.*;
import play.mvc.*;
import play.db.jpa.*;
import views.html.*;
import models.Item;
import play.data.Form;
import java.util.List;

import static play.libs.Json.*;

public class Application extends Controller {

    public Result index() {
        return ok(index.render());
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
