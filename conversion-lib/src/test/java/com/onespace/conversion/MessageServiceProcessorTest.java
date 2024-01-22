package com.onespace.conversion;

import com.onespace.MessageServiceProcessor;
import com.onespace.conversion.data.TestInput;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class MessageServiceProcessorTest {



    @Test
    public void testWithValidInput() {
        log.info("======================VALID INPUT TEST====================");
        new MessageServiceProcessor().process(TestInput.TEST_INPUT);
    }

    @Test
    public void testWithInValidInput() {
        log.info("======================INVALID INPUT TEST====================");
        //new MessageServiceProcessor().process(TestInput.TEST_INVALID_INPUT);
    }


}
