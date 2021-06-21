package com.tw.banking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TransactionRepositoryTest {

    @Test
    void should_transaction_list_add_been_call_when_execute_add_deposit() {
        //given
        int amount = 100;
        Clock clock = mock(Clock.class);
        TransactionRepository transactionRepository = new TransactionRepository(clock);

        //when
        transactionRepository.addDeposit(amount);

        //then
        assertEquals(1, transactionRepository.transactions.size());
    }

}