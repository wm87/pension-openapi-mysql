package rlp.pensionmanager.model;

import jakarta.persistence.*;
import rlp.pensionmanager.model.dto.RetirementReasonDto;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "retirementreason")
public class RetirementReason {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
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

    public List<RetirementReason> getRetirementReasons() {
        return retirementReasons;
    }

    public void setRetirementReasons(List<RetirementReason> retirementReasons) {
        this.retirementReasons = retirementReasons;
    }

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
