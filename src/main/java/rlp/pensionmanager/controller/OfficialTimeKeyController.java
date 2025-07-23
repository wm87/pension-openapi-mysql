package rlp.pensionmanager.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rlp.pensionmanager.model.OfficialTimeKey;
import rlp.pensionmanager.model.dto.OfficialTimeKeyDto;
import rlp.pensionmanager.service.OfficialTimeKeyService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@SecurityRequirement(name = "javainuseapi")
@RequestMapping("/api/officialtimekey")
public class OfficialTimeKeyController {

    private final OfficialTimeKeyService officialTimeKeyService;

    @Autowired
    public OfficialTimeKeyController(OfficialTimeKeyService officialTimeKeyService) {
        this.officialTimeKeyService = officialTimeKeyService;
    }

    @PostMapping
    public ResponseEntity<OfficialTimeKeyDto> addOfficialTimeKey(@RequestBody final OfficialTimeKeyDto familyAllowanceDto) {
        OfficialTimeKey familyAllowance = officialTimeKeyService.addOfficialTimeKey(OfficialTimeKey.from(familyAllowanceDto));
        return new ResponseEntity<>(OfficialTimeKeyDto.from(familyAllowance), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OfficialTimeKeyDto>> getOfficialTimeKeys() {
        List<OfficialTimeKey> familyAllowances = officialTimeKeyService.getOfficialTimeKeys();
        List<OfficialTimeKeyDto> officaltimekeysDto = familyAllowances.stream().map(OfficialTimeKeyDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(officaltimekeysDto, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<OfficialTimeKeyDto> getOfficialTimeKey(@PathVariable final int id) {
        OfficialTimeKey familyAllowance = officialTimeKeyService.getOfficialTimeKey(id);
        return new ResponseEntity<>(OfficialTimeKeyDto.from(familyAllowance), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<OfficialTimeKeyDto> deleteOfficialTimeKey(@PathVariable final int id) {
        OfficialTimeKey familyAllowance = officialTimeKeyService.deleteOfficialTimeKey(id);
        return new ResponseEntity<>(OfficialTimeKeyDto.from(familyAllowance), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<OfficialTimeKeyDto> editOfficialTimeKey(@PathVariable final int id,
                                                                  @RequestBody final OfficialTimeKeyDto familyAllowanceDto) {
        OfficialTimeKey editedOfficialTimeKey = officialTimeKeyService.editOfficialTimeKey(id, OfficialTimeKey.from(familyAllowanceDto));
        return new ResponseEntity<>(OfficialTimeKeyDto.from(editedOfficialTimeKey), HttpStatus.OK);
    }
}
