package CORE;

import FK_Lib.clsGlobal;

public class Employee extends Person {
    public static enum enMode {
        EMPTY, UPDATE, ADD_NEW
    };

    // Attributes
    private String Address;
    private String Position;
    private String Graduated_Collage;
    private String Year_Of_Graduation;
    private String Total_Grade;
    private enMode _Mode;

    // Contactor
    public Employee(String ID, String FirstName, String LastName, String Phone, String Username, String Password,
            enRule Rule, enMode Mode, String address, String position, String graduated_Collage,
            String year_Of_Graduation,
            String total_Grade) {
        super(ID, FirstName, LastName, Phone, Username, Password, Rule);
        Address = address;
        Position = position;
        Graduated_Collage = graduated_Collage;
        Year_Of_Graduation = year_Of_Graduation;
        Total_Grade = total_Grade;
        this._Mode = Mode;

    }

    // ===================================================================
    // Getters & Setter
    public String GetAddress() {
        return Address;
    }

    public String GetPosition() {
        return Position;
    }

    public String GetGraduated_Collage() {
        return Graduated_Collage;
    }

    public String GetYear_Of_Graduation() {
        return Year_Of_Graduation;
    }

    public String GetTotal_Grade() {
        return Total_Grade;
    }

    public static Employee _Get_Empty_Employee_Object() {
        // ID#//#FirstName#//#LastName#//#Phone#//#Username#//#Password#//#Rule#//#Address#//#Position#//#Graduated_Collage#//#YOG#//#Total_Grade
        return new Employee("", "", "", "", "", "", Person.enRule.EMPLOYEE, enMode.EMPTY, "", "", "", "", "0");
    }

    public static Employee _Get_Employee_To_Add() {
        // ID#//#FirstName#//#LastName#//#Phone#//#Username#//#Password#//#Rule#//#Address#//#Position#//#Graduated_Collage#//#YOG#//#Total_Grade
        return new Employee(clsGlobal.Generate_ID(), "", "", "", "", "", Person.enRule.EMPLOYEE, enMode.UPDATE, "", "",
                "", "", "0");
    }

    // ===================================================================
    public void SetAddress(String address) {
        Address = address;
    }

    public void SetPosition(String position) {
        Position = position;
    }

    public void SetGraduated_Collage(String graduated_Collage) {
        Graduated_Collage = graduated_Collage;
    }

    public void SetYear_Of_Graduation(String year_Of_Graduation) {
        Year_Of_Graduation = year_Of_Graduation;
    }

    public void SetTotal_Grade(String total_Grade) {
        Total_Grade = total_Grade;
    }

    // Class Main Methods

    public static Employee Find_By_Username(String Username) {
        for (Employee employee : Bank.Employee_List) {
            if (employee.GetUsername().equals(Username)) {
                return employee;
            }
        }
        for (Employee employee : Bank.Admins_List) {
            if (employee.GetUsername().equals(Username)) {
                return employee;
            }
        }
        return _Get_Empty_Employee_Object();
    }

    public static Employee Find_By_Fullname(String full_name) {

        for (Employee emp : Bank.Employee_List) {
            String FULLNAME = emp.GetFirstName() + " " + emp.GetLastName();
            if (full_name.equals(FULLNAME)) {
                return emp;
            }
        }
        return _Get_Empty_Employee_Object();
    }

    public static Employee Find(String FULL_NAME_OR_Username) {
        Employee Employee_To_Find;
        if (!((Employee_To_Find = Find_By_Fullname(FULL_NAME_OR_Username)).IsEmpty())) {
            return Employee_To_Find;
        } else if (!((Employee_To_Find = Find_By_Username(FULL_NAME_OR_Username)).IsEmpty())) {
            return Employee_To_Find;
        } else {
            return _Get_Empty_Employee_Object();
        }

    }

    @Override
    public boolean IsEmpty() {

        return _Mode == enMode.EMPTY;
    }

    public static boolean IsExist(String FULL_NAME_OR_Username) {

        return !Find(FULL_NAME_OR_Username).IsEmpty();
    }

    public static boolean IsExist_By_Username(String Username) {
        return !((Employee) Find_By_Username(Username)).IsEmpty();
    }

    @Override
    public boolean Delete() {

        return false;
    }

    @Override
    public boolean Save() {

        for (int i = 0; i < Bank.Employee_List.size(); i++) {
            if (Bank.Employee_List.get(i).GetID().equals(this.GetID())) {
                Bank.Employee_List.set(i, this);
                return true;
            }
        }
        Bank.Employee_List.add(this);
        return true;
    }

    @Override

    public String toString() {
        // ID#//#FirstName#//#LastName#//#Phone#//#Username#//#Password#//#Rule#//#Address#//#Position#//#Graduated_Collage#//#YOG#//#Total_Grade

        String[] Array = new String[12];
        Array[0] = this.GetID();
        Array[1] = this.GetFirstName();
        Array[2] = this.GetLastName();
        Array[3] = this.GetPhone();
        Array[4] = this.GetUsername();
        Array[5] = this.GetPassword();
        Array[6] = this.GetRule().toString();
        Array[7] = this.GetAddress();
        Array[8] = this.GetPosition();
        Array[9] = this.GetGraduated_Collage();
        Array[10] = this.GetYear_Of_Graduation();
        Array[11] = this.GetTotal_Grade();

        return String.join(Bank.FILE_DELIMITER, Array);
    }

}
