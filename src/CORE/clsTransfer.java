package CORE;

public class clsTransfer {
    public static final double MAX_TRANSFER_AMOUNT = 60000;

    public static void Transfer(String Account_From, String Account_To, double Amount) {
        if (!Account_To.isEmpty()) {
            clsDeposit.Deposit(Account_To, Amount);
            clsWithdraw.withdraw(Account_From, Amount);
            System.out.println(Amount + " Transferred Successfully From " + Account_From + " To " + Account_To);
        }
    }
}