package rlp.pensionmanager.model;

import jakarta.persistence.*;
import rlp.pensionmanager.model.dto.OfficialTimeKeyDto;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "officialtimekey")
public class OfficialTimeKey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    private int keyOTK;
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "officialTimeKey_id", referencedColumnName = "id")
    private List<OfficialTimeKey> officialTimeKeys = new ArrayList<>();

    public OfficialTimeKey() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKeyOTK() {
        return keyOTK;
    }

    public void setKeyOTK(int keyOTK) {
        this.keyOTK = keyOTK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<OfficialTimeKey> getOfficialTimeKeys() {
        return officialTimeKeys;
    }

    public void setOfficialTimeKeys(List<OfficialTimeKey> officialTimeKeys) {
        this.officialTimeKeys = officialTimeKeys;
    }

    public OfficialTimeKey(String name) {
        this.name = name;
    }

    public void addOfficalTimeKey(OfficialTimeKey officialTimeKey) {
        officialTimeKeys.add(officialTimeKey);
    }

    public void removeOfficalTimeKey(OfficialTimeKey officialTimeKey) {
        officialTimeKeys.remove(officialTimeKey);
    }

    public static OfficialTimeKey from(OfficialTimeKeyDto officialTimeKeyDto) {

        OfficialTimeKey officialTimeKey = new OfficialTimeKey();

        officialTimeKey.setId(officialTimeKeyDto.getId());
        officialTimeKey.setKeyOTK(officialTimeKeyDto.getKeyOTK());
        officialTimeKey.setName(officialTimeKeyDto.getName());

        return officialTimeKey;
    }
}
