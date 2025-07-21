package rlp.pensionmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rlp.pensionmanager.model.OfficialCategory;
import rlp.pensionmanager.model.dto.OfficialCategoryDto;
import rlp.pensionmanager.service.OfficialCategoryService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/officialcategory")
public class OfficialCategoryController {

    private final OfficialCategoryService officialCategoryService;

    @Autowired
    public OfficialCategoryController(OfficialCategoryService officialCategoryService) {
        this.officialCategoryService = officialCategoryService;
    }

    @PostMapping
    public ResponseEntity<OfficialCategoryDto> addOfficialCategory(@RequestBody final OfficialCategoryDto officialCategoryDto){
        OfficialCategory officialCategory = officialCategoryService.addOfficialCategory(OfficialCategory.from(officialCategoryDto));
        return new ResponseEntity<>(OfficialCategoryDto.from(officialCategory), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OfficialCategoryDto>> getOfficialCategorys(){
        List<OfficialCategory> officialCategorys = officialCategoryService.getOfficialCategorys();
        List<OfficialCategoryDto> officialCategoryDto = officialCategorys.stream().map(OfficialCategoryDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(officialCategoryDto, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<OfficialCategoryDto> getOfficialCategory(@PathVariable final int id){
        OfficialCategory officialCategory = officialCategoryService.getOfficialCategory(id);
        return new ResponseEntity<>(OfficialCategoryDto.from(officialCategory), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<OfficialCategoryDto> deleteOfficialCategory(@PathVariable final int id){
        OfficialCategory officialCategory = officialCategoryService.deleteOfficialCategory(id);
        return new ResponseEntity<>(OfficialCategoryDto.from(officialCategory), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<OfficialCategoryDto> editOfficialCategory(@PathVariable final int id,
                                                                    @RequestBody final OfficialCategoryDto officialCategoryDto){
        OfficialCategory editedOfficialCategory = officialCategoryService.editOfficialCategory(id, OfficialCategory.from(officialCategoryDto));
        return new ResponseEntity<>(OfficialCategoryDto.from(editedOfficialCategory), HttpStatus.OK);
    }
}
