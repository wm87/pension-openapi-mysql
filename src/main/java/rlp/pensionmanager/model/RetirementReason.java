package rlp.pensionmanager.model;

import jakarta.persistence.*;
import lombok.Data;
import rlp.pensionmanager.model.dto.RetirementReasonDto;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "retirementreason")
public class RetirementReason {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "retirementReason_id",referencedColumnName = "id")
    private List<RetirementReason> retirementReasons = new ArrayList<>();

    public RetirementReason() {
    }

    public RetirementReason(String name) {
        this.name = name;
    }

    public void addRetirementReason(RetirementReason retirementReason) {
        retirementReasons.add(retirementReason);
    }

    public void removeRetirementReason(RetirementReason retirementReason) {
        retirementReasons.remove(retirementReason);
    }

    public static RetirementReason from(RetirementReasonDto retirementReasonDto){
        return new RetirementReason(retirementReasonDto.getName());
    }
}
