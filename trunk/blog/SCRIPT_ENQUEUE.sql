DECLARE

    --
    enqueue_options     dbms_aq.enqueue_options_t;
    message_properties  dbms_aq.message_properties_t;
    recipients          dbms_aq.aq$_recipient_list_t;
    message_handle      RAW(16);

    --
    MESSAGE             XXAR_KEY_INVOICE;
    p_queue             varchar2(100)   := 'XXAR_INVOICE_QTAB';
    --
Begin
    --
    -- Formatacao da Mensagem para o Enqueue com dados fake
    --
    MESSAGE := XXAR_KEY_INVOICE( INVOICE_NUM => 10001,
                                 SOURCE_NAME => 'core system',
                                 TOTAL_AMOUNT => 139.99,
                                 DESCRIPTION => 'White T-Short'
                               );

    -- Enqueue (enfileiramento)
    dbms_aq.enqueue(queue_name           => p_queue, -- nome da fila
                    payload              => MESSAGE, -- mensagem
                    enqueue_options      => enqueue_options,
                    message_properties   => message_properties,
                    msgid                => message_handle);

    commit; -- o commit é obrigatório

Exception
    When Others Then
    Rollback;
    dbms_output.put_line('Ocorreu algum erro durante o processo de Enqueue na fila XXAR_INVOICE_QTAB : ');
    dbms_output.put_line( SQLERRM);
End;
