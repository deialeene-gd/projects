class Student{
    String name;
    int age;
    String major;

    Student(){
        this("Unknown", 0, "Undeclared");
    }

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Student(String name, int age, String major) {
        this.name = name;
        this.age = age;
        this.major = major;
    }

    void displayInfo() {
        System.out.println("\nName : " + name + ", Age : " + age + ", Major : " + major);
    }
    
    public static void main(String[] args) { 
        Student s1 = new Student();
        Student s2 = new Student("Exactly", 17);
        Student s3 = new Student("Meridith", 19, "Web dev");
        
        s1.displayInfo();
        s2.displayInfo();
        s3.displayInfo();
    }
}