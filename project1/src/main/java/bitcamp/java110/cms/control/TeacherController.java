package bitcamp.java110.cms.control;
import java.util.Scanner;

import bitcamp.java110.cms.domain.Member;

public class TeacherController extends Member {

    static Scanner keyIn = new Scanner(System.in);
    static Teacher[] teachers = new Teacher[100];
    static int teacherIndex = 0;

    
    static class Teacher extends Member{

        protected int pay;
        protected String subjects;

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
    public static void serviceTeacherMenu() {
        
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

}
