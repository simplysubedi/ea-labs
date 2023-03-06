package bank.repositories;

import bank.domain.TraceRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface TraceRecordRepository extends JpaRepository<TraceRecord,Integer> {
    @Transactional(value = Transactional.TxType.REQUIRES_NEW)
    TraceRecord save(TraceRecord traceRecord);
}
