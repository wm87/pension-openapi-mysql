package rlp.pensionmanager.model.errors;

public class RetirementReasonNotFoundException extends RuntimeException {

  private Long id;

  public RetirementReasonNotFoundException(Long id) {
    super("Could not find retirement " + id);
  }
}
