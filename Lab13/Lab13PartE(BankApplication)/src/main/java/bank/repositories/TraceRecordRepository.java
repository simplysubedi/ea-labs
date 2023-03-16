package bank.repositories;

import bank.domain.Account;
import bank.domain.TraceRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraceRecordRepository extends JpaRepository<TraceRecord,Integer> {
}
