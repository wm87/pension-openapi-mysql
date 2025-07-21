package rlp.pensionmanager.repository;

import rlp.pensionmanager.model.Pension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PensionRepository extends JpaRepository<Pension, Long> {

}
