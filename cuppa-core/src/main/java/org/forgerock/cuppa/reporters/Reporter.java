package org.forgerock.cuppa.reporters;

import org.forgerock.cuppa.model.Hook;
import org.forgerock.cuppa.model.Test;
import org.forgerock.cuppa.model.TestBlock;

/**
 * A strategy for reporting on a suite of test runs.
 */
public interface Reporter {

    /**
     * Called before suite is run.
     */
    void start();

    /**
     * Called after suite run has completed.
     */
    void end();

    /**
     * Called before any tests are run in a describe block.
     *
     * @param testBlock The test block.
     */
    void describeStart(TestBlock testBlock);

    /**
     * Called after all tests, in a describe block, have completed.
     *
     * @param testBlock The test block.
     */
    void describeEnd(TestBlock testBlock);

    /**
     * Called after a hook due to it throwing an exception.
     *
     * @param hook The hook that threw an exception.
     * @param cause The throwable that the hook threw.
     */
    void hookError(Hook hook, Throwable cause);

    /**
     * Called after a test has successfully executed without throwing an exception.
     *
     * @param test The test that passed.
     */
    void testPass(Test test);

    /**
     * Called after a test has failed due to throwing a assertion error.
     *
     * @param test The test that failed.
     * @param cause The assertion error that the test threw.
     */
    void testFail(Test test, AssertionError cause);

    /**
     * Called after a test has failed due to throwing an exception that wasn't an assertion error.
     *
     * @param test The test that threw an exception.
     * @param cause The throwable that the test threw.
     */
    void testError(Test test, Throwable cause);

    /**
     * Called when a test cannot be run as it has not yet been implemented.
     *
     * @param test The pending test.
     */
    void testPending(Test test);

    /**
     * Called when a test has been skipped.
     *
     * @param test The skipped test.
     */
    void testSkip(Test test);
}