package net.timandersen.repository;

import net.timandersen.model.domain.Event;
import net.timandersen.util.SpringContextWrapper;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class EventDaoTest {

  @Test
  public void saveFindDelete() {
    int initialSize = dao().findAll().size();
    Event event = new Event();
    event.setDate(new Date());
    event.setName("Lasagna");

    //save
    dao().save(event);
    assertThat(dao().findAll().size(), is(initialSize + 1));

    //find
    boolean found = false;
    for (Event ev : dao().findAll()) {
      if (ev.getName().equals("Lasagna")) {
        found = true;
        //delete
        dao().delete(ev);
      }
    }

    assertThat(dao().findAll().size(), is(initialSize));
    assertTrue(found);
  }


  private EventDao dao() {
    return SpringContextWrapper.getBean(EventDao.class);
  }

}
