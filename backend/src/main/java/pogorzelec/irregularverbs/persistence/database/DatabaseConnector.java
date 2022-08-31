package pogorzelec.irregularverbs.persistence.database;

import org.hibernate.Session;

public class DatabaseConnector {

    private static DatabaseConnector instance = null;
    private Session session;

    private DatabaseConnector() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public static DatabaseConnector getInstance() {
        if (DatabaseConnector.instance == null) {
            instance = new DatabaseConnector();
        }
        return instance;
    }

    public Session getSession() {
        return session;
    }

    public void teardown() {
        session.close();
        HibernateUtil.shutdown();
        instance = null;
    }
}
