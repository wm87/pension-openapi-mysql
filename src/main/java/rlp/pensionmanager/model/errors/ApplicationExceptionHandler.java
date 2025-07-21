package rlp.pensionmanager.model.errors;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {

  @ExceptionHandler(PensionNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String pensionNotFoundHandler(PensionNotFoundException ex) {
    return ex.getMessage();
  }

  @ExceptionHandler(DutyHourNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String dutyHourNotFoundHandler(DutyHourNotFoundException ex) {
    return ex.getMessage();
  }

  @ExceptionHandler(FamilyAllowanceNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String familayAllowanceNotFoundHandler(FamilyAllowanceNotFoundException ex) {
    return ex.getMessage();
  }

  @ExceptionHandler(OfficialCategoryNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String OfficialCategoryNotFoundHandler(OfficialCategoryNotFoundException ex) {
    return ex.getMessage();
  }

  @ExceptionHandler(OfficialTimeKeyNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String OfficialTimeKeyNotFoundHandler(OfficialTimeKeyNotFoundException ex) {
    return ex.getMessage();
  }

  @ExceptionHandler(RetirementReasonNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String RetirementReasonNotFoundHandler(RetirementReasonNotFoundException ex) {
    return ex.getMessage();
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
    List<String> details = new ArrayList<>();
    for (ObjectError error : ex.getBindingResult().getAllErrors()) {
      details.add(error.getDefaultMessage());
    }
    ErrorResponse error = new ErrorResponse("Validation Failed", details);
    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
  }
}
