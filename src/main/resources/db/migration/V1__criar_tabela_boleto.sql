create table boleto
(
    id              varchar(36) not null
        primary key,
    codigo_barras   varchar(50) not null,
    valor_original  double      not null,
    data_vencimento date        not null,
    data_pagamento  date        null,
    juros           double      null,
    multa           double      null,
    valor_atual     double      null
);