package CORE;

public class clsWithdraw {
    public static final double MAX_WITHDRAW_AMOUNT = 40000;

    public clsWithdraw(String currentAccountNumber, double Amount) {
        withdraw(currentAccountNumber, Amount);
    }

    public static void withdraw(String AccountNumber, double Amount) {
        for (int i = 0; i < Bank.Client_List.size(); i++) {
            for (int j = 0; j < Bank.Client_List.get(i).Accounts.size(); j++) {
                if ((Bank.Client_List.get(i).Accounts.get(j).GetAccount_Number().equals(AccountNumber))) {
                    Bank.Client_List.get(i).Accounts.get(j).SetAccount_Balance(Bank.Client_List.get(i).Accounts.get(j).GetAccount_Balance() - Amount);
                }

            }

        }
    }

}