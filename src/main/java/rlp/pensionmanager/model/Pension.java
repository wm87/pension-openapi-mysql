package rlp.pensionmanager.model;

import rlp.pensionmanager.model.dto.PensionDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pension")
public class Pension {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private long id;

    private int idAbbreviation;
    private LocalDate birthday;
    private LocalDate justificationOfficialRelationship;
    private LocalDate firstRetirementDay;

    @OneToMany(cascade = CascadeType.ALL)
    private List<DutyHour> dutyHours = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private RetirementReason retirementReason;

    @ManyToOne(fetch = FetchType.LAZY)
    private FamilyAllowance familyAllowance;

    @ManyToOne(fetch = FetchType.LAZY)
    private OfficialCategory officialCategory;

    public void addDutyHour(DutyHour dutyHour) {
        dutyHours.add(dutyHour);
    }

    public void removeDutyHour(DutyHour dutyHour) {
        dutyHours.remove(dutyHour);
    }

    public static Pension from(PensionDto pensionDto) {
        Pension pension = new Pension();
        pension.setIdAbbreviation(pensionDto.getIdAbbreviation());
        pension.setBirthday(pensionDto.getBirthday());
        pension.setJustificationOfficialRelationship(pensionDto.getJustificationOfficialRelationship());
        pension.setFirstRetirementDay(pensionDto.getFirstRetirementDay());
        return pension;
    }
}
