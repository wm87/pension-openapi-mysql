package rlp.pensionmanager.repository;

import rlp.pensionmanager.model.DutyHour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DutyHourRepository extends JpaRepository<DutyHour, Long> {

}
