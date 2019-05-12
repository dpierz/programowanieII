public class TaskChangeNumber {
    public static void main(String[] args) { // często na rozmoawach o pracę, bez używania zmiennych pomocniczych
        int a = 5;
        int b = 8;
        System.out.println(a);
        System.out.println(b);

        a=a+b; //a=13, b=8;
        b=a-b; //a=13, b=5;
        a=a-b; //a=8, b=5;

        System.out.println(a);
        System.out.println(b);
    }
}
