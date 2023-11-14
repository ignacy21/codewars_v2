package codewars;

public class BigNumbers {

    public static void main(String[] args) {
        String add = add("00921", "12345");
        System.out.println(add);
        String s = addPerfect("00921", "12345");
        System.out.println(s);
    }

    public static String addPerfect(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int x = 0;
        int i = 0;
        int n = Math.max(a.length(), b.length());
        while (i < n || x > 0) {
            if (i < a.length()) {
                x += a.charAt(a.length() - 1 - i) - '0';
            }
            if (i < b.length()) {
                x += b.charAt(b.length() - 1 - i) - '0';
            }
            sb.append(x % 10);
            x = x / 10;
            i++;
        }
        String f = sb.reverse().toString();
        return f.charAt(0) == '0' && f.length() > 1 ? f.substring(1) : f;
    }

    public static String add(String a, String b) {
        a = removeZerosInFront(a);
        b = removeZerosInFront(b);
        int length = Math.max(a.length(), b.length());
        String[] firsNumber = numberToStringArray(a, length);
        String[] secondNumber = numberToStringArray(b, length);

        String[] result = new String[length + 1];
        int additionalPlus = 0;
        for (int k = length - 1; k >= 0; k--) {
            int i1 = Integer.parseInt(firsNumber[k]);
            int i2 = Integer.parseInt(secondNumber[k]);
            int sum = i1 + i2 + additionalPlus;
            additionalPlus = 0;
            if (sum >= 10) {
                additionalPlus = 1;
                result[k + 1] = String.valueOf(sum - 10);
            } else {
                result[k + 1] = String.valueOf(sum);
            }
        }
        if (additionalPlus == 1) {
            result[0] = "1";
            return stringArrToString(result, 0);
        }
        return stringArrToString(result, 1);
    }

    private static String removeZerosInFront(String a) {
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != '0') {
                return a.substring(i);
            }
        }
        return a;
    }

    private static String stringArrToString(String[] strings, int index) {
        StringBuilder result = new StringBuilder();
        for (int i = index; i < strings.length; i++) {
            result.append(strings[i]);
        }
        return result.toString();
    }

    private static String[] numberToStringArray(String number, int length) {
        String[] strings = new String[length];
        int numLength = number.length();
        if (numLength < length) {
            for (int i = 0; i <= length - numLength; i++) {
                strings[i] = "0";
            }
            for (int k = length - numLength, i = 0; k < length; k++, i++) {
                strings[k] = String.valueOf(number.charAt(i));
            }
        } else {
            for (int i = 0; i < numLength; i++) {
                strings[i] = String.valueOf(number.charAt(i));
            }
        }
        return strings;
    }
}
