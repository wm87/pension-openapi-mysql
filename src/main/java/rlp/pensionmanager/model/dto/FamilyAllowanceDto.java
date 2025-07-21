package rlp.pensionmanager.model.dto;

import rlp.pensionmanager.model.FamilyAllowance;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class FamilyAllowanceDto {
    private long id;
    private String name;

    public static FamilyAllowanceDto from(FamilyAllowance familyAllowance) {
        FamilyAllowanceDto familyAllowanceDto = new FamilyAllowanceDto();

        familyAllowanceDto.setId(familyAllowance.getId());
        familyAllowanceDto.setName(familyAllowance.getName());

        return familyAllowanceDto;
    }
}
