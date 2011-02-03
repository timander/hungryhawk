package net.timandersen.repository;

import net.timandersen.model.domain.Event;

import java.util.Date;

public class EventDao extends GenericDao<Event> {

  public Event findByName(String name) {
    return firstOrNull(getHibernateTemplate().find("from Event e where e.name = ?", name));
  }

  public Event findByDate(Date date) {
    return firstOrNull(getHibernateTemplate().find("from Event e where e.date = ?", date));
  }

  @Override
  public void save(Event entity) {
    System.out.println("EventDao.save");
    super.save(entity);
  }
}
