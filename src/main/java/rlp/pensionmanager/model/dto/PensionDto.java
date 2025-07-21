package rlp.pensionmanager.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import rlp.pensionmanager.model.Pension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@Data
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
