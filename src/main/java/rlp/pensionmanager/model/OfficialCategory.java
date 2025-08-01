package rlp.pensionmanager.model;

import rlp.pensionmanager.model.dto.OfficialCategoryDto;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<OfficialCategory> getOfficialCategories() {
        return officialCategories;
    }

    public void setOfficialCategories(List<OfficialCategory> officialCategories) {
        this.officialCategories = officialCategories;
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
