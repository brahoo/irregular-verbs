package pogorzelec.irregularverbs.persistence.database;

import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import pogorzelec.irregularverbs.model.Verb;

import java.util.Collection;

@Component("verbDatabaseService")
public class VerbDatabaseService {

    private DatabaseConnector connector;

    public VerbDatabaseService() {
        this.connector = DatabaseConnector.getInstance();
    }

    public Collection<Verb> getAll() {
        return connector.getSession().createQuery("SELECT verb FROM Verb verb", Verb.class).getResultList();
    }

    public void add(Verb verb) {
        Transaction transaction = connector.getSession().beginTransaction();
        connector.getSession().save(verb);
        transaction.commit();
    }
}
