package com.github.objectpool;



/**
 * <p>Main.</p>
 *
 * @author anavarro - Mar 22, 2015
 *
 */
public class Main {

    
    /**
     * Constructor.
     *
     */
    public Main() {

    }
    
    
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long count = 0;
        for (int i = 0; i < 100000; i++) {
            count += SeriesHelper.retrieve(i % 10000).length();
        }
        long stop = System.currentTimeMillis();
        System.out.println("count=" + count + " in " + (stop - start));     
        
        //count=2394006050 in 23819
        
        //new LinkedBlockingQueue<String>
        
        //SeriesHelper.POOL_SEETINGS.shutdown();

    }

}
