package evento;

import javax.ejb.*;
import javax.jms.*;
import java.util.logging.*;
import javax.inject.Inject;
import javax.enterprise.event.Event;

@MessageDriven(mappedName = "jms/javaee7/Topic") //aggiunto rispetto al codice già scritto sulla piattaforma

public class EventoMDB implements MessageListener { //aggiunta implements MessageListener
    
    @Inject
    private EventoEJB ejb;
    
    @Inject
    Event<Evento> event; //aggiunta rispetto al codice già scritto sulla piattaforma
    
    @Inject @EventiMultipli
    Event<Evento> specialEvent;
    
    @Override
    public void onMessage(Message msg) {
        try{
            MessageWrapper wrapper = msg.getBody(MessageWrapper.class);
            Integer id = wrapper.getId();
            String struttura = wrapper.getStruttura();
            
            Evento e = ejb.trovaPerId(id);
            e.setStruttura(struttura);
            if(e.getStruttura().equals(struttura))
              specialEvent.fire(e);
            else
                event.fire(e);
            e = ejb.aggiornaEvento(e);
        } catch (JMSException ex) {
            Logger.getLogger(EventoMDB.class.getName()).log(Level.SEVERE, null, ex);
            
        } //aggiunto metodo onMessage (che era erroneamente nel JMSClient) e corpo dell'exception   
    }
    
}
