package CORE;

import java.util.ArrayList;
import java.util.Arrays;

import FK_Lib.clsGlobal;

public class Client extends Person {
    public static enum enMode {
        EMPTY, UPDATE, ADD_NEW
    };

    // Private Attributes
    private enMode _Mode;
    public ArrayList<clsAccount> Accounts = new ArrayList<>();

    // ----------------------------------------------------------------------------------------------------------------------------------------------
    // Constructors
    public Client(String ID, String FirstName, String LastName, String Phone, String Username, String Password,
            enRule Rule, enMode Mode, String AccountNumber, clsAccount.enAccountState State,
            clsAccount.enAccountType Type, double Balance) {
        super(ID, FirstName, LastName, Phone, Username, Password, Rule);

        this.Accounts.add(new clsAccount(AccountNumber, State, Type, Balance));

        this._Mode = Mode;
    }

    public Client(String ID, String FirstName, String LastName, String Phone, String Username, String Password,
            enRule Rule, enMode Mode, ArrayList<clsAccount> Accounts) {
        super(ID, FirstName, LastName, Phone, Username, Password, Rule);
        this._Mode = Mode;
        for (clsAccount Account : Accounts) {
            this.Accounts.add(Account);
        }

    }
    // public Client(Client Object, clsAccount Account) {
    // super(Object.GetID(), Object.GetFirstName(), Object.GetLastName(),
    // Object.GetPhone(), Object.GetUsername(),Object.GetPassword(),
    // Object.GetRule());
    // this.Accounts.add(Account);
    // }

    public static Client _Get_Empty_Client_Object() {
        // ID#//#FirstName#//#LastName#//#Phone#//#Username#//#Password#//#Rule#//#AccountNumber#//#State#//#Type#//#Balance
        return new Client("", "", "", "", "", "", Person.enRule.CLIENT, enMode.EMPTY, "", null, null, 0);
    }

    public static Client Get_Client_To_Add() {
        // ID#//#FirstName#//#LastName#//#Phone#//#Username#//#Password#//#Rule#//#AccountNumber#//#State#//#Type#//#Balance
        return new Client(clsGlobal.Generate_ID(), "", "", "", "", "", Person.enRule.CLIENT, enMode.UPDATE,
                clsGlobal.Generate_Account_Number(), null, null, 0);
    }
    // ----------------------------------------------------------------------------------------------------------------------------------------------
    // Class Public Methods

    public static Client Find(String FullName_Or_AccountNumber) {
        Client client;
        if (!(client = (Client) Client.Find_By_Account_Number(FullName_Or_AccountNumber)).IsEmpty()) {
            return client;
        } else if (!(client = (Client) Client.Find_By_Full_Name(FullName_Or_AccountNumber)).IsEmpty()) {
            return client;
        }
        return Client._Get_Empty_Client_Object();
    }

    public static Person Find_By_Full_Name(String FULL_NAME) {
        for (Client client : Bank.Client_List) {
            String FullName = client.GetFirstName() + " " + client.GetLastName();
            if (FullName.toUpperCase().trim().equals(FULL_NAME.toUpperCase().trim())) {
                return client;
            }
        }
        return Client._Get_Empty_Client_Object();
    }

    public static Person Find_By_Account_Number(String Account_Number) {
        for (Client client : Bank.Client_List) {
            for (int i = 0; i < client.Accounts.size(); i++) {
                if (client.Accounts.get(i).GetAccount_Number().equals(Account_Number)) {
                    return client;
                }
            }
        }
        return Client._Get_Empty_Client_Object();
    }

    public static Person Find_By_Username(String Username) {
        for (Client client : Bank.Client_List) {
            if (client.GetUsername().equals(Username)) {
                return client;
            }
        }
        return (Person) _Get_Empty_Client_Object();
    }

    public static boolean IsExist_By_Account_Number(String Account_Number) {
        return !Find_By_Account_Number(Account_Number).IsEmpty();
    }

    public static boolean IsExist_By_Full_Name(String Account_Number) {
        return !Find_By_Full_Name(Account_Number).IsEmpty();
    }

    public static boolean IsExist_By_Username(String Username) {
        return !((Client) Find_By_Username(Username)).IsEmpty();
    }

    public static boolean IsExist(String FullName_Or_AccountNumber) {
        return IsExist_By_Account_Number(FullName_Or_AccountNumber) || IsExist_By_Full_Name(FullName_Or_AccountNumber);
    }

    @Override
    public boolean IsEmpty() {

        return _Mode == enMode.EMPTY;
    }

    @Override
    public boolean Delete() {

        Set_Mark_For_Delete(true);
        this.Save();
        return true;
    }

    @Override
    public boolean Save() {

        for (int i = 0; i < Bank.Client_List.size(); i++) {
            if (this.GetID().equals(Bank.Client_List.get(i).GetID())) {
                Bank.Client_List.set(i, this);
                return true;
            }
        }
        Bank.Client_List.add(this);
        return true;
    }

    @Override
    public String toString() {
        String[] AccountsArray = new String[Accounts.size()];
        for (int i = 0; i < AccountsArray.length; i++) {
            AccountsArray[i] = String.join(Bank.Account_DELIMITER,
                    Arrays.asList(Accounts.get(i).GetAccount_Number(), Accounts.get(i).GetAccount_State().toString(),
                            Accounts.get(i).GetAccount_Type().toString(),
                            Double.toString(Accounts.get(i).GetAccount_Balance())));

        }
        // ID#//#FirstName#//#LastName#//#Phone#//#Username#//#Password#//#Rule#//#AccountNumber#//#State#//#Type#//#Balance
        String[] Array = new String[8];
        Array[0] = this.GetID();
        Array[1] = this.GetFirstName();
        Array[2] = this.GetLastName();
        Array[3] = this.GetPhone();
        Array[4] = this.GetUsername();
        Array[5] = this.GetPassword();
        Array[6] = this.GetRule().toString();
        Array[7] = String.join(Bank.Accounts_DELIMITER, AccountsArray);

        return String.join(Bank.FILE_DELIMITER, Array);
    }
}
