package APITests.ProductCRUD;
import APIActions.DelayedActions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

public class DelayedTest {

    @Test
    public void toCheckDelayedAsyncResponse() throws ExecutionException, InterruptedException {
        int expectedTotalSize = 12;
        int actualTotalSize = DelayedActions.getTotalSize();
        Assert.assertEquals(actualTotalSize, expectedTotalSize, "Total size does not match expected value");
    }

    @Test
    public void toCheckDelayedAsyncResponseWithAwaitility() {
        int expectedTotalSize = 12;
        int actualTotalSize = DelayedActions.getTotalSizeByAwaitility();
        Assert.assertEquals(actualTotalSize, expectedTotalSize, "Total size does not match expected value");
    }
}
