package rlp.pensionmanager.model.dto;


import rlp.pensionmanager.model.FamilyAllowance;
import rlp.pensionmanager.model.RetirementReason;


public class RetirementReasonDto {
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

    public static RetirementReasonDto from(RetirementReason retirementReason) {
        RetirementReasonDto retirementReasonDto = new RetirementReasonDto();

        retirementReasonDto.setId(retirementReason.getId());
        retirementReasonDto.setName(retirementReason.getName());

        return retirementReasonDto;
    }
}
