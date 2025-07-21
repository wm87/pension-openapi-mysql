package rlp.pensionmanager.model.errors;

public class FamilyAllowanceNotFoundException extends RuntimeException {

  private Long id;

  public FamilyAllowanceNotFoundException(Long id) {
    super("Could not find dutyhour " + id);
  }
}
