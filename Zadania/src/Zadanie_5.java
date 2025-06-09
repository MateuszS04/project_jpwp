//import java.lang.annotation.*;
//import java.lang.reflect.*;
//
//@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.METHOD)
//-------------
//// TODO: Zdefiniuj adnotację @RequiresRole
//@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.METHOD)
//------------
//// TODO: Zdefiniuj adnotację @ResourceType
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
//interface SecuredResource {
//    void access(User user);
//}
//
//interface DescribedResource {
//    void describe();
//}
//
//class DocumentResource implements SecuredResource, DescribedResource {
//
//    @RequiresRole("EDITOR")
//    public void access(User user) {
//        System.out.println(user.name + " accessed the document.");
//    }
//
//    @ResourceType("DOCUMENT")
//    public void describe() {
//        System.out.println("This is a document resource.");
//    }
//}
//
//public class Zadanie_5 {
//    public static void main(String[] args) throws Exception {
//        User user = new User("Jan", "EDITOR");
//
//        DocumentResource resource = new DocumentResource();
//
//        Method accessMethod = DocumentResource.class.getMethod("access", User.class);
//        Method describeMethod = DocumentResource.class.getMethod("describe");
//
//        //  Odczytaj adnotacje RequiresRole i ResourceType
//        //  Sprawdź, czy użytkownik ma odpowiednią rolę
//        // Jeśli tak – wywołaj metodę access()
//        // Dodatkowo wypisz typ zasobu z describe()
//
//        // TODO: Poniżej zaimplementuj sprawdzenie typu zasobów
//        if(----------------------){
//            -------------------------------------;
//            System.out.println(rt.value());
//        }
//        // TODO: Poniżej sprawdź rolę użytkownika i porównaj ją z wymaganą rolą
//        if(-------------------------------){
//            -------------------------------;
//            String role = rr.value();
//
//            if(-----------------)){
//                --------------------;
//            }else{
//                System.out.println("Access denied"+user.name);
//            }
//        }
//
//    }
//}
