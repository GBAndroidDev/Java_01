public class Stroki {
    public static void main(String[] args) {
        String s = "Предложение  один     Теперь предложение    два   Предложение   три";
        String s1 = s.replaceAll(" +", " ");
        StringBuilder s2 = new StringBuilder(s1);

        for (int i = 0; i < s2.length(); i++) {
            if (Character.isUpperCase(s2.charAt(i)) && (i > 0)) {
                s2.insert(i - 1, ".");
                i += 2;
            }
            if (!Character.isUpperCase(s2.charAt('.')) && (i == s2.length() - 1)) {
                s2.insert(i + 1, ".");
                break;
            }

        }

        System.out.println(s2.toString());
    }
}
