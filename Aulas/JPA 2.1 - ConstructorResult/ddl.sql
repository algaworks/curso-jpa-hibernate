create table alert (
	codigo bigint(20) primary key auto_increment,
	codigo_usuario bigint(20),
    register_date datetime,
	foreign key (codigo_usuario) references usuario(codigo) 
)