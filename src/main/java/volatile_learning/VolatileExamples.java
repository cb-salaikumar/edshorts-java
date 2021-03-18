package volatile_learning;

/**
 * A Simple Program to understand the usages of volatile in java
 */
public class VolatileExamples {

    /**
     * Learnings.
     *
     * --- Volatile is a simple way to avoid memory ordering and cache coherent issues
     * --- Variable marked as volatile is not cached at all,
     *  which escapes the possibility of entering into the trap :-)
     * --- How to replicate this scenario and write test cases? We cannot work under assumptions
     */

    /* Stores the Singleton Class instance*/
    private static volatile VolatileExamples volatileExamplesInstance;

    /**
     * Returns the volatile class instance
     * - ensures the concept of Singleton
     * @return VolatileExampleInstance
     */
    public  static VolatileExamples getInstance(){

        if ( volatileExamplesInstance != null ){
            return volatileExamplesInstance
        }

//        May I apply synchorinized lock like this..?
        synchronized (VolatileExamples.class){
            // Check again - Double-checking to avoid cache coherent issues
            if (volatileExamplesInstance == null){
                volatileExamplesInstance = new VolatileExamples();
            }
            return volatileExamplesInstance;
        }
    }
}
