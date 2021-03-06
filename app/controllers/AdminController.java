package controllers;


import play.mvc.Result;
import models.util.properties.JCertifPropUtils;

import java.util.List;

public class AdminController extends AbstractController {

    public static Result check() {
        String admin = session("admin");
        if (admin == null && request().body().asJson() != null && request().body().asJson().get("key") != null) {
            String requestKey = request().body().asJson().get("key").asText();
            String serverKey = JCertifPropUtils.getInstance().getProperty("jcertifbackend.admin.key");
            if (serverKey.equals(requestKey)) {
                // Ajout dans un cookie signé du paramètre "admin" si la clé est OK
                session("admin", "admin");
            } else {
                return badRequest();
            }
        } else {
            return badRequest();
        }
        return ok("");
    }

    public static Result ping(String nameUrl) {
        return ok();
    }
}
