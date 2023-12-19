package CORE;

public abstract class Person {
    // Attributes
    public enum enRule {
        ADMIN, EMPLOYEE, CLIENT
    }

    private String ID;
    private String FirstName;
    private String LastName;
    private String Phone;
    private String Username;
    private String Password;
    private boolean Mark_For_Delete = false;
    private enRule Rule;

    // -------------------------------
    // Contactor
    public Person(String ID, String FirstName, String LastName, String Phone, String Username, String Password,
            enRule Rule) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Phone = Phone;
        this.Username = Username;
        this.Password = Password;
        this.ID = ID;
        this.Rule = Rule;
    }

    // Get Methods
    public String GetFirstName() {
        return FirstName;
    }

    public String GetLastName() {
        return LastName;
    }

    public String GetPhone() {
        return Phone;
    }

    public String GetUsername() {
        return Username;
    }

    public String GetPassword() {
        return Password;
    }

    public String GetID() {
        return ID;
    }

    public enRule GetRule() {
        return Rule;
    }

    public boolean Is_Mark_For_Deleted() {
        return Mark_For_Delete;
    }

    // Set Methods
    public void SetFirstName(String firstName) {
        FirstName = firstName;
    }

    public void SetLastName(String lastName) {
        LastName = lastName;
    }

    public void SetPhone(String phone) {
        Phone = phone;
    }

    public void SetUsername(String username) {
        Username = username;
    }

    public void SetPassword(String password) {
        Password = password;
    }

    public void SetID(String ID) {
        this.ID = ID;
    }

    public void SetRule(enRule rule) {
        Rule = rule;
    }

    public void Set_Mark_For_Delete(boolean mark_For_Delete) {
        this.Mark_For_Delete = mark_For_Delete;
    }

    // Class Basic Methods
    public abstract boolean Save();

    public abstract boolean Delete();

    public abstract boolean IsEmpty();

}