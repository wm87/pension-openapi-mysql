package rlp.pensionmanager.model.errors;

public class OfficialCategoryNotFoundException extends RuntimeException {

  private Long id;

  public OfficialCategoryNotFoundException(Long id) {
    super("Could not find dutyhour " + id);
  }
}
