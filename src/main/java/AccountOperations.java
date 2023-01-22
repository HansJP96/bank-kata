import java.util.HashMap;

import static utils.BalanceSummaryHeaders.*;

public class AccountOperations {

    private final int operationAmount;
    private final String operationDate;
    private final int previousAccountBalance;
    private final boolean isCreditOperation;

    public AccountOperations(int amount, String operationDate, int amountBalance, boolean isCreditOperation) {
        this.operationAmount = amount;
        this.operationDate = operationDate;
        this.previousAccountBalance = amountBalance;
        this.isCreditOperation = isCreditOperation;
    }

    public HashMap<String, String> operationDetail() {
        HashMap<String, String> operationData = new HashMap<>();
        operationData.put(DATE.toString(), this.operationDate);
        operationData.put(amountType(), Integer.toString(this.operationAmount));
        operationData.put(BALANCE.toString(), newAccountBalance());
        return operationData;
    }

    private String amountType() {
        return isCreditOperation ? CREDIT.toString() : DEBIT.toString();
    }

    private String newAccountBalance() {
        return Integer.toString(previousAccountBalance + getOperationAmount());
    }

    public int getOperationAmount() {
        return isCreditOperation ? operationAmount : Math.negateExact(operationAmount);
    }
}
