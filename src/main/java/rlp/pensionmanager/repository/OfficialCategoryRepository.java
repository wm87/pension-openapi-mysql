package rlp.pensionmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rlp.pensionmanager.model.OfficialCategory;

@Repository
public interface OfficialCategoryRepository extends JpaRepository<OfficialCategory, Long> {
}
