INSERT INTO banks (id) VALUES ('2a75caa1-c272-472d-a034-2baef87c3c80');
INSERT INTO banks (id) VALUES ('7bcea78e-7746-4ece-954f-689627e90c9c');
INSERT INTO banks (id) VALUES ('78b4a107-61c1-4932-aa4a-eacfe011c1ca');
INSERT INTO banks (id) VALUES ('59676b18-dcc3-43c3-a757-5faaeb6f4235');

INSERT INTO customers (id) VALUES ('c2b8eb72-e1f2-49dc-9cf7-de39049f6f9e');
INSERT INTO customers (id) VALUES ('fa7f7700-316e-4c8a-b64d-fc9146f1e62f');
INSERT INTO customers (id) VALUES ('efc34e6b-7de1-476b-b79c-1116cf86540c');
INSERT INTO customers (id) VALUES ('9130f4cd-7800-4382-b980-b90fe30cf98b');
INSERT INTO customers (id) VALUES ('697e4437-cb25-4462-88b8-2d680e28e22d');
INSERT INTO customers (id) VALUES ('2d7fd624-2a39-4e8d-aca3-b1626cd6c82c');
INSERT INTO customers (id) VALUES ('f1c8ba8c-52c1-43e1-8ed5-4db0480eb816');
INSERT INTO customers (id) VALUES ('81b388d0-e214-43ab-a0e5-999dfd3141a5');
INSERT INTO customers (id) VALUES ('becb5bd2-f4ad-46a7-83df-e60e4dd6c259');

INSERT INTO accounts (id, balance, iban, account_number, bank_id, customer_id)
    VALUES ('fa24b0c6-82a7-4575-9af9-251407138d46', 3456.48, 'ES21', '0123456789987654321',
            '2a75caa1-c272-472d-a034-2baef87c3c80',
            'c2b8eb72-e1f2-49dc-9cf7-de39049f6f9e');
INSERT INTO accounts (id, balance, iban, account_number, bank_id, customer_id)
    VALUES ('56d1fd26-d79d-43ef-a8af-c01d60b14c4f', 11.32, 'ES22', '45324563453123456345',
            '7bcea78e-7746-4ece-954f-689627e90c9c',
            'f1c8ba8c-52c1-43e1-8ed5-4db0480eb816');
INSERT INTO accounts (id, balance, iban, account_number, bank_id, customer_id)
    VALUES ('07ec0f4f-7fef-4f97-9d38-2b71076d6a81', 33.00, 'ES23', '45637833456378656786',
            '59676b18-dcc3-43c3-a757-5faaeb6f4235',
            'becb5bd2-f4ad-46a7-83df-e60e4dd6c259');
INSERT INTO accounts (id, balance, iban, account_number, bank_id, customer_id)
    VALUES ('85b1350c-f180-4726-844f-2484893d94e5', 546.12, 'ES24', '7864563456456456788',
            '7bcea78e-7746-4ece-954f-689627e90c9c',
            '9130f4cd-7800-4382-b980-b90fe30cf98b');
INSERT INTO accounts (id, balance, iban, account_number, bank_id, customer_id)
    VALUES ('8a158d8c-072a-4c95-b603-c4c689796d38', 67.79, 'ES25', '2557534245887675785',
            '78b4a107-61c1-4932-aa4a-eacfe011c1ca',
            '697e4437-cb25-4462-88b8-2d680e28e22d');

INSERT INTO cards (id, pin, is_activated, card_type, credit, account_id)
VALUES ('96640aae-8c9c-4be0-8464-812f50e40418', 1234, false, 1, 1000.00,
        'fa24b0c6-82a7-4575-9af9-251407138d46');
INSERT INTO cards (id, pin, is_activated, card_type, credit, account_id)
VALUES ('2dac2757-5d3e-4729-967d-224079901612', 0000, false, 2, 0.00,
        '56d1fd26-d79d-43ef-a8af-c01d60b14c4f');
INSERT INTO cards (id, pin, is_activated, card_type, credit, account_id)
VALUES ('417dbb12-26f6-4b10-acf5-f80bd7082dbc', 1111, false, 2, 0.00,
        '07ec0f4f-7fef-4f97-9d38-2b71076d6a81');
INSERT INTO cards (id, pin, is_activated, card_type, credit, account_id)
VALUES ('484b9819-95b9-4d05-8a53-bfc5c777bb44', 2222, false, 2, 0.00,
        '85b1350c-f180-4726-844f-2484893d94e5');
INSERT INTO cards (id, pin, is_activated, card_type, credit, account_id)
VALUES ('43744995-0f01-43c4-bc7a-9bee203224cf', 3333, false, 1, 500.00,
        '8a158d8c-072a-4c95-b603-c4c689796d38');