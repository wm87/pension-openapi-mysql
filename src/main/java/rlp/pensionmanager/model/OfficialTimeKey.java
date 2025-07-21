package rlp.pensionmanager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import rlp.pensionmanager.model.dto.OfficialTimeKeyDto;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "officialtimekey")
public class OfficialTimeKey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    private int keyOTK;
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "officialTimeKey_id", referencedColumnName = "id")
    private List<OfficialTimeKey> officialTimeKeys = new ArrayList<>();

    public OfficialTimeKey() {
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
