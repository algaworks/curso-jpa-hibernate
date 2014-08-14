create table pedido (
   codigo bigint primary key auto_increment,
   valor decimal(10,2),
   status varchar(50)
);

create table devolucao (
  codigo bigint primary key auto_increment,
  codigo_pedido bigint,
  status varchar(50)
);

create table entrega (
  codigo bigint primary key auto_increment,
  codigo_pedido bigint,
  previsao date
);

DELIMITER $$

CREATE PROCEDURE analisarPedido(vCodigo bigint, OUT vAnalise varchar(50))
BEGIN
   DECLARE vStatus varchar(50);
   
   select status into vStatus from pedido where codigo = vCodigo;
   
   START TRANSACTION;
   if vStatus = 'CANCELADO' then
     insert into devolucao (codigo_pedido, status) values (vCodigo, 'PENDENTE');
     set vAnalise = 'DEVOLUCAO';
     
   elseif vStatus = 'APROVADO' then
     insert into entrega (codigo_pedido, previsao) values (vCodigo, now());
     set vAnalise = 'ENTREGA';
   end if;
   
   COMMIT;

END $$
DELIMITER ;

insert into pedido (valor, status) values (100, 'CANCELADO');
insert into pedido (valor, status) values (200, 'APROVADO');
insert into pedido (valor, status) values (200, 'APROVADO');

select * from pedido

select * from devolucao
SELECT * FROM entrega