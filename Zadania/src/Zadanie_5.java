//// TODO: Zdefiniuj dwie adnotacje:
//// @Endpoint(path = "...") – ścieżka endpointa
//// @RequiresRole("...") – wymagana rola użytkownika
//
//class User {
//    String name;
//    String role;
//    public User(String name, String role) {
//        this.name = name;
//        this.role = role;
//    }
//}
//
//class ApiService {
//
//    @Endpoint(path = "getData")
//    @RequiresRole("USER")
//    public void getData() {
//        System.out.println("Data retrieved.");
//    }
//
//    @Endpoint(path = "deleteData")
//    @RequiresRole("ADMIN")
//    public void deleteData() {
//        System.out.println("Data deleted.");
//    }
//}
//
//public class Zadanie_5 {
//    public static void route(User user, String path) throws Exception {
//        ApiService api = new ApiService();
//
//        // TODO: Użyj refleksji, aby:
//        // - Znaleźć metodę z pasującą ścieżką @Endpoint
//        // - Sprawdzić @RequiresRole i porównać z rolą użytkownika
//        // - Jeśli wszystko się zgadza, wywołać metodę
//        // - W przeciwnym razie wypisać odpowiedni komunikat
//    }
//
//    public static void main(String[] args) throws Exception {
//        User user = new User("Ania", "USER");
//
//        route(user, "getData");    // powinno działać
//        route(user, "deleteData"); // powinno być zabronione
//    }
//}
