package rlp.pensionmanager.model.dto;

import rlp.pensionmanager.model.OfficialCategory;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class OfficialCategoryDto {
    private long id;
    private String name;

    public static OfficialCategoryDto from(OfficialCategory officialCategory) {
        OfficialCategoryDto officialCategoryDto = new OfficialCategoryDto();

        officialCategoryDto.id = officialCategory.getId();
        officialCategoryDto.name = officialCategory.getName();

        return officialCategoryDto;
    }
}
