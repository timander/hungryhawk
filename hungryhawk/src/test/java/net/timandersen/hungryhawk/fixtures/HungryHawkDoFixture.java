package net.timandersen.hungryhawk.fixtures;

import fit.Fixture;
import fitlibrary.DoFixture;
import net.timandersen.repository.EventDao;
import net.timandersen.repository.ReservationDao;
import net.timandersen.util.SpringContextWrapper;

public class HungryHawkDoFixture extends DoFixture {

  public HungryHawkDoFixture() {
    reservationRepository().deleteAll(reservationRepository().findAll());
    eventRepository().deleteAll(eventRepository().findAll());
  }

  public Fixture lisa() {
    return new PersonaLisaFixture();
  }

  public Fixture vicki() {
    return new PersonaVickiFixture();
  }

  public Fixture hannah() {
    return new PersonaHannaFixture();
  }

  private EventDao eventRepository() {
    return SpringContextWrapper.getBean(EventDao.class);
  }

  private ReservationDao reservationRepository() {
    return SpringContextWrapper.getBean(ReservationDao.class);
  }

}
