package rlp.pensionmanager.model.errors;

import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "error")
public class ErrorResponse {
  public String getMessage() {
    return message;
  }

  public ErrorResponse(String message, List<String> details) {
    this.message = message;
    this.details = details;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public List<String> getDetails() {
    return details;
  }

  public void setDetails(List<String> details) {
    this.details = details;
  }

  private String message;
  private List<String> details;
}
