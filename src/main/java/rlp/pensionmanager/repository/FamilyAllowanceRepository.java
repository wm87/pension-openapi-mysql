package rlp.pensionmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rlp.pensionmanager.model.FamilyAllowance;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyAllowanceRepository extends JpaRepository<FamilyAllowance, Long> {
}
