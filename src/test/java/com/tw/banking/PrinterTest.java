package com.tw.banking;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static com.tw.banking.Printer.SEPARATOR;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PrinterTest {

    @Test
    void should_return_correct_value_when_execute_print() throws IOException {
        //given
        Console console = new Console();
        List<Transaction> transactions = Arrays.asList(new Transaction("15/06/2021", 200), new Transaction("15/06/2021", -100));
        Printer printer = new Printer(console);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(byteArrayOutputStream));

        //when
        printer.print(transactions);
        byteArrayOutputStream.flush();

        //then
        String allWrittenLines = new String(byteArrayOutputStream.toByteArray());
        String printStr = "DATE | AMOUNT | BALANCE\n" + "15/06/2021 | -100 | 100\n" + "15/06/2021 | 200 | 200";
        assertTrue(allWrittenLines.contains(printStr));
    }

    @Test
    void should_return_correct_string_value_when_execute_statementLine() {
        //given
        Console console = mock(Console.class);
        Transaction transaction = mock(Transaction.class);
        when(transaction.amount()).thenReturn(1000);
        when(transaction.date()).thenReturn("22/06/2021");
        Printer printer = new Printer(console);
        int runningBalance = 1000;

        //when
        String result = printer.statementLine(transaction, runningBalance);

        //then
        assertEquals(transaction.date() + SEPARATOR
                + transaction.amount() + SEPARATOR
                + runningBalance, result);
    }
}