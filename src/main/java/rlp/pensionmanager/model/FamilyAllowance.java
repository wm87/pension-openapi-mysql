package rlp.pensionmanager.model;

import rlp.pensionmanager.model.dto.FamilyAllowanceDto;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "familyallowance")
public class FamilyAllowance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "familyAllowance_id",referencedColumnName = "id")
    private List<FamilyAllowance> familyAllowances = new ArrayList<>();

    public FamilyAllowance() {
    }

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

    public List<FamilyAllowance> getFamilyAllowances() {
        return familyAllowances;
    }

    public void setFamilyAllowances(List<FamilyAllowance> familyAllowances) {
        this.familyAllowances = familyAllowances;
    }

    public FamilyAllowance(String name) {
        this.name = name;
    }

    public void addFamilyAllowance(FamilyAllowance familyAllowance) {
        familyAllowances.add(familyAllowance);
    }

    public void removeFamilyAllowance(FamilyAllowance familyAllowance) {
        familyAllowances.remove(familyAllowance);
    }

    public static FamilyAllowance from(FamilyAllowanceDto familyAllowanceDto){
        return new FamilyAllowance(familyAllowanceDto.getName());
    }
}
