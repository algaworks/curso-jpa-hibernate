insert into usuario (nome, status) values ("João", "ATIVO");
insert into usuario (nome, status) values ("Maria", "INATIVO");
insert into grupo (nome) values ('ADMINISTRADOR');
insert into grupo (nome) values ('VENDEDOR');
insert into usuario_grupo (codigo_usuario, codigo_grupo) values (1, 1);
insert into usuario_grupo (codigo_usuario, codigo_grupo) values (1, 2);
insert into usuario_grupo (codigo_usuario, codigo_grupo) values (2, 2);
