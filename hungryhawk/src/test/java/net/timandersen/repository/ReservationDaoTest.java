package net.timandersen.repository;

import net.timandersen.model.domain.Reservation;
import net.timandersen.util.SpringContextWrapper;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ReservationDaoTest {

  @Test
  public void saveFindDelete() {


    Reservation reservation = new Reservation();
    reservation.setName("Jimbo");
    reservation.setGuests(5);
    reservation.setEvent(SpringContextWrapper.getBean(EventDao.class).findAll().get(0));
    int initialCount = dao().findAll().size();

    //save
    dao().save(reservation);
    assertThat(dao().findAll().size(), is(initialCount + 1));
    List<Reservation> reservations = dao().findAll();

    //find
    boolean found = false;
    for (Reservation res : reservations) {
      if (res.getName().equals("Jimbo") && res.getGuests().equals(5)) {
        found = true;
        //delete
        dao().delete(res);
      }
    }
    assertTrue(found);
    assertThat(dao().findAll().size(), is(initialCount));
  }

  private ReservationDao dao() {
    return SpringContextWrapper.getBean(ReservationDao.class);
  }
}
