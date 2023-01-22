import utils.BalanceSummaryHeaders;
import utils.PrintTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static utils.EnumTransformer.arrayEnumValues;

public class Account {

    private final String[] accountSummaryTable = arrayEnumValues(BalanceSummaryHeaders.class);
    private final Person accountPerson;
    private int accountBalance = 0;
    private final List<AccountOperations> accountOperations = new ArrayList<>();

    public Account(Person person) {
        this.accountPerson = person;
    }

    public void deposit(int amount, String operationDate) {
        AccountOperations accountOperation =
                new AccountOperations(amount, operationDate, getAccountBalance(), true);
        accountOperations.add(accountOperation);
        updateBalance(accountOperation);
    }

    public void withdraw(int amount, String operationDate) {
        AccountOperations accountOperation =
                new AccountOperations(amount, operationDate, getAccountBalance(), false);
        accountOperations.add(accountOperation);
        updateBalance(accountOperation);
    }

    public void printStatement() {
        PrintTable printTable = new PrintTable(accountSummaryTable, operations());
        System.out.println(accountPerson);
        printTable.showTable();
    }

    private List<HashMap<String, String>> operations() {
        List<HashMap<String, String>> listOperationData = new ArrayList<>();
        for (AccountOperations operations : accountOperations) {
            listOperationData.add(operations.operationDetail());
        }
        return listOperationData;
    }

    public void updateBalance(AccountOperations accountOperation) {
        this.accountBalance = this.accountBalance + accountOperation.getOperationAmount();
    }

    public int getAccountBalance() {
        return accountBalance;
    }
}
