package evento;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import static evento.Evento.*;

@Entity
@NamedQueries({
@NamedQuery(name = TROVA_TUTTI, query = "SELECT e FROM Evento e"),
@NamedQuery(name = TROVA_PER_ID, query = "SELECT e FROM Evento e WHERE e.id = :id"),
@NamedQuery(name = TROVA_PER_DATA, query = "SELECT e FROM Evento e WHERE e.data = :data"),
@NamedQuery(name = TROVA_PER_STRUTTURA, query = "SELECT e FROM Evento e WHERE e.struttura = :struttura"),
@NamedQuery(name = TROVA_PER_CATEGORIA, query = "SELECT e FROM Evento e WHERE e.categoria = :categoria"),
@NamedQuery(name = TROVA_PER_STRUTTURA_E_DATA, query = "SELECT e FROM Evento e WHERE (e.struttura = :struttura) AND (e.data = :data)")
})
        
@XmlRootElement
public class Evento implements Serializable {

    public static final String TROVA_TUTTI = "Evento.trovaTutti";
    public static final String TROVA_PER_ID = "Evento.trovaPerid";
    public static final String TROVA_PER_DATA = "Evento.trovaPerData";
    public static final String TROVA_PER_CATEGORIA = "Evento.trovaPerCategoria";
    public static final String TROVA_PER_STRUTTURA = "Evento.trovaPerStruttura";
    public static final String TROVA_PER_STRUTTURA_E_DATA = "Evento.trovaPerStrutturaEData"; //dichiarazione queries come stringhe
    
    
    @Id
    private int id;
    private String titolo;
    private String struttura;
    private String descrizione;
    private String data;
    private String orario;
    private float costo;
    private String categoria;

    public Evento() {
    }

    public Evento(int id, String titolo, String struttura, String descrizione, String data, String orario, float costo, String categoria) {
        this.id = id;
        this.titolo = titolo;
        this.struttura = struttura;
        this.descrizione = descrizione;
        this.data = data;
        this.orario = orario;
        this.costo = costo;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getStruttura() {
        return struttura;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getData() {
        return data;
    }

    public String getOrario() {
        return orario;
    }

    public float getCosto() {
        return costo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setStruttura(String struttura) {
        this.struttura = struttura;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setOrario(String orario) {
        this.orario = orario;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Evento{" + "id=" + id + ", titolo=" + titolo + ", struttura=" + struttura + ", descrizione=" + descrizione + ", data=" + data + ", orario=" + orario + ", costo=" + costo + ", categoria=" + categoria + '}';
    }
    
    //aggiunti getters, setters e toString
    
}
