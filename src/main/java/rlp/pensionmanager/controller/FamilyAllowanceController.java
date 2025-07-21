package rlp.pensionmanager.controller;

import rlp.pensionmanager.model.FamilyAllowance;
import rlp.pensionmanager.model.dto.FamilyAllowanceDto;
import rlp.pensionmanager.service.FamilyAllowanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/familyallowance")
public class FamilyAllowanceController {

    private final FamilyAllowanceService familyAllowanceService;

    @Autowired
    public FamilyAllowanceController(FamilyAllowanceService familyAllowanceService) {
        this.familyAllowanceService = familyAllowanceService;
    }

    @PostMapping
    public ResponseEntity<FamilyAllowanceDto> addFamilyAllowance(@RequestBody final FamilyAllowanceDto familyAllowanceDto) {
        FamilyAllowance familyAllowance = familyAllowanceService.addFamilyAllowance(FamilyAllowance.from(familyAllowanceDto));
        return new ResponseEntity<>(FamilyAllowanceDto.from(familyAllowance), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FamilyAllowanceDto>> getFamilyAllowances() {
        List<FamilyAllowance> familyAllowances = familyAllowanceService.getFamilyAllowances();
        List<FamilyAllowanceDto> familyallowancesDto = familyAllowances.stream().map(FamilyAllowanceDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(familyallowancesDto, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<FamilyAllowanceDto> getFamilyAllowance(@PathVariable final int id) {
        FamilyAllowance familyAllowance = familyAllowanceService.getFamilyAllowance(id);
        return new ResponseEntity<>(FamilyAllowanceDto.from(familyAllowance), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<FamilyAllowanceDto> deleteFamilyAllowance(@PathVariable final int id) {
        FamilyAllowance familyAllowance = familyAllowanceService.deleteFamilyAllowance(id);
        return new ResponseEntity<>(FamilyAllowanceDto.from(familyAllowance), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<FamilyAllowanceDto> editFamilyAllowance(@PathVariable final int id,
                                                                  @RequestBody final FamilyAllowanceDto familyAllowanceDto) {
        FamilyAllowance editedFamilyAllowance = familyAllowanceService.editFamilyAllowance(id, FamilyAllowance.from(familyAllowanceDto));
        return new ResponseEntity<>(FamilyAllowanceDto.from(editedFamilyAllowance), HttpStatus.OK);
    }
}
