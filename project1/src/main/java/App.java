import java.util.Scanner;


public class App {

    static class Member{

        private String name;
        private String email;
        private String password;
        

        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
        
    }
    
    static class Student extends Member{
        //name address id school tel working
        private String school;
        private boolean working;
        private String tel;
        
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
    
    static class Teacher extends Member{
        
        protected String tel;
        protected int pay;
        protected String subjects;
        public String getTel() {
            return tel;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }
        public int getPay() {
            return pay;
        }
        public void setPay(int pay) {
            this.pay = pay;
        }
        public String getSubjects() {
            return subjects;
        }
        public void setSubjects(String subjects) {
            this.subjects = subjects;
        }
        
        
    }
    
    static class Manager extends Member{
        protected String tel;
        protected String position;
        
        public String getTel() {
            return tel;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }
        public String getPosition() {
            return position;
        }
        public void setPosition(String position) {
            this.position = position;
        }
        
    }
    
    static Student[] students = new Student[100];
    static Teacher[] teachers = new Teacher[100];
    static Manager[] managers = new Manager[100];
    static Scanner keyIn = new Scanner(System.in);
    
    static int studentIndex = 0;
    static int teacherIndex = 0;
    static int managerIndex = 0;

    public static void main(String[] args) {
        
        while(true) {
        String menu = promptmenu();
//        keyIn.nextLine();   //개행문자 없애기 , prompt에서 nextint로 받았을 경우
        
        if(menu.equals("1")){
            serviceStudentMenu();
        }else if(menu.equals("2")){
            serviceTeacherMenu();
        }else if(menu.equals("3")){
            serviceManagerMenu();
        }else if(menu.equals("0")){
            System.out.println("안녕히가세요!");
            break;
        }else {
            System.out.println("유효하지 않은 번호입니다.");
        }
        
        }
        keyIn.close();  //while문에 break;안써주면 unreachable
       
    }

    private static String promptmenu()
    {
        System.out.println("[메뉴]");
        System.out.println("1. 학생 관리");
        System.out.println("2. 강사 관리");
        System.out.println("3. 매니저 관리");
        System.out.println("0. 종료");
        while(true)
        {

            System.out.print("메뉴 번호>");
            
            String menu = keyIn.nextLine();
            
            switch(menu) {
            case "1":
            case "2":
            case "3":
            case "0":
                return menu;
            default:
                System.out.println("유효하지 않은 번호입니다.");
            }
            
        }
        
    }
    
    private static void serviceStudentMenu()
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
    
    private static void serviceTeacherMenu() {
        
        while(true)
        {
            System.out.print("강사관리>");
            String command = keyIn.nextLine();
            
            if(command.equals("add")){
                inputTeachers();
            }else if(command.equals("list")) {
                printTeachers();
            }else if(command.equals("quit")) {
                break;
            }else {
                System.out.println("잘못입력하셨습니다.");
            }
            
            
        }
    }

    private static void serviceManagerMenu() {
        
        while(true) 
        {
            System.out.print("매니저관리> ");
            String command = keyIn.nextLine();
            
            if(command.equals("add")) {
                inputManagers();
            }else if(command.equals("list")) {
                printManagers();
            }else if(command.equals("quit")) {
                break;
            }else {
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

    private static void inputTeachers() {
        
        while(true) {
            
            Teacher t = new Teacher();
            
            System.out.print("이름? ");
            t.setName(keyIn.nextLine());
            
            System.out.print("이메일? ");
            t.setEmail(keyIn.nextLine());
            
            System.out.print("암호? ");
            t.setPassword(keyIn.nextLine());
            
            System.out.print("전화번호? ");
            t.setTel(keyIn.nextLine());
            
            System.out.print("시급? ");
            t.setPay(Integer.parseInt(keyIn.nextLine()));
            
            System.out.print("강의과목? (예 : 자바, C, C++) ");
            t.setSubjects(keyIn.nextLine());
      
            teachers[teacherIndex++] = t;
            
            System.out.print("계속 입력하시겠습니까? (y/n)");
            String yn = keyIn.nextLine();
            
            if(yn.equalsIgnoreCase("n")) {
                break;
            }
            
        }
    }

    static void inputManagers() {
        
        while(true)
        {
            Manager m = new Manager();
            
            System.out.print("이름? ");
            m.setName(keyIn.nextLine());
            
            System.out.print("이메일? ");
            m.setEmail(keyIn.nextLine());
        
            System.out.print("암호? ");
            m.setPassword(keyIn.nextLine());

            System.out.print("전화? ");
            m.setTel(keyIn.nextLine());

            System.out.print("직위? ");
            m.setPosition(keyIn.nextLine());
            
            managers[managerIndex++] = m;
            
            System.out.print("계속 하시겠습니까? (Y/n)"); 
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))    
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
    
    private static void printTeachers() {
        
        for(Teacher t : teachers) {
            if(t==null) break;
            System.out.printf("%s, %s, %s, %s, %d, %s\n"
                    ,t.getName()
                    ,t.getEmail()
                    ,t.getPassword()
                    ,t.getTel()
                    ,t.getPay()
                    ,t.getSubjects());
        }
        
    }

    private static void printManagers() {
        
        for(Manager m : managers) {
            if(m==null) break;
            System.out.printf("%s, %s, %s, %s, %s\n"
                    ,m.getName()
                    ,m.getEmail()
                    ,m.getPassword()
                    ,m.getTel()
                    ,m.getPosition());
        }
    }
   
    
}

