package models.objects.checker;

import com.mongodb.BasicDBObject;

import models.exception.JCertifDuplicateObjectException;
import models.exception.JCertifObjectNotFoundException;
import models.objects.access.SessionStatusDB;
import models.util.Constantes;

public class SessionStatusChecker extends ReferentielChecker {

    @Override
    public final void deleteCheck(BasicDBObject objectToCheck) {
        BasicDBObject dbObject = SessionStatusDB.getInstance().get(Constantes.LABEL_ATTRIBUTE_NAME, objectToCheck.getString(Constantes.LABEL_ATTRIBUTE_NAME));
        if (null == dbObject) {
            throw new JCertifObjectNotFoundException(this, "Session Status '" + objectToCheck.getString(Constantes.LABEL_ATTRIBUTE_NAME) + "' does not exist");
        }
    }

    @Override
    public final void addCheck(BasicDBObject objectToCheck) {
        BasicDBObject dbObject = SessionStatusDB.getInstance().get(Constantes.LABEL_ATTRIBUTE_NAME, objectToCheck.getString(Constantes.LABEL_ATTRIBUTE_NAME));
        if (null != dbObject) {
            throw new JCertifDuplicateObjectException(this, "Session Status '" + objectToCheck.getString(Constantes.LABEL_ATTRIBUTE_NAME) + "' already exists");
        }
    }
}
