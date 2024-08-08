package glue;

import account.Account;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.mk_latn.No;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class AccountSteps {

    private Account account = null;

    @Given("^Account exists for Acc No\\. \"([^\"]*)\" with Name \"([^\"]*)\"$")
    public void accountExistsForAccNoWithName(String accNo, String accName) {
        //throw new PendingException();
        account = new Account(accNo, accName);
    }


    @And("deposits are made")
    public void depositsAreMade(List<Map<String, String>> deposits) {
            for (Map<String, String> deposit : deposits) {
                account.deposit(Double.parseDouble(deposit.get("Amount")));
            }
    }

    @And("withdrawls are made")
    public void withdrawlsAreMade(List<Map<String, String>> withdrawals) {
        for (Map<String, String> withdrawal : withdrawals) {
            account.withdraw(Double.parseDouble(withdrawal.get("Amount")));
        }
    }

    @When("statement is produced")
    public void statementIsProduced() {
        account.produceStatement();
    }

    @Then("statement includes {string}")
    public void statementIncludes(String text) {
        assertTrue(account.getStatement().contains(text));
    }
}
