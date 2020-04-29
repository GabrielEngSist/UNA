/*Lista de Exercícios
Aluno: Gabriel Oliveira Silva
RA.: 31821172

Recuperando dados
Banco de dados dbEmpresa
1.	Exibir a estrutura da tabela EMP.
*/
USE dbEmpresa;
GO
SP_HELP EMP;
GO
-- 2.	Exibir a estrutura da tabela DEPT.
USE dbEmpresa;
GO
SP_HELP DEPT;
GO
-- 3.	Exibir todos os dados e todas as colunas da tabela EMP.

SELECT * FROM dbEmpresa.dbo.EMP;

-- 4.	Exibir todos os dados e todas as colunas da tabela DEPT.

SELECT * FROM dbEmpresa.dbo.DEPT;

-- 5.	Exibir o nome dos empregados e o código dos departamentos onde os mesmos trabalham.

SELECT NOME, DEPTNO FROM dbEmpresa.dbo.EMP;

-- 6.	Exibir o código e nome de todos os departamentos da tabela DEPT.

SELECT DEPTNO, NOME FROM dbEmpresa.dbo.DEPT;

-- 7.	Exibir o nome dos departamentos concatenados com o seu local. Nomear esta coluna como “Nome_Local”.

SELECT NOME + ' - ' + LOC FROM dbEmpresa.dbo.DEPT;

-- 8.	Exibir os códigos distintos dos departamentos onde os empregados trabalham.

SELECT DISTINCT d.DEPTNO 
FROM		dbEmpresa.dbo.EMP e
INNER JOIN	dbEmpresa.dbo.DEPT d ON (e.DEPTNO = d.DEPTNO);

-- 9.	Exibir o nome dos empregados, bem como o seu salário multiplicado por 12. Nomear esta última coluna como “Salário Anual”.

SELECT NOME, SALARIO * 12  'Salário anual' FROM dbEmpresa.dbo.EMP;

-- 10.	Exibir o código dos empregados, bem como seu salário somado à sua comissão. Nomear esta última coluna como “Salário mais Comissão”

SELECT EMPNO, ISNULL(COMISSAO,0) + SALARIO 'Salário mais comissão' FROM dbEmpresa.dbo.EMP;

-- 11.	Exibir os cargos distintos a partir da tabela EMP

SELECT DISTINCT CARGO FROM dbEmpresa.dbo.EMP;

-- 12.	Exibir o nome do empregado concatenado com seu cargo, separado por uma vírgula e espaço. Nomear esta coluna como Empregado e Cargo.

SELECT CONCAT_WS(', ',NOME,CARGO) 'Empregado e Cargo' FROM dbEmpresa.dbo.EMP;

/*
Banco de dados dbNutricao
1.	Exibir o nome do paciente, sua cidade e estado. Ordenar o resultado inicialmente pelo estado, e em seguida pelo nome da cidade, ambos em ordem crescente.
*/

SELECT nome, cidade, estado FROM dbNutricao.dbo.PACIENTE ORDER BY estado, cidade;

-- 2.	Exibir o nome do paciente, seu sexo, e uma coluna contendo a cidade, concatenada com o estado, separados por uma barra (/). Nomear esta coluna como Cidade.

SELECT nome, sexo, CONCAT_WS('/', cidade, estado) Cidade from dbNutricao.dbo.PACIENTE;

-- 3.	Exibir o nome e estado das cidades onde os pacientes moram. Não exibir resultados duplicados. Ordenar o resultado inicialmente pelo estado, e em seguida pela cidade, ambos em ordem crescente.

SELECT DISTINCT cidade, estado FROM dbNutricao.dbo.PACIENTE ORDER BY cidade, estado;
