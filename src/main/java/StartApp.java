import static utils.PrimitiveFormater.amountOf;
import static utils.PrimitiveFormater.dateFormat;

public class StartApp {
    public static void main(String[] args) {
        Account account = new Account(new Person("1047286521"));

        account.deposit(amountOf(1000), dateFormat("10/01/2021"));
        account.deposit(amountOf(2000), dateFormat("13/01/2021"));
        account.withdraw(amountOf(500), dateFormat("14/01/2021"));

        account.printStatement();
    }
}
