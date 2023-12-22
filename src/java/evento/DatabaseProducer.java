package evento;

import javax.persistence.*;
import javax.enterprise.inject.*;


public class DatabaseProducer {
    @Produces
    @PersistenceContext(unitName = "EsamePU")
    private EntityManager em; //aggiunta rispetto al codice scritto sulla piattaforma
}
