package rlp.pensionmanager.model.dto;

import rlp.pensionmanager.model.OfficialCategory;


public class OfficialCategoryDto {
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

    public static OfficialCategoryDto from(OfficialCategory officialCategory) {
        OfficialCategoryDto officialCategoryDto = new OfficialCategoryDto();

        officialCategoryDto.id = officialCategory.getId();
        officialCategoryDto.name = officialCategory.getName();

        return officialCategoryDto;
    }
}
