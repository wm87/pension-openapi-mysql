package rlp.pensionmanager.model;

import rlp.pensionmanager.model.dto.PensionDto;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pension")
public class Pension {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private long id;

    public Pension() {
    }

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getIdAbbreviation() {
        return idAbbreviation;
    }

    public void setIdAbbreviation(int idAbbreviation) {
        this.idAbbreviation = idAbbreviation;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getJustificationOfficialRelationship() {
        return justificationOfficialRelationship;
    }

    public void setJustificationOfficialRelationship(LocalDate justificationOfficialRelationship) {
        this.justificationOfficialRelationship = justificationOfficialRelationship;
    }

    public LocalDate getFirstRetirementDay() {
        return firstRetirementDay;
    }

    public void setFirstRetirementDay(LocalDate firstRetirementDay) {
        this.firstRetirementDay = firstRetirementDay;
    }

    public List<DutyHour> getDutyHours() {
        return dutyHours;
    }

    public void setDutyHours(List<DutyHour> dutyHours) {
        this.dutyHours = dutyHours;
    }

    public RetirementReason getRetirementReason() {
        return retirementReason;
    }

    public void setRetirementReason(RetirementReason retirementReason) {
        this.retirementReason = retirementReason;
    }

    public FamilyAllowance getFamilyAllowance() {
        return familyAllowance;
    }

    public void setFamilyAllowance(FamilyAllowance familyAllowance) {
        this.familyAllowance = familyAllowance;
    }

    public OfficialCategory getOfficialCategory() {
        return officialCategory;
    }

    public void setOfficialCategory(OfficialCategory officialCategory) {
        this.officialCategory = officialCategory;
    }

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
