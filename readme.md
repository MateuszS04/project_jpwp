

Zadania są uporządkowane od najprostszych do bardziej złożonych. 

---

## 🔧 Wymagania wstępne
- Java 8+
- Dowolne środowisko IDE (np. IntelliJ IDEA, Eclipse)
- Podstawowa znajomość Javy (OOP, klasy, metody)

---

## 📚 Zadania

### 🟢 Zadanie 1: Prosta własna adnotacja
**Poziom**: Łatwy
**Cel**: Zdefiniuj własną adnotację `@Info` i zastosuj ją do klasy.

**Polecenie**:
- Utwórz adnotację `@Info` z polami `author` i `version`.
- Oznacz klasę `MyClass` tą adnotacją.
- W metodzie `main` wypisz zawartość adnotacji przy pomocy refleksji.

---

### 🟡 Zadanie 2: Wyszukiwanie metod z adnotacją
**Poziom**: Łatwy–Średni   
**Cel**: Użyj refleksji do wykrywania metod oznaczonych `@TestMethod`.

**Polecenie**:
- Zdefiniuj adnotację `@TestMethod`.
- Oznacz kilka metod w klasie `TestClass`.
- W `main` wypisz wszystkie nazwy metod oznaczonych tą adnotacją.

---

### 🟠 Zadanie 3: Automatyczne wywołanie oznaczonych metod
**Poziom**: Średni   
**Cel**: Refleksyjnie uruchamiaj metody oznaczone adnotacją `@AutoRun`.

**Polecenie**:
- Stwórz klasę z kilkoma metodami, z których część ma adnotację `@AutoRun`.
- W `main` wywołaj automatycznie wszystkie oznaczone metody refleksyjnie.

---

### 🔵 Zadanie 4: Prosty system ról z adnotacjami
**Poziom**: Średni–Trudny
**Cel**: Wprowadź system kontroli dostępu za pomocą adnotacji.

**Polecenie**:
- Zdefiniuj adnotację `@RequiresRole("ROLA")`.
- Stwórz klasę `User` z nazwą i rolą.
- Oznacz metody w klasie `SecureService` wymaganymi rolami.
- W `main` sprawdź, czy użytkownik ma dostęp do metody i ją wywołaj (lub odrzuć dostęp).

---

### 🔴 Zadanie 5: Dynamiczny router API z kontrolą dostępu
**Poziom**: Trudny   
**Cel**: Stwórz router API, który na podstawie adnotacji i roli użytkownika znajduje i uruchamia metodę.

**Polecenie**:
- Zdefiniuj dwie adnotacje:
    - `@Endpoint(path = "...")` – określa nazwę ścieżki.
    - `@RequiresRole("ROLA")` – określa wymaganą rolę użytkownika.
- Stwórz klasę `ApiService` z kilkoma metodami oznaczonymi tymi adnotacjami.
- W klasie `ApiRouter`:
    - Znajdź metodę pasującą do ścieżki.
    - Sprawdź, czy użytkownik ma odpowiednią rolę.
    - Jeśli tak – wywołaj metodę. W przeciwnym razie wypisz komunikat o błędzie.

---

## ✅ Cele edukacyjne
- Rozumienie, czym są i jak działają adnotacje w Javie
- Praktyczne zastosowanie refleksji
- Wstęp do metaprogramowania
- Implementacja prostych systemów bezpieczeństwa

---

## 📁 Struktura katalogów
