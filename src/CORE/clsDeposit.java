package CORE;

public class clsDeposit {
    public static final double MAX_DEPOSIT_AMOUNT = 30000;

    public clsDeposit(String AccountNumber, double Amount) {
        Deposit(AccountNumber, Amount);
    }

    public static void Deposit(String AccountNumber, double Amount) {

        for (int i = 0; i < Bank.Client_List.size(); i++) {
            for (int j = 0; j < Bank.Client_List.get(i).Accounts.size(); j++) {
                if (Bank.Client_List.get(i).Accounts.get(j).GetAccount_Number().equals(AccountNumber)) {

                    Bank.Client_List.get(i).Accounts.get(j)
                            .SetAccount_Balance(Bank.Client_List.get(i).Accounts.get(j).GetAccount_Balance() + Amount);
                }
            }
        }
    }
}
