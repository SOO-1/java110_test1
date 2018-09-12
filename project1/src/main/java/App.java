import java.util.Scanner;

public class App {

    static class Members{

        private String name;
        private String address;
        private String id;

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getAddress() {
            return address;
        }
        public void setAddress(String address) {
            this.address = address;
        }
        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        
    }
    
    static class Students extends Members{
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
    
    static Students[] students = new Students[100];
    static Scanner keyIn = new Scanner(System.in);
    static int index = 0;

    public static void main(String[] args) {
        
        while(true) {
        String menu = promptmenu();
//        keyIn.nextLine();   //개행문자 없애기 , prompt에서 nextint로 받았을 경우
        
        if(menu.equals("1")){
            serviceStudentMenu();
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

            String todo = keyIn.nextLine();
            if(todo.equalsIgnoreCase("add")){
                inputStudents();
            }else if(todo.toLowerCase().equals("list")) {
                printStudents();
            }else if(todo.toLowerCase().equals("quit")) {
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
            Students s = new Students();
            
            System.out.print("이름: ");
            s.setName(keyIn.nextLine());
            
            System.out.print("주소: ");
            s.setAddress(keyIn.nextLine());
            
            System.out.print("학번: ");
            s.setId(keyIn.nextLine());
            
            System.out.println("최종학위: ");
            s.setSchool(keyIn.nextLine());
            
            System.out.println("전화번호: ");
            s.setTel(keyIn.nextLine());
            
            System.out.println("재직여부(true/false): ");
            s.setWorking(Boolean.parseBoolean(keyIn.nextLine()));
            
            students[index] = s;
            
            index++;
            
            System.out.println("계속 입력하시겠습니까? (y/n)");
            String yn = keyIn.nextLine();
            
            if(yn.toLowerCase().equals("n"))
                break;
            
        }
        
    }
    static void printStudents()
    {
        int count = 0;
        
        for(Students s : students)  //students는 배열
        {
            if(count++ == index) break;
            System.out.printf("%s, %s, %s, %s, %s, %b\n"
                    ,s.getName()
                    ,s.getAddress()
                    ,s.getId()
                    ,s.getSchool()
                    ,s.getTel()
                    ,s.isWorking());
        }
        
    }
    
    
}

