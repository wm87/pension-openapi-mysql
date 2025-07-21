package rlp.pensionmanager.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rlp.pensionmanager.model.RetirementReason;
import rlp.pensionmanager.model.errors.RetirementReasonNotFoundException;
import rlp.pensionmanager.repository.RetirementReasonRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class RetirementReasonService {

    private final RetirementReasonRepository retirementReasonRepository;

    @Autowired
    public RetirementReasonService(RetirementReasonRepository familyAllowanceRepository) {
        this.retirementReasonRepository = familyAllowanceRepository;
    }

    public RetirementReason addRetirementReason(RetirementReason retirementReason){
        return retirementReasonRepository.save(retirementReason);
    }

    public List<RetirementReason> getFamilyAllowances(){
        return new ArrayList<>(retirementReasonRepository.findAll());
    }

    public RetirementReason getRetirementReason(long id){
        return retirementReasonRepository.findById(id).orElseThrow(() ->
                new RetirementReasonNotFoundException(id));
    }

    @Transactional
    public RetirementReason deleteRetirementReason(int id){
        RetirementReason retirementReason = getRetirementReason(id);
        retirementReasonRepository.delete(retirementReason);
        return retirementReason;
    }

    @Transactional
    public RetirementReason editRetirementReason(int id, RetirementReason retirementReason){
        RetirementReason retirementReasonToEdit = getRetirementReason(id);
        retirementReasonToEdit.setName(retirementReason.getName());
        return retirementReasonToEdit;
    }
}
