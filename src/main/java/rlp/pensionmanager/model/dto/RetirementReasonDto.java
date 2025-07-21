package rlp.pensionmanager.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import rlp.pensionmanager.model.FamilyAllowance;
import rlp.pensionmanager.model.RetirementReason;

@Setter
@Getter
@Data
public class RetirementReasonDto {
    private long id;
    private String name;

    public static RetirementReasonDto from(RetirementReason retirementReason) {
        RetirementReasonDto retirementReasonDto = new RetirementReasonDto();

        retirementReasonDto.setId(retirementReason.getId());
        retirementReasonDto.setName(retirementReason.getName());

        return retirementReasonDto;
    }
}
