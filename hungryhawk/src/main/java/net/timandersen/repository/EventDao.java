package net.timandersen.repository;

import net.timandersen.model.domain.Event;

public class EventDao extends GenericDao<Event> {

  public Event findByName(String name) {
    return firstOrNull(getHibernateTemplate().find("from Event e where e.name = ?", name));
  }

}
