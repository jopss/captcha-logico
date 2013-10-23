-- As respostas sao embaralhadas entre todas as perguntas, 
-- retornando sempre a resposta correta e 3 aleatorias.
-- Assim, tomar cuidado para nao obtermos respostas redundantes.

-- Por ex, existe a pergunta "Qual dos itens abaixo é um meio de transporte que contém 2 rodas?", referenciando "Moto" como resposta correta.
-- Caso alguem cadastre posteriormente "Bicicleta" como uma resposta valida, pode ser que saia para a pergunta acima as opcoes de respostas
-- com "Moto" e "Bicicleta", o que causa ambiguidade.

INSERT INTO Resposta(texto) VALUES('Um');
INSERT INTO Resposta(texto) VALUES('Dois');
INSERT INTO Resposta(texto) VALUES('Três');
INSERT INTO Resposta(texto) VALUES('Quatro');
INSERT INTO Resposta(texto) VALUES('Cinco');
INSERT INTO Resposta(texto) VALUES('Seis');
INSERT INTO Resposta(texto) VALUES('Sete');
INSERT INTO Resposta(texto) VALUES('Oito');
INSERT INTO Resposta(texto) VALUES('Nove');
INSERT INTO Resposta(texto) VALUES('Dez');

-- Tentar deixar em ordem alfabetica para facilitar novos cadastros e manutencoes.

INSERT INTO Resposta(texto) VALUES('Avião');
INSERT INTO Resposta(texto) VALUES('Açucar');
INSERT INTO Resposta(texto) VALUES('Borracha');
INSERT INTO Resposta(texto) VALUES('Brasil');
INSERT INTO Resposta(texto) VALUES('Cachorro');
INSERT INTO Resposta(texto) VALUES('Caderno');
INSERT INTO Resposta(texto) VALUES('Caneca');
INSERT INTO Resposta(texto) VALUES('Carro');
INSERT INTO Resposta(texto) VALUES('Celular');
INSERT INTO Resposta(texto) VALUES('Chocolate');
INSERT INTO Resposta(texto) VALUES('Elefante');
INSERT INTO Resposta(texto) VALUES('Futebol');
INSERT INTO Resposta(texto) VALUES('Galinha');
INSERT INTO Resposta(texto) VALUES('Internet');
INSERT INTO Resposta(texto) VALUES('Lápis');
INSERT INTO Resposta(texto) VALUES('Livro');
INSERT INTO Resposta(texto) VALUES('Lua');
INSERT INTO Resposta(texto) VALUES('Moto');
INSERT INTO Resposta(texto) VALUES('Sapato');
INSERT INTO Resposta(texto) VALUES('Televisão');
