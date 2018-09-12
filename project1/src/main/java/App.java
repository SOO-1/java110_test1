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
    
    static Members[] members = new Members[100];
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
                Input();
            }else if(todo.toLowerCase().equals("list")) {
                Output();
            }else if(todo.toLowerCase().equals("quit")) {
                break;
            }else{
                System.out.println("잘못입력하셨습니다.");
            }
        }

    }
    
    private static void Input()
    {
        while(true)
        {
            Members m = new Members();
            
            System.out.print("이름: ");
            m.setName(keyIn.nextLine());
            
            System.out.print("주소: ");
            m.setAddress(keyIn.nextLine());
            
            System.out.print("학번: ");
            m.setId(keyIn.nextLine());
            
            members[index] = m;
            
            index++;
            
            System.out.println("계속 입력하시겠습니까? (y/n)");
            String yn = keyIn.nextLine();
            
            if(yn.toLowerCase().equals("n"))
                break;
            
        }
        
    }
    static void Output()
    {
        for(int i=0; i<index; i++)
            System.out.printf("%s, %s, %s\n", members[i].getName(), members[i].getAddress(), members[i].getId());
        
    }
    
    
}

