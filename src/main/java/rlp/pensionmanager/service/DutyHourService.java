package rlp.pensionmanager.service;

import rlp.pensionmanager.model.DutyHour;
import rlp.pensionmanager.model.OfficialCategory;
import rlp.pensionmanager.model.OfficialTimeKey;
import rlp.pensionmanager.model.Pension;
import rlp.pensionmanager.repository.DutyHourRepository;
import rlp.pensionmanager.model.errors.DutyHourNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DutyHourService {

    private final DutyHourRepository dutyHourRepository;
    private final OfficialTimeKeyService officialTimeKeyService;

    @Autowired
    public DutyHourService(DutyHourRepository dutyHourRepository, OfficialTimeKeyService officialTimeKeyService) {
        this.dutyHourRepository = dutyHourRepository;
        this.officialTimeKeyService = officialTimeKeyService;
    }

    public DutyHour addDutyHour(DutyHour dutyHour){
        return dutyHourRepository.save(dutyHour);
    }

    public List<DutyHour> getDutyHours(){
        return new ArrayList<>(dutyHourRepository.findAll());
    }

    public DutyHour getDutyHour(long id){
        return dutyHourRepository.findById(id).orElseThrow(() ->
                new DutyHourNotFoundException(id));
    }

    @Transactional
    public DutyHour deleteDutyHour(long id){
        DutyHour dutyHour = getDutyHour(id);
        dutyHourRepository.delete(dutyHour);
        return dutyHour;
    }

    @Transactional
    public DutyHour editDutyHour(long id, DutyHour dutyHour){
        DutyHour dutyHourToEdit = getDutyHour(id);

        dutyHourToEdit.setBeginning(dutyHour.getBeginning());
        dutyHourToEdit.setEnding(dutyHour.getEnding());
        dutyHourToEdit.setPartTime(dutyHour.getPartTime());
        dutyHourToEdit.setRestriction(dutyHour.getRestriction());

        return dutyHourToEdit;
    }

    @Transactional
    public DutyHour addOfficialTimeKeyToDutyHour(long id, long officialTimeKeyId) {
        OfficialTimeKey officialTimeKey = officialTimeKeyService.getOfficialTimeKey(officialTimeKeyId);
        DutyHour dutyHourToEdit = getDutyHour(id);
        dutyHourToEdit.setOfficialTimeKeys(officialTimeKey);
        return dutyHourToEdit;
    }

    @Transactional
    public DutyHour removeOfficialTimeKeyFromDutyHour(long id) {
        DutyHour dutyHourToEdit = getDutyHour(id);
        dutyHourToEdit.setOfficialTimeKeys(null);
        return dutyHourToEdit;
    }
}
