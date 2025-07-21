package rlp.pensionmanager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import rlp.pensionmanager.model.dto.DutyHourDto;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dutyhour")
public class DutyHour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private long id;

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
