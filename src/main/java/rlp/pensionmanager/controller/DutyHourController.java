package rlp.pensionmanager.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rlp.pensionmanager.model.DutyHour;
import rlp.pensionmanager.model.dto.DutyHourDto;
import rlp.pensionmanager.service.DutyHourService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@SecurityRequirement(name = "javainuseapi")
@RequestMapping("/api/dutyhours")
public class DutyHourController {

    private final DutyHourService dutyHourService;

    @Autowired
    public DutyHourController(DutyHourService dutyHourService) {
        this.dutyHourService = dutyHourService;
    }

    @PostMapping
    public ResponseEntity<DutyHourDto> addDutyHour(@RequestBody final DutyHourDto dutyHourDto) {
        DutyHour dutyHour = dutyHourService.addDutyHour(DutyHour.from(dutyHourDto));
        return new ResponseEntity<>(DutyHourDto.from(dutyHour), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DutyHourDto>> getDutyHours() {
        List<DutyHour> dutyHours = dutyHourService.getDutyHours();
        List<DutyHourDto> dutyhoursDto = dutyHours.stream().map(DutyHourDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(dutyhoursDto, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<DutyHourDto> getDutyHour(@PathVariable final long id) {
        DutyHour dutyHour = dutyHourService.getDutyHour(id);
        return new ResponseEntity<>(DutyHourDto.from(dutyHour), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<DutyHourDto> deleteDutyHour(@PathVariable final long id) {
        DutyHour dutyHour = dutyHourService.deleteDutyHour(id);
        return new ResponseEntity<>(DutyHourDto.from(dutyHour), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<DutyHourDto> editDutyHour(@PathVariable final long id,
                                                    @RequestBody final DutyHourDto dutyHourDto) {
        DutyHour editedDutyHour = dutyHourService.editDutyHour(id, DutyHour.from(dutyHourDto));
        return new ResponseEntity<>(DutyHourDto.from(editedDutyHour), HttpStatus.OK);
    }

    @PostMapping(value = "{dutyhourId}/officialtimekey/{officialtimekeyId}/add")
    public ResponseEntity<DutyHourDto> addOfficialTimeKeyToDutyHour(@PathVariable final long dutyhourId,
                                                                   @PathVariable final long officialtimekeyId) {
        DutyHour assignedOTK = dutyHourService.addOfficialTimeKeyToDutyHour(dutyhourId, officialtimekeyId);
        return new ResponseEntity<>(DutyHourDto.from(assignedOTK), HttpStatus.OK);
    }

    @DeleteMapping(value = "{dutyhourId}/officialtimekey/{officialtimekeyId}/remove")
    public ResponseEntity<DutyHourDto> removeOfficialTimeKeyFromDutyHour(@PathVariable final long dutyhourId) {
        DutyHour assignedOTK = dutyHourService.removeOfficialTimeKeyFromDutyHour(dutyhourId);
        return new ResponseEntity<>(DutyHourDto.from(assignedOTK), HttpStatus.OK);
    }
}
