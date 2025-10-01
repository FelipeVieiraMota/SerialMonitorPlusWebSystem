-- =========================================================
-- PostgreSQL version (simple & error-avoidant)
-- =========================================================

-- (Optional) Recreate the database
-- Comment these two lines if you don't want to drop/recreate.
DROP DATABASE IF EXISTS bd_regra;
CREATE DATABASE bd_regra;

-- Switch to the database
\connect bd_regra

-- =========================
-- Tables
-- =========================

CREATE TABLE IF NOT EXISTS aluno (
    codigo_cartao_rfid INTEGER NOT NULL,
    nome_aluno VARCHAR(255) NOT NULL,
    nome_mae_aluno VARCHAR(255) NOT NULL,
    nome_pai_aluno VARCHAR(45) NOT NULL,
    codigo_matricula_aluno INTEGER NOT NULL,
    cpf_aluno VARCHAR(45) NOT NULL,
    sexo_aluno VARCHAR(45) NOT NULL,
    idade_aluno VARCHAR(45) NOT NULL,
    data_nascimento_aluno VARCHAR(45) NOT NULL,
    email_aluno VARCHAR(45) NOT NULL,
    celular_aluno VARCHAR(45) NOT NULL,
    rg_aluno VARCHAR(45),
    CONSTRAINT aluno_pkey PRIMARY KEY (codigo_cartao_rfid)
);

CREATE TABLE IF NOT EXISTS ano_semestre (
    id_ano_semestre INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    ano_semestre VARCHAR(45),
    observacoes VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS curso (
    id_curso INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome_curso VARCHAR(45),
    tipo_curso VARCHAR(45),
    duracao VARCHAR(45),
    qtd_semestres VARCHAR(100),
    carga_horaria VARCHAR(45),
    observacoes VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS turma (
    id_turma INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_curso INTEGER NOT NULL,
    nome_turma VARCHAR(100),
    abreviacao_turma VARCHAR(15),
    ciclo VARCHAR(45) NOT NULL,
    periodo VARCHAR(45),
    observacoes VARCHAR(255),
    CONSTRAINT fk_turma_curso FOREIGN KEY (id_curso) REFERENCES curso(id_curso)
);

CREATE TABLE IF NOT EXISTS ano_semestre_turma (
    id_ano_semestre INTEGER NOT NULL,
    id_turma INTEGER NOT NULL,
    observacoes VARCHAR(255) NOT NULL,
    CONSTRAINT fk_ast_ano FOREIGN KEY (id_ano_semestre) REFERENCES ano_semestre(id_ano_semestre),
    CONSTRAINT fk_ast_turma FOREIGN KEY (id_turma) REFERENCES turma(id_turma)
);

CREATE TABLE IF NOT EXISTS aluno_turma (
    id_turma INTEGER NOT NULL,
    codigo_cartao_rfid INTEGER NOT NULL,
    observacoes VARCHAR(255),
    CONSTRAINT fk_alt_turma FOREIGN KEY (id_turma) REFERENCES turma(id_turma),
    CONSTRAINT fk_alt_aluno FOREIGN KEY (codigo_cartao_rfid) REFERENCES aluno(codigo_cartao_rfid)
);

CREATE TABLE IF NOT EXISTS sala (
    id_sala INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    tipo_de_sala VARCHAR(45),
    numero_sala INTEGER NOT NULL,
    disponibilidade_sala BOOLEAN,
    andar_sala INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS professor (
    cartao_rfid_professor INTEGER PRIMARY KEY,
    nome_professor VARCHAR(45) NOT NULL,
    codigo_matricula_professor INTEGER NOT NULL,
    idade_professor INTEGER NOT NULL,
    data_nascimento_professor VARCHAR(12) NOT NULL,
    formacao_profissional_professor VARCHAR(45),
    especializacao_profissional_professor VARCHAR(45),
    cpf_professor VARCHAR(45),
    rg_professor VARCHAR(45),
    sexo_professor VARCHAR(45),
    celular_professor VARCHAR(45)
);

CREATE TABLE IF NOT EXISTS disciplina (
    id_disciplina INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome_disciplina VARCHAR(45),
    carga_hoararia_disciplina VARCHAR(45), -- mantendo o nome original
    abreviacao_disciplina VARCHAR(45),
    observacoes VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS disciplina_curso (
    id_curso INTEGER NOT NULL,
    id_disciplina INTEGER NOT NULL,
    observacoes VARCHAR(255),
    CONSTRAINT fk_dc_curso FOREIGN KEY (id_curso) REFERENCES curso(id_curso),
    CONSTRAINT fk_dc_disciplina FOREIGN KEY (id_disciplina) REFERENCES disciplina(id_disciplina)
);

CREATE TABLE IF NOT EXISTS disciplina_professor (
    id_disciplina INTEGER NOT NULL,
    cartao_rfid_professor INTEGER NOT NULL,
    nome_disciplina VARCHAR(45),
    nome_professor VARCHAR(45),
    observacoes VARCHAR(255),
    CONSTRAINT fk_dp_prof FOREIGN KEY (cartao_rfid_professor) REFERENCES professor(cartao_rfid_professor),
    CONSTRAINT fk_dp_disc FOREIGN KEY (id_disciplina) REFERENCES disciplina(id_disciplina)
);

CREATE TABLE IF NOT EXISTS horario_base (
    id_horario_base INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    hora TIME NOT NULL,
    descricao VARCHAR(45)
);

CREATE TABLE IF NOT EXISTS grade_professor (
    id_horario_base INTEGER NOT NULL,
    id_disciplina INTEGER NOT NULL,
    id_turma INTEGER NOT NULL,
    id_sala INTEGER NOT NULL,
    cartao_rfid_professor INTEGER NOT NULL,
    dia_semana VARCHAR(45),
    data_aula DATE,
    observacoes VARCHAR(255),
    CONSTRAINT fk_gp_horario FOREIGN KEY (id_horario_base) REFERENCES horario_base(id_horario_base),
    CONSTRAINT fk_gp_disciplina FOREIGN KEY (id_disciplina) REFERENCES disciplina(id_disciplina),
    CONSTRAINT fk_gp_turma FOREIGN KEY (id_turma) REFERENCES turma(id_turma),
    CONSTRAINT fk_gp_sala FOREIGN KEY (id_sala) REFERENCES sala(id_sala),
    CONSTRAINT fk_gp_prof FOREIGN KEY (cartao_rfid_professor) REFERENCES professor(cartao_rfid_professor)
);

-- =========================
-- Data
-- =========================

INSERT INTO aluno (
    codigo_cartao_rfid, nome_aluno, nome_mae_aluno, nome_pai_aluno,
    codigo_matricula_aluno, cpf_aluno, sexo_aluno, idade_aluno,
    data_nascimento_aluno, email_aluno, celular_aluno, rg_aluno
) VALUES (
    2000,
    'FELIPE VIEIRA MOTA',
    'MARIA JOSE VIEIRA MOTA',
    'CELIO ALEXANDRE MOTA',
    200640078,
    '39323658871',
    'MASCULINO',
    '26',
    '1991-11-03',
    'felipevieiramota@gmail.com',
    '+5513981325132',
    '477572789'
);

INSERT INTO ano_semestre (ano_semestre, observacoes) VALUES
('2017/1','PRIMEIRO SEMESTRE DE 2017'),
('2017/2','SEGUNDO SEMESTRE DE 2017'),
('2016/1','PRIMEIRO SEMESTRE DE 2017'),
('2016/2','SEGUNDO SEMESTRE DE 2017');

INSERT INTO curso (nome_curso, tipo_curso, duracao, qtd_semestres, carga_horaria, observacoes) VALUES
('BACHARELADO EM SISTEMAS DE INFORMACAO','GRADUACAO','4 ANOS','8 SEMESTRES','3600 HORAS DE CURSO','CURSO DE TECNOLOGIA DA INFORMACAO'),
('BACHARELADO EM ADMINISTRACAO','GRADUACAO','4 ANOS','8 SEMESTRES','3600 HORAS DE CURSO','CURSO DE ADMINISTRACAO');

INSERT INTO turma (id_curso, nome_turma, abreviacao_turma, ciclo, periodo, observacoes) VALUES
(1,'2017/1-BACHARELADO EM SISTEMAS DE INFORMACAO-7A','BSI-7A','7','NOTURNO','TURMA DO 7 SEMESTRE DO CURSO DE BACHARELADO EM SISTEMAS DE INFORMACAO');

INSERT INTO ano_semestre_turma (id_ano_semestre, id_turma, observacoes) VALUES
(1,1,'BACHARELADO EM SISTEMAS DE INFORMACOES PRIMEIRO SEMESTRE DE 2017');

INSERT INTO turma (id_curso, nome_turma, abreviacao_turma, ciclo, periodo, observacoes) VALUES
(1,'2017/2-BACHARELADO EM SISTEMAS DE INFORMACAO-8A','BSI-8A','8','NOTURNO','TURMA DO 8 SEMESTRE DO CURSO DE BACHARELADO EM SISTEMAS DE INFORMACAO');

INSERT INTO ano_semestre_turma (id_ano_semestre, id_turma, observacoes) VALUES
(2,2,'BACHARELADO EM SISTEMAS DE INFORMACOES PRIMEIRO SEMESTRE DE 2017');

INSERT INTO turma (id_curso, nome_turma, abreviacao_turma, ciclo, periodo, observacoes) VALUES
(2,'2017/1-BACHARELADO EM ADMINISTRACAO-1A','ADM-1A','1','NOTURNO','TURMA DO 1 SEMESTRE DO CURSO DE BACHARELADO EM SISTEMAS DE INFORMACAO');

INSERT INTO ano_semestre_turma (id_ano_semestre, id_turma, observacoes) VALUES
(1,3,'BACHARELADO EM ADMINISTRACAO PRIMEIRO SEMESTRE DE 2017');

INSERT INTO turma (id_curso, nome_turma, abreviacao_turma, ciclo, periodo, observacoes) VALUES
(2,'2017/1-BACHARELADO EM ADMINISTRACAO-3A','ADM-3A','3','NOTURNO','TURMA DO 3 SEMESTRE DO CURSO DE BACHARELADO EM SISTEMAS DE INFORMACAO');

INSERT INTO ano_semestre_turma (id_ano_semestre, id_turma, observacoes) VALUES
(1,4,'BACHARELADO EM ADMINISTRACAO PRIMEIRO SEMESTRE DE 2017');

INSERT INTO aluno_turma (id_turma, codigo_cartao_rfid, observacoes)
VALUES (1, 2000, 'ALUNO INSERIDO NA TURMA BSI-8');

INSERT INTO sala (tipo_de_sala, numero_sala, disponibilidade_sala, andar_sala)
VALUES ('LABORATORIO', 14, TRUE, 1);

INSERT INTO professor (
    cartao_rfid_professor, nome_professor, codigo_matricula_professor,
    idade_professor, data_nascimento_professor, formacao_profissional_professor,
    especializacao_profissional_professor, cpf_professor, rg_professor,
    sexo_professor, celular_professor
) VALUES (
    123456,
    'LEANDRO SANCHEZ',
    3000,
    40,
    '1967-09-15',
    'CIENCIAS DA COMPUTACAO',
    'BANCO DE DADOS',
    '32132132132132',
    '897897897987',
    'MASCULINO',
    '+5513879879797'
);

INSERT INTO disciplina (nome_disciplina, carga_hoararia_disciplina, abreviacao_disciplina, observacoes)
VALUES ('EMPREENDEDORISMO','40 HORAS','EMPRE.','DISCIPLINA APLICADA PARA A ANALISE DE UMA EMPRESA DO ');

INSERT INTO disciplina_curso (id_curso, id_disciplina, observacoes) VALUES
(1,1,'DISCIPLINA PARA LINGUAGENS WEB'),
(2,1,'DISCIPLINA PARA LINGUAGENS WEB');

INSERT INTO disciplina_professor (id_disciplina, cartao_rfid_professor, nome_disciplina, nome_professor, observacoes)
VALUES (1, 123456, 'LINGUAGEM WEB', 'LEANDRO SANCHEZ', 'DISCIPLINA MINISTRADA POR LEANDRO SANCHEZ PARA A TURMA BSI-8');

INSERT INTO horario_base (hora, descricao) VALUES
('19:00:00','PRIMEIRO HORARIO DO PERIODO NOTURNO'),
('19:50:00','SEGUNDO HORARIO DO PERIODO NOTURNO'),
('20:55:00','TERCEIRO HORARIO DO PERIODO NOTURNO'),
('21:45:00','QUARTO HORARIO DO PERIODO NOTURNO'),
('22:35:00','QUINTO HORARIO DO PERIODO NOTURNO');

INSERT INTO grade_professor (
    id_horario_base, id_disciplina, id_turma, id_sala, cartao_rfid_professor,
    dia_semana, data_aula, observacoes
) VALUES
(1,1,1,1,123456,'1-SEGUNDA-FEIRA','2017-02-20','AULA DE WEB COM O PROFESSOR LEANDRO NO LABO 14 PARA A TURMA BSI-7'),
(1,1,1,1,123456,'2-TERCA-FEIRA','2017-02-21','AULA DE WEB COM O PROFESSOR LEANDRO NO LABO 14 PARA A TURMA BSI-7'),
(1,1,1,1,123456,'3-QUARTA-FEIRA','2017-02-22','AULA DE WEB COM O PROFESSOR LEANDRO NO LABO 14 PARA A TURMA BSI-7'),
(1,1,1,1,123456,'4-QUINTA-FEIRA','2017-02-23','AULA DE WEB COM O PROFESSOR LEANDRO NO LABO 14 PARA A TURMA BSI-7'),
(1,1,1,1,123456,'5-SEXTA-FEIRA','2017-02-24','AULA DE WEB COM O PROFESSOR LEANDRO NO LABO 14 PARA A TURMA BSI-7');

-- =========================
-- Sample queries (optional)
-- =========================

SELECT *
FROM turma t
JOIN ano_semestre_turma anst ON t.id_turma = anst.id_turma
JOIN ano_semestre ans ON ans.id_ano_semestre = anst.id_ano_semestre
JOIN curso c ON c.id_curso = t.id_curso;

SELECT *
FROM turma t
JOIN curso c ON c.id_curso = t.id_curso
WHERE t.nome_turma = '2017/1-BACHARELADO EM ADMINISTRACAO-3A';

SELECT
    t.abreviacao_turma,
    t.nome_turma,
    d.carga_hoararia_disciplina,
    d.nome_disciplina,
    c.nome_curso
FROM curso c
JOIN disciplina_curso dc ON c.id_curso = dc.id_curso
JOIN disciplina d ON d.id_disciplina = dc.id_disciplina
JOIN turma t ON t.id_curso = c.id_curso;

SELECT
    hb.hora,
    gp.dia_semana,
    p.nome_professor,
    s.numero_sala,
    s.andar_sala,
    d.nome_disciplina,
    t.nome_turma
FROM grade_professor gp
JOIN horario_base hb ON hb.id_horario_base = gp.id_horario_base
JOIN disciplina d ON d.id_disciplina = gp.id_disciplina
JOIN turma t ON t.id_turma = gp.id_turma
JOIN sala s ON s.id_sala = gp.id_sala
JOIN professor p ON p.cartao_rfid_professor = gp.cartao_rfid_professor
WHERE gp.dia_semana = '1-SEGUNDA-FEIRA'
ORDER BY gp.dia_semana;

