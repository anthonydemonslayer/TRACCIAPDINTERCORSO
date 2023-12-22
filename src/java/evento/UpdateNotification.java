package evento;

import javax.enterprise.event.Observes;

public class UpdateNotification {
    public void notify(@Observes Evento e) {
        System.out.println("Dati aggiornati : " + e);
    }
    
}
