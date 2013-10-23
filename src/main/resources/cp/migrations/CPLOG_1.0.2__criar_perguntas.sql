-- Perguntas referenciando somente a resposta correta. As demais serao 
-- aleatoriamente escolhidas para serem exibidas em tela.
-- Assim, tomar cuidado para nao obtermos respostas redundantes.

INSERT INTO Pergunta(texto, resposta_id) VALUES( 'Quanto é 3 mais 1?', 											(SELECT id FROM Resposta WHERE texto='Quatro') );
INSERT INTO Pergunta(texto, resposta_id) VALUES( 'Qual dos itens abaixo contém cacau em sua composição?', 						(SELECT id FROM Resposta WHERE texto='Chocolate') );
INSERT INTO Pergunta(texto, resposta_id) VALUES( 'Quanto é 5 mais 5?', 											(SELECT id FROM Resposta WHERE texto='Dez') );
INSERT INTO Pergunta(texto, resposta_id) VALUES( 'Qual dos itens abaixo é um meio de transporte que contém 4 rodas?', 					(SELECT id FROM Resposta WHERE texto='Carro') );
INSERT INTO Pergunta(texto, resposta_id) VALUES( 'Qual o nome do satélite natural de nosso planeta Terra?', 						(SELECT id FROM Resposta WHERE texto='Lua') );
INSERT INTO Pergunta(texto, resposta_id) VALUES( 'Qual animal late e é o melhor amigo do homem?', 							(SELECT id FROM Resposta WHERE texto='Cachorro') );
INSERT INTO Pergunta(texto, resposta_id) VALUES( 'Qual país é conhecido pelo Futebol e Carnaval/Samba?',						(SELECT id FROM Resposta WHERE texto='Brasil') );
INSERT INTO Pergunta(texto, resposta_id) VALUES( 'Qual é o meio de transporte que voa?',								(SELECT id FROM Resposta WHERE texto='Avião') );
INSERT INTO Pergunta(texto, resposta_id) VALUES( 'Qual é a Rede Mundial de Computadores?',								(SELECT id FROM Resposta WHERE texto='Internet') );
INSERT INTO Pergunta(texto, resposta_id) VALUES( 'Qual item escolar é composto de madeira, grafite e pode-se apontá-lo?',				(SELECT id FROM Resposta WHERE texto='Lápis') );
INSERT INTO Pergunta(texto, resposta_id) VALUES( 'Com qual item escolar pode-se apagar textos a lápis e é composto por Látex?',				(SELECT id FROM Resposta WHERE texto='Borracha') );
INSERT INTO Pergunta(texto, resposta_id) VALUES( 'Com qual aparelho físico eletrônico é possível ligar e conversar com outras pessoas a distância?',	(SELECT id FROM Resposta WHERE texto='Celular') );
INSERT INTO Pergunta(texto, resposta_id) VALUES( 'Com qual item abaixo é possível adoçar alimentos e líquidos?',					(SELECT id FROM Resposta WHERE texto='Açucar') );
INSERT INTO Pergunta(texto, resposta_id) VALUES( 'Qual dos itens abaixo possue folhas de papel, capa, e podemos ler histórias?',			(SELECT id FROM Resposta WHERE texto='Livro') );
INSERT INTO Pergunta(texto, resposta_id) VALUES( 'Qual dos itens abaixo é um esporte com 2 times, 22 jogadores, uma bola e podemos marcar "gol"?',	(SELECT id FROM Resposta WHERE texto='Futebol') );
INSERT INTO Pergunta(texto, resposta_id) VALUES( 'Qual dos itens abaixo calçamos um nossos pés?',                                                       (SELECT id FROM Resposta WHERE texto='Sapato') );
INSERT INTO Pergunta(texto, resposta_id) VALUES( 'Qual dos itens abaixo é um meio de transporte que contém 2 rodas?',                                   (SELECT id FROM Resposta WHERE texto='Moto') );
INSERT INTO Pergunta(texto, resposta_id) VALUES( 'Quanto é 3 mais 2?', 											(SELECT id FROM Resposta WHERE texto='Cinco') );
INSERT INTO Pergunta(texto, resposta_id) VALUES( 'Qual dos itens abaixo é um animal que bota ovos?', 							(SELECT id FROM Resposta WHERE texto='Galinha') );
INSERT INTO Pergunta(texto, resposta_id) VALUES( 'Quanto é 8 mais 2?', 											(SELECT id FROM Resposta WHERE texto='Dez') );
