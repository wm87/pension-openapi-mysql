package rlp.pensionmanager.model.dto;

import rlp.pensionmanager.model.DutyHour;

import java.time.LocalDate;


public class DutyHourDto {

    private long id;
    private LocalDate beginning;
    private LocalDate ending;
    private String partTime;
    private String restriction;

    private long officialTimeKeyId;
    private String officialTimeKeyName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getBeginning() {
        return beginning;
    }

    public void setBeginning(LocalDate beginning) {
        this.beginning = beginning;
    }

    public LocalDate getEnding() {
        return ending;
    }

    public void setEnding(LocalDate ending) {
        this.ending = ending;
    }

    public String getPartTime() {
        return partTime;
    }

    public void setPartTime(String partTime) {
        this.partTime = partTime;
    }

    public String getRestriction() {
        return restriction;
    }

    public void setRestriction(String restriction) {
        this.restriction = restriction;
    }

    public long getOfficialTimeKeyId() {
        return officialTimeKeyId;
    }

    public void setOfficialTimeKeyId(long officialTimeKeyId) {
        this.officialTimeKeyId = officialTimeKeyId;
    }

    public String getOfficialTimeKeyName() {
        return officialTimeKeyName;
    }

    public void setOfficialTimeKeyName(String officialTimeKeyName) {
        this.officialTimeKeyName = officialTimeKeyName;
    }

    public static DutyHourDto from(DutyHour dutyHour) {
        DutyHourDto dutyHourDto = new DutyHourDto();

        dutyHourDto.setId(dutyHour.getId());
        dutyHourDto.setBeginning(dutyHour.getBeginning());
        dutyHourDto.setEnding(dutyHour.getEnding());
        dutyHourDto.setPartTime(dutyHour.getPartTime());
        dutyHourDto.setRestriction(dutyHour.getRestriction());

        if (dutyHour.getOfficialTimeKeys() != null) {
            dutyHourDto.setOfficialTimeKeyId(dutyHour.getOfficialTimeKeys().getKeyOTK());
            dutyHourDto.setOfficialTimeKeyName(dutyHour.getOfficialTimeKeys().getName());
        }

        return dutyHourDto;
    }
}
