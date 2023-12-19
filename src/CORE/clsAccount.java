package CORE;

public class clsAccount {

    public enum enAccountState {
        ACTIVE, CLOSED

    };

    public enum enAccountType {
        CURRENT, SAVING
    };

    private String Account_Number;
    private enAccountState Account_State;
    private enAccountType Account_Type;
    private double Account_Balance;

    public clsAccount(String account_Number, enAccountState account_State, enAccountType account_Type,
            double account_Balance) {
        this.Account_Number = account_Number;
        this.Account_State = account_State;
        this.Account_Type = account_Type;
        this.Account_Balance = account_Balance;

    }

    public String GetAccount_Number() {
        return Account_Number;

    }

    public enAccountState GetAccount_State() {
        return Account_State;
    }

    public void SetAccount_State(enAccountState account_State) {
        Account_State = account_State;
    }

    public enAccountType GetAccount_Type() {
        return Account_Type;
    }

    public void SetAccount_Type(enAccountType account_Type) {
        Account_Type = account_Type;
    }

    public double GetAccount_Balance() {
        return Account_Balance;
    }

    public void SetAccount_Balance(double account_Balance) {
        switch (Account_Type) {
            case CURRENT: {
                if (account_Balance < 3000) {

                    Account_Balance = account_Balance - (account_Balance * 0.03);
                } else {
                    Account_Balance = account_Balance;
                }
            }
                break;
            case SAVING: {
                Account_Balance = account_Balance;
            }
                break;

        }

    }
}
