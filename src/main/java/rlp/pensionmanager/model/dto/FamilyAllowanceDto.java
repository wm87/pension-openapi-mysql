package rlp.pensionmanager.model.dto;

import rlp.pensionmanager.model.FamilyAllowance;

public class FamilyAllowanceDto {
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static FamilyAllowanceDto from(FamilyAllowance familyAllowance) {
        FamilyAllowanceDto familyAllowanceDto = new FamilyAllowanceDto();

        familyAllowanceDto.setId(familyAllowance.getId());
        familyAllowanceDto.setName(familyAllowance.getName());

        return familyAllowanceDto;
    }
}
