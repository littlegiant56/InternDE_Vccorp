public class UncheckedExceptionExample2 {
    public static void main(String[] args) {
        String str = null;
        if (str != null) {
            System.out.println(str.length());
        } else {
            System.out.println("String is null");
        }
    }
}
