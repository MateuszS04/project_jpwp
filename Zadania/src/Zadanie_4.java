//import java.lang.annotation.*;
//import java.lang.reflect.*;
//
//@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.METHOD)
//-----------------
//// TODO: Zdefiniuj adnotację @RequiresRole z jednym polem: String value()
//
//class User_1 {
//    String name;
//    String role;
//
//    public User_1(String name, String role) {
//        this.name = name;
//        this.role = role;
//    }
//}
//
//class SecureService {
////TODO dodaj adnotację wymagającą bycia adminem aby wywołać funkcję deleteData()
//    ------------------
//    public void deleteData() {
//        System.out.println("Data deleted");
//    }
//// TODO dodaj adnotację wymagającą bycia użytkownikiem aby wywołać funkcję viewData()
//    -------------------
//    public void viewData() {
//        System.out.println("Data viewed");
//    }
//}
//
//public class Zadanie_4 {
//    public static void main(String[] args) throws Exception {
//        User_1 user_1 = new User_1("Kasia", "USER_1");
//
//        SecureService service = new SecureService();
//        // TODO: Za pomocą refleksji wywołaj tylko te metody,
//        // do których użytkownik ma odpowiednią rolę
//        for (--------------------------) {
//            if (---------------------------------) {
//                ------------------------------------------;
//                if (--------------------) {
//                    System.out.println("User has access to " + method.getName());
//                    method.invoke(service);
//                }else {
//                    System.out.println("User has no access to " + method.getName());
//                }
//            }
//        }
//    }
//}
//
