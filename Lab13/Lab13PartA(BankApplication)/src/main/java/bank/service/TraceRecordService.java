package bank.service;

import bank.domain.TraceRecord;
import org.springframework.stereotype.Service;


public interface TraceRecordService {

    public void addTrace(TraceRecord traceRecord);

}
