package models.objects.access;

import com.mongodb.BasicDBObject;
import models.exception.JCertifException;
import models.objects.Session;
import models.objects.checker.SessionChecker;
import models.util.Constantes;

import java.util.*;

public class SessionDB extends JCertifObjectDB<Session>{

	private static SessionDB instance;

	public SessionDB() {
		super(Constantes.JCERTIFBACKEND_COLLECTIONNAME_SESSION,
				new SessionChecker());
	}

	public static SessionDB getInstance() {
		if (instance == null) {
			instance = new SessionDB();
		}
		return instance;
	}

	public boolean add(Session session) throws JCertifException {
		return super.add(session.toBasicDBObject());
	}

	public boolean remove(Session session) throws JCertifException {
		return remove(session.toBasicDBObject(), "id");
	}

	public boolean save(Session session) throws JCertifException {
		return save(session.toBasicDBObject(), "id");
	}

	public Session get(String id) throws JCertifException {
		BasicDBObject dbObject = get("id", id);
		Session session = null;
		if (null != dbObject)
			session = new Session(dbObject);
		return session;
	}

	/**
	 * Liste de status sans doublons
	 * 
	 * @return
	 */
	public List<BasicDBObject> listStatus() {
		BasicDBObject columnToReturn = new BasicDBObject("status", 1).append(
				"_id", 0);
		List<BasicDBObject> tmpList = list(null, columnToReturn);
		List<BasicDBObject> retList = new ArrayList<BasicDBObject>();
		Map<String, BasicDBObject> tmpMap = new LinkedHashMap<String, BasicDBObject>();
		Iterator iterator = tmpList.iterator();
		BasicDBObject dbObject;
		for (; iterator.hasNext();) {
			dbObject = (BasicDBObject) iterator.next();
			if (tmpMap.get(dbObject.getString("status").trim().toLowerCase()) == null) {
				tmpMap.put(dbObject.getString("status").trim().toLowerCase(),
						dbObject);
				retList.add(dbObject);
			}
		}
		return retList;
	}
}