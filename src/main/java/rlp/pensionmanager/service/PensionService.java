package rlp.pensionmanager.service;

import rlp.pensionmanager.model.*;
import rlp.pensionmanager.repository.PensionRepository;
import rlp.pensionmanager.model.errors.PensionNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PensionService {

    private final PensionRepository pensionRepository;
    private final DutyHourService dutyHourService;
    private final RetirementReasonService retirementReasonService;
    private final FamilyAllowanceService familyAllowanceService;
    private final OfficialCategoryService officialCategoryService;

    @Autowired
    public PensionService(PensionRepository pensionRepository, DutyHourService dutyHourService, RetirementReasonService retirementReasonService, FamilyAllowanceService familyAllowanceService, OfficialCategoryService officialCategoryService) {
        this.pensionRepository = pensionRepository;
        this.dutyHourService = dutyHourService;
        this.retirementReasonService = retirementReasonService;
        this.familyAllowanceService = familyAllowanceService;
        this.officialCategoryService = officialCategoryService;
    }

    public Pension addPension(Pension pension) {
        return pensionRepository.save(pension);
    }

    public List<Pension> getPensions() {
        return new ArrayList<>(pensionRepository.findAll());
    }

    public Pension getPension(long id) {
        return pensionRepository.findById(id).orElseThrow(() ->
                new PensionNotFoundException(id));
    }

    @Transactional
    public Pension deletePension(long id) {
        Pension pension = getPension(id);
        pensionRepository.delete(pension);
        return pension;
    }

    @Transactional
    public Pension editPension(long id, Pension pension) {

        Pension pensionToEdit = getPension(id);
        pensionToEdit.setIdAbbreviation(pension.getIdAbbreviation());
        pensionToEdit.setBirthday(pension.getBirthday());
        pensionToEdit.setJustificationOfficialRelationship(pension.getJustificationOfficialRelationship());
        pensionToEdit.setFirstRetirementDay(pension.getFirstRetirementDay());
        return pensionToEdit;
    }

    @Transactional
    public Pension addDutyHourToPension(long pensionId, long dutyHourId) {
        Pension pension = getPension(pensionId);
        DutyHour dutyHour = dutyHourService.getDutyHour(dutyHourId);
        pension.addDutyHour(dutyHour);
        return pension;
    }

    @Transactional
    public Pension removeDutyHourFromPension(long pensionId, long dutyHourId) {
        Pension pension = getPension(pensionId);
        DutyHour dutyHour = dutyHourService.getDutyHour(dutyHourId);
        pension.removeDutyHour(dutyHour);
        return pension;
    }

    @Transactional
    public Pension addFamilyAllowanceToPension(long pensionId, long familyAllowanceId) {
        FamilyAllowance familyAllowance = familyAllowanceService.getFamilyAllowance(familyAllowanceId);
        Pension pension = getPension(pensionId);
        pension.setFamilyAllowance(familyAllowance);
        return pension;
    }

    @Transactional
    public Pension removeFamilyAllowanceFromPension(long pensionId) {
        Pension pension = getPension(pensionId);
        pension.setFamilyAllowance(null);
        return pension;
    }

    @Transactional
    public Pension addRetirementReasonToPension(long pensionId, long retirementReasonId) {
        RetirementReason retirementReason = retirementReasonService.getRetirementReason(retirementReasonId);
        Pension pension = getPension(pensionId);
        pension.setRetirementReason(retirementReason);
        return pension;
    }

    @Transactional
    public Pension removeRetirementReasonFromPension(long pensionId) {
        Pension pension = getPension(pensionId);
        pension.setRetirementReason(null);
        return pension;
    }

    @Transactional
    public Pension addOfficialCategoryToPension(long pensionId, long officialCategoryId) {
        OfficialCategory officialCategory = officialCategoryService.getOfficialCategory(officialCategoryId);
        Pension pension = getPension(pensionId);
        pension.setOfficialCategory(officialCategory);
        //officialCategory.addOfficialCategory(pension.getOfficialCategory());
        return pension;
    }

    @Transactional
    public Pension removeOfficialCategoryFromPension(long pensionId) {
        Pension pension = getPension(pensionId);
        pension.setOfficialCategory(null);
        return pension;
    }
}
