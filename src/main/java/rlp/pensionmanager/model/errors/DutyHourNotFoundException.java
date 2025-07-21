package rlp.pensionmanager.model.errors;

public class DutyHourNotFoundException extends RuntimeException {

  private Long id;

  public DutyHourNotFoundException(Long id) {
    super("Could not find dutyhour " + id);
  }
}
