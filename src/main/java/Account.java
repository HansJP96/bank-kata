import dnl.utils.text.table.TextTable;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Account {

    private final Person accountPerson;
    private int accountBalance = 0;
    private final List<AccountOperations> accountOperations = new ArrayList<>();

    public Account(Person person) {
        this.accountPerson = person;
    }

    public void deposit(int amount, String operationDate) {
        AccountOperations accountOperation = new AccountOperations(amount, operationDate, true);
        accountOperations.add(accountOperation);
    }

    public void withdraw(int amount, String operationDate) {
        AccountOperations accountOperation = new AccountOperations(amount, operationDate, false);
        accountOperations.add(accountOperation);
    }

    public void printStatements() {
        String[] headerNames = {"Date", "Credit", "Debit", "Balance"};
        int sucessfulOperations = accountOperations.size();
        int numberHeader = headerNames.length;
        Object[][] dataTable = fitDataTable(sucessfulOperations, numberHeader);
        TextTable textTable = new TextTable(headerNames, dataTable);
        tableFormat(textTable);
        System.out.println(accountPerson);
        textTable.printTable();
    }

    private Object[][] fitDataTable(int amountOperations, int numberHeader){
        Object[][] operations = new Object[amountOperations][numberHeader];
        int counter = 0;
        for (AccountOperations operation : accountOperations) {
            this.accountBalance = accountBalance + operation.getOperationAmount();
            operations[counter] = addOperationBalance(operation, numberHeader);
            counter++;
        }
        return operations;
    }

    private String[] addOperationBalance(AccountOperations operation, int numberHeader) {
        String[] operationDetails = operation.operationDetail();
        operationDetails = Arrays.copyOf(operationDetails, numberHeader);
        operationDetails[numberHeader -1] = String.valueOf(accountBalance);
        return operationDetails;
    }
    private void tableFormat(TextTable textTable){
        textTable.setSort(0, SortOrder.DESCENDING);
    }
}
