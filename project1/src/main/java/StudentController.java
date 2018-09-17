import java.util.Scanner;

public class StudentController{
   
    static Scanner keyIn = new Scanner(System.in);
    static Student[] students = new Student[100];
    static int studentIndex = 0;
    
    static class Student extends Member{

        protected String school;
        protected boolean working;
        protected String tel;

        public String getSchool() {
            return school;
        }
        public void setSchool(String school) {
            this.school = school;
        }
        public String getTel() {
            return tel;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }
        public boolean isWorking() {
            return working;
        }
        public void setWorking(boolean working) {
            this.working = working;
        }

    }
    public static void serviceStudentMenu()
    {
        while(true) {
            System.out.print("학생관리> ");

            String command = keyIn.nextLine();
            if(command.equalsIgnoreCase("add")){
                inputStudents();
            }else if(command.toLowerCase().equals("list")) {
                printStudents();
            }else if(command.toLowerCase().equals("quit")) {
                break;
            }else{
                System.out.println("잘못입력하셨습니다.");
            }
        }

    }

    
    private static void inputStudents()
    {//name address id school tel working 
        while(true)
        {
            Student s = new Student();
            
            System.out.print("이름? ");
            s.setName(keyIn.nextLine());
            
            System.out.print("이메일? ");
            s.setEmail(keyIn.nextLine());
            
            System.out.print("암호? ");
            s.setPassword(keyIn.nextLine());
            
            System.out.print("최종학력? ");
            s.setSchool(keyIn.nextLine());
            
            System.out.print("재직여부? (true/false): ");
            s.setWorking(Boolean.parseBoolean(keyIn.nextLine()));
            
            System.out.print("전화? ");
            s.setTel(keyIn.nextLine());
            
            students[studentIndex] = s;
            
            studentIndex++;
            
            System.out.print("계속 입력하시겠습니까? (y/n)");
            String yn = keyIn.nextLine();
            
            if(yn.equalsIgnoreCase("n"))
                break;
            
        }
        
    }
    
    static void printStudents()
    {
        int count = 0;
        
        for(Student s : students)  //students는 배열
        {
            if(count++ == studentIndex) break;
            System.out.printf("%s, %s, %s, %s, %s, %b\n"
                    ,s.getName()
                    ,s.getEmail()
                    ,s.getPassword()
                    ,s.getSchool()
                    ,s.isWorking()
                    ,s.getTel());
        }
        
    }
    
    
}
