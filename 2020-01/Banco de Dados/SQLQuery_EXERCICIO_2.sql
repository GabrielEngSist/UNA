/*Lista de Exercícios
Aluno: Gabriel Oliveira Silva
RA.: 31821172
 
Restringindo e Ordenando Dados

Banco de dados Empresa
1.	Exibir o nome, cargo e salário dos empregados que ganham mais de R$ 2000.00. Ordenar o resultado pelo cargo em ordem crescente, e em seguida, pelo nome do empregado em ordem decrescente.	*/

SELECT		NOME, CARGO, SALARIO 
FROM		dbEmpresa.dbo.EMP 
WHERE		SALARIO > 2000 
ORDER BY CARGO ASC, NOME DESC;

-- 2.	Exibir o código do departamento e o nome dos empregados dos departamentos 10 e 20, que possuem o cargo de BALCONISTA. Ordenar o resultado pelo código do departamento e em seguida, pelo nome, ambos em ordem crescente.

SELECT	DEPTNO, NOME
FROM	dbEmpresa.dbo.EMP
WHERE	DEPTNO IN (10,20)
AND		CARGO = 'BALCONISTA'
ORDER BY DEPTNO, NOME;

-- 3.	Exibir o nome e cargo dos empregados que possuem salário entre R$ 1000,00 e R$ 5000,00. Ordenar o resultado pelo salário em ordem decrescente.



-- 4.	Exibir o código, nome e o salário anual dos empregados que não possuem comissão (comissão nula). Ordenar o resultado pelo salário anual. Nomear a última coluna como "Salário Anual".
-- 5.	Exibir o nome, a comissão e o cargo dos empregados que começam com a letra A e que terminam com a letra S. Ordenar o resultado pelo cargo do empregado, e em seguida, pelo nome, ambos em ordem decrescente.

/*Banco de dados Nutrição
1.	Exibir o nome do paciente, sua cidade e estado, mas somente dos pacientes que possuem "Silva" no nome. Ordenar o resultado pelo nome em ordem decrescente*/
-- 2.	Exibir o nome do paciente, seu endereço, bairro, cidade e o estado, mas somente dos pacientes dos estados do Rio de Janeiro e São Paulo. Ordenar o resultado inicialmente pelo estado, e em seguida pela cidade, ambos em ordem crescente.
-- 3.	Exibir o nome, cidade e endereço dos pacientes do estado de Minas Gerais. Ordenar o resultado pelo nome da cidade e em seguida pelo nome da paciente, ambos em ordem crescente.
-- 4.	Exibir o nome e data de nascimento dos pacientes que moram no centro da cidade de Belo Horizonte, do estado de Minas Gerais.
-- 5.	Exibir o nome dos alimentos que começam com a palavra “Arroz”
-- 6.	Exibir o nome dos alimentos que possuem a palavra “congelado” em qualquer parte do nome


