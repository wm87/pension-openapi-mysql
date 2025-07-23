package rlp.pensionmanager.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import rlp.pensionmanager.model.Pension;
import rlp.pensionmanager.model.dto.PensionDto;
import rlp.pensionmanager.service.PensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@SecurityRequirement(name = "javainuseapi")
@RequestMapping("/api/pensions")
public class PensionController {

    private final PensionService pensionService;

    @Autowired
    public PensionController(PensionService pensionService) {
        this.pensionService = pensionService;
    }

    @PostMapping
    public ResponseEntity<PensionDto> addPension(@RequestBody final PensionDto pensionDto) {
        Pension pension = pensionService.addPension(Pension.from(pensionDto));
        return new ResponseEntity<>(PensionDto.from(pension), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PensionDto>> getPensions() {
        List<Pension> pensions = pensionService.getPensions();
        List<PensionDto> pensionsDto = pensions.stream().map(PensionDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(pensionsDto, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<PensionDto> getPension(@PathVariable final long id) {
        Pension pension = pensionService.getPension(id);
        return new ResponseEntity<>(PensionDto.from(pension), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<PensionDto> deletePension(@PathVariable final long id) {
        Pension pension = pensionService.deletePension(id);
        return new ResponseEntity<>(PensionDto.from(pension), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<PensionDto> editPension(@PathVariable final long id,
                                                  @RequestBody final PensionDto pensionDto) {
        Pension pension = pensionService.editPension(id, Pension.from(pensionDto));
        return new ResponseEntity<>(PensionDto.from(pension), HttpStatus.OK);
    }

    @PostMapping(value = "{pensionId}/dutyhours/{dutyhourId}/add")
    public ResponseEntity<PensionDto> addDutyHourToPension(@PathVariable final long pensionId,
                                                           @PathVariable final long dutyhourId) {
        Pension pension = pensionService.addDutyHourToPension(pensionId, dutyhourId);
        return new ResponseEntity<>(PensionDto.from(pension), HttpStatus.OK);
    }

    @DeleteMapping(value = "{pensionId}/dutyhours/{dutyhourId}/remove")
    public ResponseEntity<PensionDto> removeDutyHourFromPension(@PathVariable final long pensionId,
                                                                @PathVariable final long dutyhourId) {
        Pension pension = pensionService.removeDutyHourFromPension(pensionId, dutyhourId);
        return new ResponseEntity<>(PensionDto.from(pension), HttpStatus.OK);
    }

    @PostMapping(value = "{pensionId}/familyallowance/{familyallowanceId}/add")
    public ResponseEntity<PensionDto> addFamilyAllowanceToPension(@PathVariable final long pensionId,
                                                                  @PathVariable final long familyallowanceId) {
        Pension pension = pensionService.addFamilyAllowanceToPension(pensionId, familyallowanceId);
        return new ResponseEntity<>(PensionDto.from(pension), HttpStatus.OK);
    }

    @DeleteMapping(value = "{pensionId}/familyallowance/remove")
    public ResponseEntity<PensionDto> removeFamilyAllowanceFromPension(@PathVariable final long pensionId) {
        Pension pension = pensionService.removeFamilyAllowanceFromPension(pensionId);
        return new ResponseEntity<>(PensionDto.from(pension), HttpStatus.OK);
    }

    @PostMapping(value = "{pensionId}/retirementreason/{retirementreasonId}/add")
    public ResponseEntity<PensionDto> addRetirementReasonToPension(@PathVariable final long pensionId,
                                                                  @PathVariable final long retirementreasonId) {
        Pension pension = pensionService.addRetirementReasonToPension(pensionId, retirementreasonId);
        return new ResponseEntity<>(PensionDto.from(pension), HttpStatus.OK);
    }

    @DeleteMapping(value = "{pensionId}/retirementreason/remove")
    public ResponseEntity<PensionDto> removeRetirementReasonFromPension(@PathVariable final long pensionId) {
        Pension pension = pensionService.removeRetirementReasonFromPension(pensionId);
        return new ResponseEntity<>(PensionDto.from(pension), HttpStatus.OK);
    }

    @PostMapping(value = "{pensionId}/officialcategory/{officialcategoryId}/add")
    public ResponseEntity<PensionDto> addOfficialCategoryToPension(@PathVariable final long pensionId,
                                                                   @PathVariable final long officialcategoryId) {
        Pension pension = pensionService.addOfficialCategoryToPension(pensionId, officialcategoryId);
        return new ResponseEntity<>(PensionDto.from(pension), HttpStatus.OK);
    }

    @DeleteMapping(value = "{pensionId}/officialcategory/remove")
    public ResponseEntity<PensionDto> removeOfficialCategoryFromPension(@PathVariable final long pensionId) {
        Pension pension = pensionService.removeOfficialCategoryFromPension(pensionId);
        return new ResponseEntity<>(PensionDto.from(pension), HttpStatus.OK);
    }

}
