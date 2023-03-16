package bank.event;

import bank.domain.TraceRecord;
import bank.service.TraceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalTime;

@Service
@EnableAsync
public class ListenerForAccountActions {
    @Autowired
    private TraceRecordService traceRecordService;

    @Async
    @EventListener(AccountEvent.class)
    public void onEvent(AccountEvent event) {
        TraceRecord tr = new TraceRecord(
                event.getAccountnumber(), event.getOperation(), event.getAmount(), LocalDate.now(), LocalTime.now()
        );
        traceRecordService.addTrace(tr);
    }

    @Async
    @EventListener(MailEvent.class)
    public void onMailEvent(MailEvent event) {
        System.out.println("Sending email to abc.....");
    }

}
