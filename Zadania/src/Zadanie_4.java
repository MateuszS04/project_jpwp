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
//
//    @RequiresRole("ADMIN")
//    public void deleteData() {
//        System.out.println("Data deleted");
//    }
//
//    @RequiresRole("USER_1")
//    public void viewData() {
//        System.out.println("Data viewed");
//    }
//}
//
//public class Zadanie_4 {
//    public static void main(String[] args) throws Exception {
//        User user = new User("Kasia", "USER_1");
//
//        SecureService service = new SecureService();
//
//        // TODO: Za pomocą refleksji wywołaj tylko te metody,
//        // do których użytkownik ma odpowiednią rolę
//    }
//}
