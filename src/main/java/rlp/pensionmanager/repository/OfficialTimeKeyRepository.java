package rlp.pensionmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rlp.pensionmanager.model.OfficialTimeKey;

@Repository
public interface OfficialTimeKeyRepository extends JpaRepository<OfficialTimeKey, Long> {
}
