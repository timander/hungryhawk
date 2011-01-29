package net.timandersen.hungryhawk.fixtures;

import fit.Fixture;
import fitlibrary.DoFixture;
import net.timandersen.repository.EventRepository;
import net.timandersen.repository.ReservationRepository;
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

  private EventRepository eventRepository() {
    return SpringContextWrapper.getBean(EventRepository.class);
  }

  private ReservationRepository reservationRepository() {
    return SpringContextWrapper.getBean(ReservationRepository.class);
  }

}
