package evento;
import javax.enterprise.event.Observes;

public class EventiMultipliNotification {
    public void notify(@Observes Evento e) {
        System.out.println("INFO: Eventi multipli");
        System.out.println("DATI_EVENTO: ");
        Evento evento1 = new Evento(1, "Festa di Natale 2023", "Giggetto", "Quest’anno la festa di Natale si terrà da Giggetto, accorrete numerosi!", "25/12/2023", "14.00", 30.0f, "Jazz");
        System.out.println(evento1.toString());
        System.out.println("LISTA EVENTI CON STESSA STRUTTURA");
        System.out.println("DATI_EVENTO_1: ");
        System.out.println(evento1.toString());      
    }
    
}
