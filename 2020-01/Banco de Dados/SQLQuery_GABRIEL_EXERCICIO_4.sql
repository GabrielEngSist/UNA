
                                            /*Agrupando e Resumindo dados
                                               Banco de dados EMPRESA
- Quantos empregados não possuem comissão? 

   11 EMPREGADOS NAO POSSUEM COMISSAO
*/
SELECT COUNT(*)
FROM EMP
WHERE COMISSAO IS NULL 
OR COMISSAO =0;
/*
- Quantos empregados possuem comissão?
   
   3 EMPREGADOS POSSUEM COMISSÃO E 1 EMPREGADO POSSUI COMISSAO EQUIVALENTE A 0
*/
SELECT COUNT(*)
FROM EMP
WHERE COMISSAO IS NOT NULL
AND COMISSAO!=0

/*
- Qual o menor e maior salário da empresa?

       MAIOR SALÁRIO = 15000,00 E MENOR SALÁRIO=1100,00
*/
SELECT MAX(SALARIO) AS 'MAIOR SALÁRIO' ,MIN(SALARIO) AS 'MENOR SALÁRIO'
FROM EMP
/*
- Considerando somente os departamentos 10 e 20, qual o menor e maior salário?

       MAIOR SALÁRIO = 15000,00 E MENOR SALÁRIO=1100,00
*/
SELECT MAX(SALARIO) AS 'MAIOR SALÁRIO',
       MIN(SALARIO) AS 'MENOR SALÁRIO'
FROM EMP
WHERE DEPTNO IN(10,20)

/*
- Qual a média salarial dos empregados que ganham mais de R$ 2000,00?

      MEDIA SALARIAL DOS EMPREGADOS QUE GANHAM MAIS QUE R$ 2000,00 = R$ 6386,4772
*/
SELECT AVG(SALARIO)
FROM EMP
WHERE SALARIO>2000.00

/*
- Quando foram realizadas a primeira e a última contratação de um empregado? 

      DATA PRIMEIRA CONTRATAÇÃO = 2010-12-03    DATA ULTIMA CONTRATAÇÃO= 2016-05-01
*/
SELECT MAX(DATACONTRATACAO) 'PRIMEIRA CONTRATAÇÃO' , MIN(DATACONTRATACAO) 'ULTIMA CONTRATAÇÃO'
FROM EMP

/*
- Quantos cargos existem na tabela EMP?

      5 CARGOS DISTINTOS
*/
SELECT COUNT(DISTINCT CARGO)
FROM EMP

/*
- Quantos gerentes existem na tabela EMP?

           6  GERENTES
*/
SELECT COUNT(DISTINCT E2.EMPNO)
FROM EMP E1
JOIN EMP E2 ON E2.EMPNO = E1.GERENTE
/*
- Quantos departamentos possuem pelo menos um empregado?

       3 DEPARTAMENTOS POSSUEM PELO MENOS UM EMPREGADO
*/
SELECT COUNT(DISTINCT EMP.DEPTNO)
FROM EMP
JOIN DEPT 
ON DEPT.DEPTNO = EMP.DEPTNO
WHERE EMP.DEPTNO IS NOT NULL

/*
- Exibir a quantidade de empregados da tabela EMP separados por cargo e departamento.
*/
SELECT COUNT(*),CARGO,DEPTNO
FROM EMP
GROUP BY CARGO,DEPTNO

/*
- Exibir o código e nome dos departamentos, bem como o seu maior salário, mas somente para os departamentos que possuem mais de 4 empregados.
*/
SELECT max(dept.DEPTNO) as 'CÓDIGO DEPARTAMENTO', max(dept.NOME) as 'NOME DEPARTAMENTO',max(salario) as 'MAIOR SALÁRIO'
FROM EMP
JOIN DEPT 
ON DEPT.DEPTNO = EMP.DEPTNO
GROUP BY emp.DEPTNO
HAVING COUNT(*)>4

/*
- Exibir o código dos gerentes (coluna GERENTE) e a quantidade de empregados gerenciados por ele. 
*/ 
SELECT MAX(E2.EMPNO) as 'CÓGIDO GERENTE',COUNT(*) as 'QUANTIDADE EMPREGADOS'
FROM EMP E1
JOIN EMP E2 ON E1.GERENTE=E2.EMPNO
GROUP BY E1.GERENTE
/*
- Exibir o código e nome do departamento, sua média salarial, mas somente para os departamentos que possuem o salário mínimo maior que R$ 1000.
*/
SELECT MAX(DEPT.DEPTNO) as 'Código departamento',MAX(DEPT.NOME)'Nome departamento',AVG(SALARIO) 'Média Salárial'
FROM EMP
JOIN DEPT
ON DEPT.DEPTNO=EMP.DEPTNO
JOIN SALGRADE
ON emp.SALARIO>1000
GROUP BY DEPT.DEPTNO

/*
- Exibir o salário, o código e nome dos 3 empregados que possuem o menor salário dentro da empresa. 
*/
SELECT TOP 3 DEPTNO,NOME,SALARIO
FROM EMP 
ORDER BY SALARIO 

/*
- Exibir os dois cargos que possuem maior média salarial dentro da empresa.
*/
SELECT TOP (2) CARGO, AVG(SALARIO)
FROM EMP
GROUP BY CARGO
ORDER BY 2 DESC

/*
Banco de dados Nutrição
- Quantos pacientes moram em São Paulo ou no Rio de Janeiro?

        9 PACIENTES MORAM NO RJ E SP
*/
USE dbNutricao
SELECT COUNT(*)
FROM paciente
where estado in('RJ','SP')

/*
- Exibir o nome da cidade, o estado e a quantidade de pacientes por cidade/estado.
*/
SELECT cidade,estado,COUNT(*) as 'quantidade de pacientes'
FROM paciente
GROUP BY CIDADE,ESTADO
/*
- Exibir o nome do paciente, a data de sua primeira e da sua última consulta.
*/

SELECT MAX(paciente.nome),MIN(consulta.datConsulta) as 'PRIMEIRA CONSULTA',MAX(consulta.datConsulta) as 'ÚLTIMA CONSULTA'
FROM paciente
JOIN CONSULTA
ON consulta.idPaciente = paciente.idPaciente
GROUP BY paciente.idPaciente

/*
- Exibir a quantidade de consultas realizadas por cidade e estado.
*/
SELECT paciente.cidade,paciente.estado,COUNT(*) as 'QUANTIDADE DE CONSULTA(S)'
FROM paciente
JOIN consulta
ON consulta.idPaciente = paciente.idPaciente
GROUP BY paciente.cidade,paciente.estado

/*
- Para cada dieta, exibir o nome do paciente, a data em que foi realizada, e a quantidade total de cada nutriente que compõe a dieta.
*/
SELECT max(p.nome) nomePaciente,max(c.datConsulta) datConsulta,CONCAT(MIN(n.nome),' - ',SUM(ca.quantidade)) nutriente
FROM consulta c
join dieta d
on d.idConsulta=c.idConsulta
join paciente p
on c.idPaciente=p.idPaciente
join
composicaoDieta cd on cd.idDieta = d.idDieta
join alimento a on a.idAlimento = cd.idAlimento
join composicaoAlimento ca on ca.idAlimento = a.idAlimento
join nutriente n on n.idNutriente = ca.idNutriente
group by d.idConsulta, n.idNutriente
order by nomePaciente, datConsulta

select * from nutriente


