package models.objects.access;

import com.mongodb.BasicDBObject;
import models.objects.Login;
import models.objects.checker.LoginChecker;
import models.util.Constantes;

public final class LoginDB extends JCertifObjectDB<Login> {

	private static final LoginDB INSTANCE = new LoginDB();

	private LoginDB() {
		super(Constantes.COLLECTION_LOGIN,
				new LoginChecker());
	}

	public static LoginDB getInstance() {
		return INSTANCE;

	}

	public boolean add(Login login) {
		return add(login.toBasicDBObject());
	}

	public boolean remove(Login login) {
		return remove(login.toBasicDBObject(), "email");
	}

	public boolean save(Login login) {
		return save(login.toBasicDBObject(), "email");
	}

	public Login get(String email) {
		BasicDBObject dbObject = get("email", email);
		Login login = null;
		if (null != dbObject) {
			login = new Login(dbObject);
        }
		return login;
	}

}
