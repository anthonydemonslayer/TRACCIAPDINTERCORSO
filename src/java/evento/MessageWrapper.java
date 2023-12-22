package evento;
import java.io.Serializable;

public class MessageWrapper implements Serializable {
    private int id;
    private String struttura;
//attributi
    
    public MessageWrapper(int id, String struttura) {
        this.id = id;
        this.struttura = struttura;
    }
//costruttore
    
    public int getId() {
        return id;
    }

    public String getStruttura() {
        return struttura;
    } //aggiunti i getters
    
    
}
