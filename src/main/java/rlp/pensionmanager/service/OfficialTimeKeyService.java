package rlp.pensionmanager.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rlp.pensionmanager.model.OfficialTimeKey;
import rlp.pensionmanager.model.errors.OfficialTimeKeyNotFoundException;
import rlp.pensionmanager.repository.OfficialTimeKeyRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class OfficialTimeKeyService {

    private final OfficialTimeKeyRepository officialTimeKeyRepository;

    @Autowired
    public OfficialTimeKeyService(OfficialTimeKeyRepository officialTimeKeyRepository) {
        this.officialTimeKeyRepository = officialTimeKeyRepository;
    }

    public OfficialTimeKey addOfficialTimeKey(OfficialTimeKey officialTimeKey){
        return officialTimeKeyRepository.save(officialTimeKey);
    }

    public List<OfficialTimeKey> getOfficialTimeKeys(){
        return new ArrayList<>(officialTimeKeyRepository.findAll());
    }

    public OfficialTimeKey getOfficialTimeKey(long id){
        return officialTimeKeyRepository.findById(id).orElseThrow(() ->
                new OfficialTimeKeyNotFoundException(id));
    }

    @Transactional
    public OfficialTimeKey deleteOfficialTimeKey(long id){
        OfficialTimeKey officialTimeKey = getOfficialTimeKey(id);
        officialTimeKeyRepository.delete(officialTimeKey);
        return officialTimeKey;
    }

    @Transactional
    public OfficialTimeKey editOfficialTimeKey(long id, OfficialTimeKey officialTimeKey){
        OfficialTimeKey officialTimeKeyToEdit = getOfficialTimeKey(id);
        officialTimeKeyToEdit.setName(officialTimeKey.getName());
        return officialTimeKeyToEdit;
    }
}
