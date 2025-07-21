package rlp.pensionmanager.service;

import rlp.pensionmanager.repository.FamilyAllowanceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rlp.pensionmanager.model.FamilyAllowance;
import rlp.pensionmanager.model.errors.FamilyAllowanceNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class FamilyAllowanceService {

    private final FamilyAllowanceRepository familyAllowanceRepository;

    @Autowired
    public FamilyAllowanceService(FamilyAllowanceRepository familyAllowanceRepository) {
        this.familyAllowanceRepository = familyAllowanceRepository;
    }

    public FamilyAllowance addFamilyAllowance(FamilyAllowance familyAllowance){
        return familyAllowanceRepository.save(familyAllowance);
    }

    public List<FamilyAllowance> getFamilyAllowances(){
        return new ArrayList<>(familyAllowanceRepository.findAll());
    }

    public FamilyAllowance getFamilyAllowance(long id){
        return familyAllowanceRepository.findById(id).orElseThrow(() ->
                new FamilyAllowanceNotFoundException(id));
    }

    @Transactional
    public FamilyAllowance deleteFamilyAllowance(int id){
        FamilyAllowance familyAllowance = getFamilyAllowance(id);
        familyAllowanceRepository.delete(familyAllowance);
        return familyAllowance;
    }

    @Transactional
    public FamilyAllowance editFamilyAllowance(int id, FamilyAllowance familyAllowance){
        FamilyAllowance familyAllowanceToEdit = getFamilyAllowance(id);
        familyAllowanceToEdit.setName(familyAllowance.getName());
        return familyAllowanceToEdit;
    }
}
