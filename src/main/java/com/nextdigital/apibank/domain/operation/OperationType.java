package com.nextdigital.apibank.domain.operation;

public enum OperationType {
    CASH_INCOME("Cash Income"), CASH_WITHDRAWAL("Cash Withdrawal"),
    OUTGOING_TRANSFER("Outgoing Transfer"), INCOMING_TRANSFER("Incoming Transfer");

    OperationType(String s) {
    }
}
