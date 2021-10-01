package test;

public class Test {

    private static boolean testMode = false;

    public Test() {
        testMode = true;
    }

    public static boolean isTestMode() {
        return testMode;
    }
}
