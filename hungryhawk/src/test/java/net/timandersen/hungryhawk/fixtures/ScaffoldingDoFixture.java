package net.timandersen.hungryhawk.fixtures;

import fit.Fixture;
import fitlibrary.DoFixture;

public class ScaffoldingDoFixture extends DoFixture {

  public Fixture lisa() {
    return new PersonaLisaFixture();
  }

  public Fixture vicki() {
    return new PersonaVickiFixture();
  }

  public Fixture hannah() {
    return new PersonaHannaFixture();
  }
}
