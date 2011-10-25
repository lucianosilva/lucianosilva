-- Tipo que define a estrutura da mensagem que será adicionada a fila
CREATE TYPE XXAR_KEY_INVOICE AS OBJECT (
    INVOICE_NUM         NUMBER(10),
    SOURCE_NAME         VARCHAR2(200),
    TOTAL_AMOUNT        NUMBER(15,2),
    DESCRIPTION         VARCHAR2(500))
/

Begin
 DBMS_AQADM.create_queue_table( queue_table => 'XXAR_INVOICE', -- nome da QTable
                                queue_payload_type => 'XXAR_KEY_INVOICE' -- tipo mensagem da QTable
                              );
End;
/

Begin
 DBMS_AQADM.create_queue(queue_name => 'XXAR_INVOICE_QTAB', -- nome da Queue
                         queue_table => 'XXAR_INVOICE' -- Tabela controladora da Queue
                         );
End;
/

Begin
  DBMS_AQADM.start_queue( queue_name => 'XXAR_INVOICE_QTAB' ); -- Iniciando a Fila
End;

/
CREATE OR REPLACE TYPE XXAR_KEY_INVOICE_T AS TABLE OF XXAR_KEY_INVOICE;
/
