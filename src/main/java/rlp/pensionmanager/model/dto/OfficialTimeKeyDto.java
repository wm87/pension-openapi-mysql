package rlp.pensionmanager.model.dto;


import rlp.pensionmanager.model.OfficialTimeKey;


public class OfficialTimeKeyDto {
    private int id;
    private int keyOTK;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKeyOTK() {
        return keyOTK;
    }

    public void setKeyOTK(int keyOTK) {
        this.keyOTK = keyOTK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static OfficialTimeKeyDto from(OfficialTimeKey officialTimeKey) {
        OfficialTimeKeyDto officialTimeKeyDto = new OfficialTimeKeyDto();

        officialTimeKeyDto.id = officialTimeKey.getId();
        officialTimeKeyDto.keyOTK = officialTimeKey.getKeyOTK();
        officialTimeKeyDto.name = officialTimeKey.getName();
        return officialTimeKeyDto;
    }
}
