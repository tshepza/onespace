package com.onespace.conversion;

import com.onespace.MessageServiceProcessor;
import com.onespace.conversion.data.TestInput;
import org.junit.Test;

public class MessageServiceProcessorTest {


    @Test
    public void testWithInValidInput() {
        System.out.println("======================INVALID INPUT TEST====================");
        //new MessageServiceProcessor().process(TestInput.TEST_INVALID_INPUT);
    }

    @Test
    public void testWithValidInput() {
        System.out.println("======================VALID INPUT TEST====================");
        new MessageServiceProcessor().process(TestInput.TEST_INPUT);
    }

}
