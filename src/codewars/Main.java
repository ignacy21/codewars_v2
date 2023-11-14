package codewars;

public class Main {

    public static void main(String[] args) {

        String s = "0928913";
        System.out.println(s.substring(0));
        System.out.println(s.substring(1));
        System.out.println(s.substring(3));


        String s1 = "00123".replaceAll("^0+", "");
        System.out.println(s1);

    }
}
