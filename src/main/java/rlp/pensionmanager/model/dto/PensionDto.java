package rlp.pensionmanager.model.dto;

import rlp.pensionmanager.model.Pension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class PensionDto {
    private long id;
    private List<DutyHourDto> dutyHoursDto = new ArrayList<>();
    //private List<FamilyAllowanceDto> familyAllowanceDto = new ArrayList<>();

    private int idAbbreviation;
    private LocalDate birthday;
    private LocalDate justificationOfficialRelationship;
    private String retirementReason;
    private LocalDate firstRetirementDay;

    //private long retirementReasonId;
    private String retirementReasoName;

    //private long familyAllowanceId;
    private String familyAllowanceName;

    //private int officialCategoryId;
    private String officialCategoryName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<DutyHourDto> getDutyHoursDto() {
        return dutyHoursDto;
    }

    public void setDutyHoursDto(List<DutyHourDto> dutyHoursDto) {
        this.dutyHoursDto = dutyHoursDto;
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

    public String getRetirementReason() {
        return retirementReason;
    }

    public void setRetirementReason(String retirementReason) {
        this.retirementReason = retirementReason;
    }

    public LocalDate getFirstRetirementDay() {
        return firstRetirementDay;
    }

    public void setFirstRetirementDay(LocalDate firstRetirementDay) {
        this.firstRetirementDay = firstRetirementDay;
    }

    public String getRetirementReasoName() {
        return retirementReasoName;
    }

    public void setRetirementReasoName(String retirementReasoName) {
        this.retirementReasoName = retirementReasoName;
    }

    public String getFamilyAllowanceName() {
        return familyAllowanceName;
    }

    public void setFamilyAllowanceName(String familyAllowanceName) {
        this.familyAllowanceName = familyAllowanceName;
    }

    public String getOfficialCategoryName() {
        return officialCategoryName;
    }

    public void setOfficialCategoryName(String officialCategoryName) {
        this.officialCategoryName = officialCategoryName;
    }

    public static PensionDto from(Pension pension) {
        PensionDto pensionDto = new PensionDto();

        pensionDto.setId(pension.getId());
        pensionDto.setIdAbbreviation(pension.getIdAbbreviation());
        pensionDto.setBirthday(pension.getBirthday());
        pensionDto.setJustificationOfficialRelationship(pension.getJustificationOfficialRelationship());
        pensionDto.setFirstRetirementDay(pension.getFirstRetirementDay());

        if (pension.getRetirementReason() != null) {
            pensionDto.setRetirementReasoName(pension.getRetirementReason().getName());
        }

        if (pension.getFamilyAllowance() != null) {
            //pensionDto.setFamilyAllowanceId(pension.getFamilyAllowance().getId());
            pensionDto.setFamilyAllowanceName(pension.getFamilyAllowance().getName());
        }

        if (pension.getOfficialCategory() != null) {
            //pensionDto.setOfficialCategoryId(pension.getOfficialCategory().getId());
            pensionDto.setOfficialCategoryName(pension.getOfficialCategory().getName());
        }

        pensionDto.setDutyHoursDto(pension.getDutyHours().stream().map(DutyHourDto::from).collect(Collectors.toList()));
        return pensionDto;
    }
}
