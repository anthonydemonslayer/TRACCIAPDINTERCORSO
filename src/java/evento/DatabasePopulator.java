package evento;

import javax.ejb.*;
import javax.annotation.*;
import javax.annotation.sql.*;
import javax.inject.Inject;


@Singleton
@Startup
@DataSourceDefinition(
    className = "org.apache.derby.jdbc.EmbeddedDataSource", //completato il clasName con EmbeddedDataSource
    name = "java:global/jdbc/EsameDS",
    databaseName = "EsameDB",
    user = "Anthony", password = "DemonSlayer",
    properties = {"connectionAttributes=;create=true"}
) // aggiunti user, password e properties

public class DatabasePopulator {

    @Inject
    private EventoEJB ejb;
    private Evento e1;
    
    @PostConstruct
    private void PopulateDB() {
        e1 = new Evento(1, "Festa di Natale 2023", "Giggetto", "Quest’anno la festa di Natale si terrà da Giggetto, accorrete numerosi!", "25/12/2023", "14.00", 30.0f, "Jazz");
        
        ejb.aggiungiEvento(e1);
    }
    
    @PreDestroy
    private void clearDB() {
        ejb.rimuoviEvento(e1);
    }
    
}
