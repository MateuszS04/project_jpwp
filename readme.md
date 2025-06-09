

Zadania są uporządkowane od najprostszych do bardziej złożonych. 

---

## 🔧 Wymagania wstępne
- Java 8+
- Dowolne środowisko IDE (np. IntelliJ IDEA, Eclipse)
- Podstawowa znajomość Javy (OOP, klasy, metody)

---

## 📚 Zadania

### 🟢 Zadanie 1: Prosta własna adnotacja
**Cel**: Zdefiniuj własną adnotację `@Info` i zastosuj ją do klasy.

**Polecenie**:
- Utwórz adnotację `@Info` z polami `author` i `version`.
- Oznacz klasę `MyClass` tą adnotacją.
- W metodzie `main` wypisz zawartość adnotacji przy pomocy refleksji.

---

### 🟡 Zadanie 2: Wyszukiwanie metod z adnotacją
**Cel**: Użyj refleksji do wykrywania metod oznaczonych `@TestMethod`.

**Polecenie**:
- Zdefiniuj adnotację `@TestMethod`.
- Oznacz kilka metod w klasie `TestClass`.
- W `main` wypisz wszystkie nazwy metod oznaczonych tą adnotacją.

---

### 🟠 Zadanie 3: Automatyczne wywołanie oznaczonych metod
**Cel**: Refleksyjnie uruchamiaj metody oznaczone adnotacją `@AutoRun`.

**Polecenie**:
- Stwórz klasę z kilkoma metodami, z których część ma adnotację `@AutoRun`.
- W `main` wywołaj automatycznie wszystkie oznaczone metody refleksyjnie.

---

### 🔵 Zadanie 4: Prosty system ról z adnotacjami
**Cel**: Wprowadź system kontroli dostępu za pomocą adnotacji.

**Polecenie**:
- Zdefiniuj adnotację `@RequiresRole("ROLA")`.
- Stwórz klasę `User` z nazwą i rolą.
- Oznacz metody w klasie `SecureService` wymaganymi rolami.
- W `main` sprawdź, czy użytkownik ma dostęp do metody i ją wywołaj (lub odrzuć dostęp).
---
### 🔴 Zadanie 5 System zasobów i ról z użyciem dwóch adnotacji 
**Cel**: Zastosuj adnotację do oznaczenia metod oraz prosty sytem uprawnień użytkownika i typu
zasobów

**Polecenie**:
- Zdefiniuj dwie adnotacje `@ReguiresRole(String role)` i `@ResourceType(String type)`.
- Stwórz dwa interfejsy `SecuredResource` z metodą `access(User user)` i `DescribedResource` z metodą `describe()`.
- Zaimplementuj klasę `DocumentResource`, która implementuje oba interfejsy.
  Oznacz jej metody odpowiednimi adnotacjami.
- W klasie `ResourceAccessManager` Użyj refleksji, by odczytać:
- Wymaganą rolę z metody `access`.
- Typ zasobu z metody `describe`.