package rlp.pensionmanager.model;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import rlp.pensionmanager.model.dto.DutyHourDto;

import java.time.LocalDate;

@Entity
@Table(name = "dutyhour")
public class DutyHour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private long id;

    public DutyHour() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getBeginning() {
        return beginning;
    }

    public void setBeginning(LocalDate beginning) {
        this.beginning = beginning;
    }

    public LocalDate getEnding() {
        return ending;
    }

    public void setEnding(LocalDate ending) {
        this.ending = ending;
    }

    public String getPartTime() {
        return partTime;
    }

    public void setPartTime(String partTime) {
        this.partTime = partTime;
    }

    public String getRestriction() {
        return restriction;
    }

    public void setRestriction(String restriction) {
        this.restriction = restriction;
    }

    public OfficialTimeKey getOfficialTimeKeys() {
        return officialTimeKeys;
    }

    public void setOfficialTimeKeys(OfficialTimeKey officialTimeKeys) {
        this.officialTimeKeys = officialTimeKeys;
    }

    private LocalDate beginning;
    private LocalDate ending;
    private String partTime;
    private String restriction;

    @Autowired
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private OfficialTimeKey officialTimeKeys;

    public static DutyHour from(DutyHourDto dutyHourDto){
        DutyHour dutyHour = new DutyHour();

        dutyHour.setPartTime(dutyHourDto.getPartTime());
        dutyHour.setBeginning(dutyHourDto.getBeginning());
        dutyHour.setEnding(dutyHourDto.getEnding());
        dutyHour.setRestriction(dutyHourDto.getRestriction());

        return dutyHour;
    }
}
