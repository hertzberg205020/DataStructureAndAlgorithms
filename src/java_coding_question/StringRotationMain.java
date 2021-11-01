package java_coding_question;

/*
    Example:
    java2blog and blogjava2 are rotation of each other.
    java2blog and avablog2j are not rotation of each other.
 */
public class StringRotationMain {
    public static boolean isRotation(String str1, String str2) {
        String str3 = str1 + str1;
        if(str3.contains(str2)) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {

        System.out.println(
                "java2blog and blogjava2 are rotation of each other : " + isRotation("java2blog", "blogjava2"));
        System.out.println(
                "java2blog and avablog2j are rotation of each other : " + isRotation("java2blog", "avablog2j"));

    }
}
