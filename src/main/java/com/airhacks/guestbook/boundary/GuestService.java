
package com.airhacks.guestbook.boundary;

import com.airhacks.guestbook.entity.GuestEntry;
import com.airhacks.logging.boundary.Loggable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author airhacks.com
 */
@Stateless
@Loggable
public class GuestService {

    @PersistenceContext
    EntityManager em;

    public GuestEntry save(GuestEntry entry) {
        return this.em.merge(entry);

    }

    public List<GuestEntry> all() {
        return this.em.
                createNamedQuery(GuestEntry.findAll, GuestEntry.class).
                getResultList();
    }

    public GuestEntry find(long id) {
        return this.em.find(GuestEntry.class, id);
    }
}
