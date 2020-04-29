/*Exercícios
Criando views
Banco de dados EMPRESA
1. Crie uma view chamada V_EMP para que determinados usuários não possuam acesso às informações sobre salário e comissão de todos os empregados da empresa. Esta view deverá possuir os seguintes campos:
Coluna Tabela
EMPNO EMP
NOME EMP
CARGO EMP
DEPTNO EMP
*/
USE DBEMPRESA
GO
CREATE VIEW V_EMP
            (
                        EMPNO,
                        NOME,
                        CARGO,
                        DEPTNO
            )
            AS
SELECT empno,
       nome,
       cargo,
       deptno
FROM   emp
GO
/*
Exiba as informações sobre esta view consultando a view de sistema INFORMATION_SCHEMA.VIEWS
*/
SELECT *
FROM   INFORMATION_SCHEMA.views
WHERE  table_name ='V_EMP'
/*
Exiba as informações sobre as colunas que esta view possui consultando a view de sistema INFORMATION_SCHEMA.VIEW_COLUMN_USAGE
*/
SELECT *
FROM   INFORMATION_SCHEMA.view_column_usage
WHERE  view_name ='V_EMP'
/*
Exiba os dados de todos os empregados através desta view.
*/
SELECT *
FROM   v_emp
/*
Exiba os nomes dos empregados, seu cargo, e o nome dos departamentos onde trabalham, utilizando esta view.
*/
SELECT     v_emp.nome,
           v_emp.cargo,
           d.nome
FROM       v_emp
INNER JOIN dept d
ON         d.deptno=v_emp.deptno
/*
2. Crie uma view chamada V_EMP_DALLAS, contendo somente os empregados dos departamentos se situam em Dallas. Esta view deverá possuir os seguintes campos:
Coluna Tabela
EMPNO EMP
NOME EMP
CARGO EMP
DEPTNO DEPT
NOME DEPT
LOC DEPT
*/
GO
CREATE VIEW V_EMP_DALLAS
            (
                        EMPNO,
                        NOME,
                        CARGO,
                        DEPTNO,
                        NOME_DEPT,
                        LOC
            )
            AS
SELECT     e.empno,
           e.nome,
           e.cargo,
           d.deptno,
           d.nome,
           d.loc
FROM       emp AS e
INNER JOIN dept d
ON         e.deptno = d.deptno
AND        d.loc ='DALLAS'
GO
/*
Exiba as informações sobre esta view consultando a view de sistema INFORMATION_SCHEMA.VIEWS
*/
SELECT *
FROM   INFORMATION_SCHEMA.views
WHERE  table_name ='V_EMP_DALLAS'
/*
Exiba as informações sobre as colunas que esta view possui consultando a view de sistema INFORMATION_SCHEMA.VIEW_COLUMN_USAGE
*/
SELECT *
FROM   INFORMATION_SCHEMA.view_column_usage
WHERE  view_name ='V_EMP_DALLAS'
/*
Utilizando esta view, exiba todos os empregados de Dallas que possuam o cargo "ANALISTA".
*/
SELECT *
FROM   v_emp_dallas d
WHERE  cargo='ANALISTA'
/*
Banco de dados Nutrição
Crie uma view que exiba:
1. O nome do alimento, o nome de sua categoria, e o nome, quantidade e unidade de medida dos nutrientes que o compõem.
*/
USE DBNUTRICAO;
GO
CREATE VIEW V_ALIMENTO
            (
                        ALIMENTO,
                        CATEGORIA,
                        NUTRIENTE,
                        QUANTIDADE,
                        UNIDADE_MEDIDA
            )
            AS
SELECT a.nome,
       ca.nome,
       n.nome,
       comp.quantidade,
       u.nome
FROM   alimento a
JOIN   categoriaalimento ca
ON     ca.idcategoria = a.idcategoria
JOIN   composicaoalimento comp
ON     comp.idalimento=a.idalimento
JOIN   nutriente n
ON     n.idnutriente= comp.idnutriente
JOIN   unidademedida u
ON     u.idunidademedida=comp.idunidademedida
GO
/*
Através desta view, exiba somente os alimentos da categoria Bebidas (alcoólicas e não alcoólicas).
*/
SELECT *
FROM   v_alimento
WHERE  categoria ='Bebidas (alcoólicas e não alcoólicas)'
/*
2. O identificador, nome e endereço do paciente, o identificador e a data da sua consulta, e o nome do médico que realizou a consulta.
*/
GO
DROP VIEW IF EXISTS V_PACIENTE;
GO
CREATE VIEW V_PACIENTE
            (
                        IDPACIENTE,
                        PNOME,
                        PENDERECO,
                        IDCONSULTA,
                        DATACONSULTA,
                        IDMEDICO,
                        MNOME
            )
            AS
SELECT p.idpaciente,
       p.nome,
       p.endereco,
       c.idconsulta,
       c.datconsulta,
       m.idmedico,
       m.nome
FROM   paciente p
JOIN   consulta c
ON     c.idpaciente = p.idpaciente
JOIN   medico m
ON     m.idmedico = c.idmedico
/*
3. O nome e endereço do paciente, a data da sua consulta, o médico que realizou a consulta, bem como todos os dados das dietas realizadas na consulta
(categoria e alimentos que compõem as dietas).
Utilize a view criada anteriormente como base para essa nova view.
*/
GO
DROP VIEW IF EXISTS V_DIETA
GO
CREATE VIEW V_DIETA
            (
                        IDPACIENTE,
                        PNOME,
                        PENDERECO,
                        IDCONSULTA,
                        DATACONSULTA,
                        IDMEDICO,
                        MNOME,
                        CATEGORIADIETA,
                        ALIMENTOSDIETA
            )
            AS
SELECT idpaciente,
       pnome,
       pendereco,
       d.idconsulta,
       dataconsulta,
       idmedico,
       mnome,
       cd.nome,
       a.nome
FROM   v_paciente
JOIN   dieta d
ON     d.idconsulta = v_paciente.idconsulta
JOIN   categoriadieta cd
ON     cd.idcategoriadieta = d.idcategoriadieta
JOIN   composicaodieta compd
ON     compd.iddieta= d.iddieta
JOIN   alimento a
ON     a.idalimento = compd.idalimento
GO
/*
Através da view criada, exiba todas as dietas dos pacientes que moram no estado de Minas Gerais.
*/
SELECT v_dieta.*,
       p.estado
FROM   v_dieta
JOIN   paciente p
ON     p.idpaciente = v_dieta.idpaciente
WHERE  p.estado='mg'
/*
4. O nome e endereço do paciente, a data da sua consulta, o médico que realizou a consulta, bem como todos os dados das avaliações nutricionais realizadas
nas consultas. Utilize a view criada anteriormente (que exibe os dados das consultas) como base para essa nova view.
*/
GO
DROP VIEW IF EXISTS V_AVALIACAO_NUTRICIONAL;
GO
CREATE VIEW V_AVALIACAO_NUTRICIONAL
            (
                        IDPACIENTE,
                        PACIENTE,
                        DATACONSULTA,
                        MEDICO,
                        IDAVALIACAONUTRICIONAL,
                        IDCONSULTA,
                        PESO,
                        ALTURA,
                        PERCGORDURA,
                        DATAINCLUSAO
            )
            AS
SELECT DISTINCT c.idpaciente,
                c.pnome,
                c.dataconsulta,
                c.mnome,
                an.*
FROM            paciente p
JOIN            v_dieta c
ON              c.idpaciente=p.idpaciente
JOIN            medico m
ON              m.idmedico=c.idmedico
JOIN            avaliacaonutricional an
ON              an.idconsulta = c.idconsulta
GO
/*
Através da view criada, exiba todas as avaliações nutricionais dos pacientes que possuem mais de 40 anos (utilizando como base a data atual do servidor) (utilize a função DATEDIFF do SQL Server para calcular a idade do paciente).
*/
SELECT     v.*
FROM       v_avaliacao_nutricional v
INNER JOIN paciente p
ON         p.idpaciente = v.idpaciente
WHERE      Datediff(YEAR, p.datanascimento, Getdate()) > 40;