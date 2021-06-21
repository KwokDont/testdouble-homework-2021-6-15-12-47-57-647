package com.tw.banking;

import org.junit.jupiter.api.Test;

import static com.tw.banking.Printer.SEPARATOR;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PrinterTest {

    @Test
    void print() {
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