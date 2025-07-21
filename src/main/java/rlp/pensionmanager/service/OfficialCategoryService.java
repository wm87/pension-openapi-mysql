package rlp.pensionmanager.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rlp.pensionmanager.model.OfficialCategory;
import rlp.pensionmanager.model.errors.OfficialCategoryNotFoundException;
import rlp.pensionmanager.repository.OfficialCategoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class OfficialCategoryService {

    private final OfficialCategoryRepository officialCategoryRepository;

    @Autowired
    public OfficialCategoryService(OfficialCategoryRepository officialCategoryRepository) {
        this.officialCategoryRepository = officialCategoryRepository;
    }

    public OfficialCategory addOfficialCategory(OfficialCategory officialCategory){
        return officialCategoryRepository.save(officialCategory);
    }

    public List<OfficialCategory> getOfficialCategorys(){
        return new ArrayList<>(officialCategoryRepository.findAll());
    }

    public OfficialCategory getOfficialCategory(long id){
        return officialCategoryRepository.findById(id).orElseThrow(() ->
                new OfficialCategoryNotFoundException(id));
    }

    @Transactional
    public OfficialCategory deleteOfficialCategory(int id){
        OfficialCategory officialCategory = getOfficialCategory(id);
        officialCategoryRepository.delete(officialCategory);
        return officialCategory;
    }

    @Transactional
    public OfficialCategory editOfficialCategory(int id, OfficialCategory officialCategory){
        OfficialCategory officialCategoryToEdit = getOfficialCategory(id);

        officialCategoryToEdit.setName(officialCategory.getName());

        return officialCategoryToEdit;
    }
}
