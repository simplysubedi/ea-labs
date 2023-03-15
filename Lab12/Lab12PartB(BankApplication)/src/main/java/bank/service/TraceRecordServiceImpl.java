package bank.service;

import bank.domain.TraceRecord;
import bank.repositories.TraceRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TraceRecordServiceImpl implements TraceRecordService{
    @Autowired
    private TraceRecordRepository traceRecordRepository;
    @Override
    public void addTrace(TraceRecord traceRecord) {
        traceRecordRepository.save(new TraceRecord(traceRecord.getAccountnumber(),traceRecord.getOperation(),traceRecord.getAmount(),traceRecord.getDate(),traceRecord.getTime()));
    }
}
