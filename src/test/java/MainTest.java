
import com.eaz.pipeline.jenkins.test.Main;
import static org.junit.Assert.*;
import org.junit.Test;

public class MainTest {

    @Test
    public void given_two_integers_when_calling_lambda_sum_then_return_result_is_the_sum_of_both_integers() {
        final Integer INTEGER_A = 8;
        final Integer INTEGER_B = 5;

        Integer iResult = Main.sum.apply(INTEGER_A, INTEGER_B);

        assertEquals(String.valueOf(INTEGER_A + INTEGER_B), iResult.toString());
    }
}
