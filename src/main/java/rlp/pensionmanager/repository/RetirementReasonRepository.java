package rlp.pensionmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rlp.pensionmanager.model.FamilyAllowance;
import rlp.pensionmanager.model.RetirementReason;

@Repository
public interface RetirementReasonRepository extends JpaRepository<RetirementReason, Long> {
}
