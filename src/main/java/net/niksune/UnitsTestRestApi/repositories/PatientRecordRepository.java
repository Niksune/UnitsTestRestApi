package net.niksune.UnitsTestRestApi.repositories;

import net.niksune.UnitsTestRestApi.entities.PatientRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRecordRepository extends JpaRepository<PatientRecord, Long> {}