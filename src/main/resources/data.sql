INSERT INTO cards (id, pin, is_activated, card_type, credit)
    VALUES ('96640aae-8c9c-4be0-8464-812f50e40418', 1234, false, 1, 1000.00);

INSERT INTO banks (id) VALUES ('2a75caa1-c272-472d-a034-2baef87c3c80');
INSERT INTO customers (id) VALUES ('c2b8eb72-e1f2-49dc-9cf7-de39049f6f9e');

INSERT INTO accounts (id, balance, iban, account_number, card_id, bank_id, customer_id)
    VALUES ('fa24b0c6-82a7-4575-9af9-251407138d46', 3456.48, 'ES21', '0123456789987654321',
            '96640aae-8c9c-4be0-8464-812f50e40418',
            '2a75caa1-c272-472d-a034-2baef87c3c80',
            'c2b8eb72-e1f2-49dc-9cf7-de39049f6f9e')