package rlp.pensionmanager.model.errors;

public class PensionNotFoundException extends RuntimeException {

  private Long id;

  public PensionNotFoundException(Long id) {
    super("Could not find item " + id);
  }
}
