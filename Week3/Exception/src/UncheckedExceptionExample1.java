public class UncheckedExceptionExample1 {
    public static void main(String[] args) {
        String str = null;
        try {
            // Gây ra NullPointerException vì str là null
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: " + e.getMessage());
        }
    }
}
