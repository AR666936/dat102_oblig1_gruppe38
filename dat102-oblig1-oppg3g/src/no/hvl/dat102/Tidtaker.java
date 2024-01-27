package no.hvl.dat102;

public class Tidtaker {
	private static boolean tarTiden = false;
    private static long startTid;

    public static void main(String[] args) {


    	currentTimeMillis();
    	tid(10_000_000L);
        System.out.println(currentTimeMillis());currentTimeMillis();
    	tid(100_000_000L);
        System.out.println(currentTimeMillis());currentTimeMillis();
    	tid(1_000_000_000L);
        System.out.println(currentTimeMillis());
    	
    }
    public static void tid(long n) {
		long k = 0;
		for (long i = 1; i <= n; i++) {
			k = k + 5;
		}
	}
    public static long currentTimeMillis() {
        long currentTime = System.currentTimeMillis();

        if (!tarTiden) {
            startTid = currentTime;
            tarTiden = true;
        } else {
            tarTiden = false;
            return currentTime - startTid;
        }
        return 0;
    }
}
