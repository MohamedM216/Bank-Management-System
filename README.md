<h2>🏦 Bank Management System</h2>

Bank Management System is a Java-based console application developed by a faculty team project. The system provides essential banking operations with client and employee management, transaction tracking, and file-based data storage. The project follows a modular design, separating different features into screens and core modules to maintain clarity and scalability.

<h2>🌟 Features</h2>
<h3>🧑‍💼 User Management</h3>

    Clients:
        Sign up and log in functionalities.
        CRUD operations: Add, update, delete, and search for clients.
        Banking operations: Deposit, transfer, and withdraw funds.

    Employees:
        Sign up and log in functionalities.
        CRUD operations: Add, update, delete, and search for employees.

<h3>💸 Transaction Management</h3>

    Track transactions: View the transaction history (deposits, transfers, withdrawals).
    Login tracking: Maintain login history for both clients and employees.

<h3>📋 Menu and Screens</h3>

    Main Menu: Admin, Employee, and Client-specific menus for ease of navigation.
    Each functionality has its own screen to maintain a modular design.

<h3>📂 File-based Storage</h3>

    Data is persisted using files:
        BANK_FILE.txt – Stores all client banking details.
        LOGIN_FILE.txt – Records login details.
        TRANSACTIONS_FILE.txt – Logs all transactions.
        Logo.txt – Displays the application logo.

<h2>🛠️ Technologies Used</h2>

    Java – Programming language
    File Handling – Used for reading and writing data (simulating a database)
    VSCode – Development environment


Bank-Management-System/
│
├── .vscode/                  # VSCode settings
│   └── settings.json         
│
├── Files/                    # Data files for storing system data  
│   ├── BANK_FILE.txt         # Stores client banking data  
│   ├── LOGIN_FILE.txt        # Logs all login details  
│   ├── TRANSACTIONS_FILE.txt # Logs all transactions  
│   └── Logo.txt              # ASCII logo for the system
│
├── bin/                      # Compiled Java classes
│
├── src/                      # Source code files  
│   ├── CORE/                 # Core logic classes  
│   │   ├── Bank.java  
│   │   ├── Client.java  
│   │   ├── Employee.java  
│   │   ├── Person.java  
│   │   ├── clsAccount.java  
│   │   ├── clsDeposit.java  
│   │   ├── clsTransfer.java  
│   │   └── clsWithdraw.java  
│   │
│   ├── FK_Lib/               # Utility classes  
│   │   ├── clsGlobal.java  
│   │   ├── clsInput.java  
│   │   └── clsUtil.java  
│   │
│   ├── Screens/              # Screens for user interaction  
│   │   ├── ClientScreens/  
│   │   │   ├── clsAccountsListScreen.java  
│   │   │   ├── clsAddClientScreen.java  
│   │   │   ├── clsClientsListScreen.java  
│   │   │   ├── clsDeleteClientScreen.java  
│   │   │   ├── clsFindClientScreen.java  
│   │   │   └── clsUpdateClientScreen.java  
│   │   │
│   │   ├── EmployeeScreens/  
│   │   │   ├── clsAddEmployeeScreen.java  
│   │   │   ├── clsDeleteEmployeeScreen.java  
│   │   │   ├── clsEmployeeAccountScreen.java  
│   │   │   ├── clsEmployeesListScreen.java  
│   │   │   ├── clsFindEmployeeScreen.java  
│   │   │   └── clsUpdateEmployeeScreen.java  
│   │   │
│   │   ├── MainScreens/  
│   │   │   ├── Admin_Main_Menu_Screen.java  
│   │   │   ├── Client_Main_Menu_Screen.java  
│   │   │   ├── Employee_Main_Menu_Screen.java  
│   │   │   ├── Login_History_Screen.java  
│   │   │   ├── Login_Screen.java  
│   │   │   ├── Main_Screen.java  
│   │   │   ├── Manage_Employees_Menu_Screen.java  
│   │   │   └── Transactions_Main_Menu_Screen.java  
│   │
│   │   ├── Transactions/     # Screens for transactions  
│   │   │   ├── clsDepositScreen.java  
│   │   │   ├── clsTransactionsHistoryScreen.java  
│   │   │   ├── clsTransferScreen.java  
│   │   │   └── clsWithdrawScreen.java  
│   │
│   └── App.java              # Entry point of the application  
│
└── README.md                 # Documentation



<h2>🚀 Getting Started</h2>
Prerequisites

    Java JDK 8 or above
    VSCode (or any Java IDE)

Installation

    Clone the repository:
    git clone https://github.com/your-username/Bank-Management-System.git
cd Bank-Management-System

Open the project in VSCode or your preferred IDE.

Compile and run the application.

