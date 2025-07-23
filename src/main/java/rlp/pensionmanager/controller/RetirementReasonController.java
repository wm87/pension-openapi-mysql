package rlp.pensionmanager.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rlp.pensionmanager.model.RetirementReason;
import rlp.pensionmanager.model.dto.RetirementReasonDto;
import rlp.pensionmanager.service.FamilyAllowanceService;
import rlp.pensionmanager.service.RetirementReasonService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@SecurityRequirement(name = "javainuseapi")
@RequestMapping("/api/retirementreason")
public class RetirementReasonController {

    private final RetirementReasonService retirementReasonService;

    @Autowired
    public RetirementReasonController(RetirementReasonService retirementReasonService) {
        this.retirementReasonService = retirementReasonService;
    }

    @PostMapping
    public ResponseEntity<RetirementReasonDto> addRetirementReason(@RequestBody final RetirementReasonDto retirementReasonDto) {
        RetirementReason retirementReason = retirementReasonService.addRetirementReason(RetirementReason.from(retirementReasonDto));
        return new ResponseEntity<>(RetirementReasonDto.from(retirementReason), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RetirementReasonDto>> getRetirementReasons() {
        List<RetirementReason> familyAllowances = retirementReasonService.getFamilyAllowances();
        List<RetirementReasonDto> retirementreasonDto = familyAllowances.stream().map(RetirementReasonDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(retirementreasonDto, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<RetirementReasonDto> getRetirementReason(@PathVariable final int id) {
        RetirementReason retirementReason = retirementReasonService.getRetirementReason(id);
        return new ResponseEntity<>(RetirementReasonDto.from(retirementReason), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<RetirementReasonDto> deleteRetirementReason(@PathVariable final int id) {
        RetirementReason retirementReason = retirementReasonService.deleteRetirementReason(id);
        return new ResponseEntity<>(RetirementReasonDto.from(retirementReason), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<RetirementReasonDto> editRetirementReason(@PathVariable final int id,
                                                                  @RequestBody final RetirementReasonDto retirementReasonDto) {
        RetirementReason editedRetirementReason = retirementReasonService.editRetirementReason(id, RetirementReason.from(retirementReasonDto));
        return new ResponseEntity<>(RetirementReasonDto.from(editedRetirementReason), HttpStatus.OK);
    }
}
