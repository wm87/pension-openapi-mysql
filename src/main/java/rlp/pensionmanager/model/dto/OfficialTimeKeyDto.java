package rlp.pensionmanager.model.dto;

import lombok.Data;
import rlp.pensionmanager.model.OfficialTimeKey;

@Data
public class OfficialTimeKeyDto {
    private long id;
    private int keyOTK;
    private String name;

    public static OfficialTimeKeyDto from(OfficialTimeKey officialTimeKey) {
        OfficialTimeKeyDto officialTimeKeyDto = new OfficialTimeKeyDto();
        officialTimeKeyDto.keyOTK = officialTimeKey.getKeyOTK();
        officialTimeKeyDto.name = officialTimeKey.getName();
        return officialTimeKeyDto;
    }
}
