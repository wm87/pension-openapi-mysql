package rlp.pensionmanager.model;

import rlp.pensionmanager.model.dto.OfficialCategoryDto;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "official_category")
public class OfficialCategory{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "officialCategory_id",referencedColumnName = "id")
    private List<OfficialCategory> officialCategories = new ArrayList<>();

    public OfficialCategory() {
    }

    public OfficialCategory(String name) {
        this.name = name;
    }

    public void addOfficialCategory(OfficialCategory officialCategory) {
        officialCategories.add(officialCategory);
    }

    public void removeOfficialCategory(OfficialCategory officialCategory) {
        officialCategories.remove(officialCategory);
    }

    public static OfficialCategory from(OfficialCategoryDto officialCategoryDto){

        return new OfficialCategory(officialCategoryDto.getName());
    }
}
