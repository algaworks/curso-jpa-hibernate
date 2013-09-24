1. Extrair o JBoss para uma pasta qualquer

2. Configurar o módulo do datasource

  2.1 Criar as pastas mysql/main em <jboss_home>/modules/com
  
  2.2 Copiar o driver (mysql-connector-java-5.1.25-bin.jar) para esta pasta
  
  2.3 Criar o arquivo module.xml com o seguinte conteúdo:
  
  <?xml version="1.0" encoding="UTF-8"?>
  <module xmlns="urn:jboss:module:1.0" name="com.mysql">
    <resources>
        <resource-root path="mysql-connector-java-5.1.25-bin.jar"/>
    </resources>
    <dependencies>
        <module name="javax.api"/>
        <module name="javax.transaction.api"/>
    </dependencies>
  </module>

  2.4 Editar o arquivo <jboss_home>/standalone/configuration/standalone.xml
  
  <datasource jta="true" jndi-name="java:/projetoJbossDS" pool-name="MySqlDS" enabled="true" use-java-context="true" use-ccm="true">
    <connection-url>jdbc:mysql://localhost:3306/cadastro_cliente</connection-url>
    <driver>mysql</driver>
    <security>
        <user-name>root</user-name>
        <password>root</password>
    </security>
    <timeout>
        <idle-timeout-minutes>0</idle-timeout-minutes>
        <query-timeout>600</query-timeout>
    </timeout>
  </datasource>
  <drivers>
    <driver name="mysql" module="com.mysql"/>
  </drivers>
  
3. Crie o schema "cadastro_cliente" no MySQL para o usuário root, se ainda não tiver sido criado.