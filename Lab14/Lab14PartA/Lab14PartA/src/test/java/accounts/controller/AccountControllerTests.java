package accounts.controller;

import accounts.service.AccountDTO;
import accounts.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)

public class AccountControllerTests {

    @Autowired
    MockMvc mock;

    @MockBean
    AccountService accountService;
    @Test
    public void testGetAccount() throws  Exception{
        Mockito.when(accountService.getAccount("465566")).thenReturn(new AccountDTO("465566",56213,"Frank D Brown"));
        mock.perform(get("/account/465566"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.accountNumber").value(465566))
                .andExpect(MockMvcResultMatchers.jsonPath("$.balance").value(56213))
                .andExpect(MockMvcResultMatchers.jsonPath("$.accountHolder").value("Frank D Brown"));

    }

    @Test
    public void testCreateAccount() throws  Exception{
        String accountNumber = "465566";
        double amount = 56213;
        String accountHolder = "Frank D Brown";
        mock.perform(get("/createaccount/"+accountNumber+"/"+amount+"/"+accountHolder))
                .andExpect(status().isOk());
    }
}