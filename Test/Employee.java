public class Employee {
    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void displayEmployeeInfo() {
        System.out.println("Name: " + name + ", Salary: " + salary);
    }
}


class Manager extends Employee {
    private int teamSize;

    public Manager(String name, double salary, int teamSize) {
        super(name, salary);  
        this.teamSize = teamSize;
    }

    // @Override
    public void displayEmployeeInfo() {
        System.out.println("Name: " + name + ", Salary: " + salary + ", Team Size: " + teamSize);
    }
}


class Developer extends Employee {
    private String programmingLanguage;

    public Developer(String name, double salary, String programmingLanguage) {
        super(name, salary);
        this.programmingLanguage = programmingLanguage;
    }


    // @Override
    public void displayEmployeeInfo() {
        System.out.println("Name: " + name + ", Salary: " + salary + ", Programming Language: " + programmingLanguage);
    }
    public static void main(String[] args) {
        Manager manager = new Manager("Mike", 80000, 10);
        Developer developer = new Developer("Sarah", 70000, "Java");
    
        manager.displayEmployeeInfo();
        developer.displayEmployeeInfo();
    }
}







// Main class with main method
//public class Main {
// }
// public class Employee {
//     // Fields for employee name and salary
//     protected String name;
//     protected double salary;

//     // Constructor for Employee
//     public Employee(String name, double salary) {
//         this.name = name;
//         this.salary = salary;
//     }

//     // Method to display employee information
//     public void displayEmployeeInfo() {
//         System.out.println("Name: " + name + ", Salary: " + salary);
//     }
// }

// // Subclass Manager
// class Manager extends Employee {
//     // Additional field for Manager: teamSize
//     private int teamSize;

//     // Constructor for Manager
//     public Manager(String name, double salary, int teamSize) {
//         super(name, salary);  // Call to Employee constructor
//         this.teamSize = teamSize;
//     }

//     // Override displayEmployeeInfo method to include teamSize
//     @Override
//     public void displayEmployeeInfo() {
//         System.out.println("Name: " + name + ", Salary: " + salary + ", Team Size: " + teamSize);
//     }
// }

// // Subclass Developer
// class Developer extends Employee {
//     // Additional field for Developer: programmingLanguage
//     private String programmingLanguage;

//     // Constructor for Developer
//     public Developer(String name, double salary, String programmingLanguage) {
//         super(name, salary);  // Call to Employee constructor
//         this.programmingLanguage = programmingLanguage;
//     }

//     // Override displayEmployeeInfo method to include programmingLanguage
//     @Override
//     public void displayEmployeeInfo() {
//         System.out.println("Name: " + name + ", Salary: " + salary + ", Programming Language: " + programmingLanguage);
//     }
//     public static void main(String[] args) {
//         // Create Manager object
//         Manager manager = new Manager("Mike", 80000, 10);
//         // Create Developer object
//         Developer developer = new Developer("Sarah", 70000, "Java");
    
//         // Display information of Manager and Developer
//         manager.displayEmployeeInfo();
//         developer.displayEmployeeInfo();
//     }
// }

// // Main class with main method
// //public class Main {
// // }