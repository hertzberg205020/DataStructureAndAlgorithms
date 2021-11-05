package substring_match;

public class SubstringMatchHelper {
    private SubstringMatchHelper() {}

    public static void matchTest(String name, String src, String target) {
        int pos = -1;
        long startTime = System.nanoTime();
        if(name.equals("bruteforce")) {
            pos = SubstringMatch.bruteforce(src, target);
        } else if(name.equals("rk")) {
            pos = SubstringMatch.rabinKarp(src, target);
        }
        long endTime = System.nanoTime();
        double time = (endTime - startTime) /1000000000.0;

        //使用java提供的api檢查是否正確
        if(src.indexOf(target) != pos) {
            throw new RuntimeException(name + " failed.");
        }
        System.out.println(String.format("%s : res = %d, time = %f sec.", name, pos, time));
    }
}
