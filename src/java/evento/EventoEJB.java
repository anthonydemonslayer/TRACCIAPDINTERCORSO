package evento;

import javax.ejb.*;
import java.util.List;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.persistence.*;


@Stateless
@LocalBean
@WebService

public class EventoEJB implements EventoEJBRemote {
    
    @Inject
    private EntityManager em;

    @Override
    public void aggiungiEvento(Evento e) {
        em.persist(e);
    }

    @Override
    public Evento aggiornaEvento(Evento e) {
        return em.merge(e);
    }

    @Override
    public void rimuoviEvento(Evento e) {
        em.remove(em.merge(e));
    }

    @Override
    public Evento trovaPerId(int id) {
        TypedQuery<Evento> query = em.createNamedQuery(Evento.TROVA_PER_ID, Evento.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }

    @Override
    public List<Evento> trovaTutti() {
        TypedQuery<Evento> query = em.createNamedQuery(Evento.TROVA_TUTTI, Evento.class);
        return query.getResultList();
    }

    @Override
    public List<Evento> trovaPerData(String data) {
        TypedQuery<Evento> query = em.createNamedQuery(Evento.TROVA_PER_DATA, Evento.class);
        query.setParameter("data", data);
        return query.getResultList();
    }

    @Override
    public List<Evento> trovaPerCategoria(String categoria) {
        TypedQuery<Evento> query = em.createNamedQuery(Evento.TROVA_PER_CATEGORIA, Evento.class);
        query.setParameter("categoria", categoria);
        return query.getResultList();
    }

    @Override
    public List<Evento> trovaPerStruttura(String struttura) {
        TypedQuery<Evento> query = em.createNamedQuery(Evento.TROVA_PER_STRUTTURA, Evento.class);
        query.setParameter("struttura", struttura);
        return query.getResultList();
    }

    @Override
    public List<Evento> trovaPerStrutturaEData(String struttura, String data) {
        TypedQuery<Evento> query = em.createNamedQuery(Evento.TROVA_PER_STRUTTURA_E_DATA, Evento.class);
        query.setParameter("struttura", struttura);
        query.setParameter("data", data);
        return query.getResultList();
    }
}
