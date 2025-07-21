package rlp.pensionmanager.model.dto;

import rlp.pensionmanager.model.DutyHour;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Data
public class DutyHourDto {

    private long id;
    private LocalDate beginning;
    private LocalDate ending;
    private String partTime;
    private String restriction;

    private long officialTimeKeyId;
    private String officialTimeKeyName;

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
