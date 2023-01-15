import java.time.LocalDate;

import static utils.DateFormater.dateFormat;

public class AccountOperations {

    private int operationAmount;
    private String operationDate;

    private boolean isCreditOperation;

    public AccountOperations(int amount, String operationDate, boolean isCreditOperation) {
        this.operationAmount = amount;
        this.operationDate = dateFormat(operationDate);
        this.isCreditOperation = isCreditOperation;
    }

    public String[] operationDetail() {
        String creditValue = isCreditOperation ? String.valueOf(operationAmount) : "";
        String debitValue = !isCreditOperation ? String.valueOf(operationAmount) : "";
        return new String[]{operationDate, creditValue, debitValue};
    }

    public int getOperationAmount() {
        return isCreditOperation ? operationAmount : Math.negateExact(operationAmount);
    }
}
