INSERT INTO category(id, name, description) values (1, 'Elektronika', 'Bardzo fajne przedmioty');
INSERT INTO category(id, name,description) values (2, 'Meble', 'Najlepsze meble');



INSERT INTO offer(id, title, description, image_url, price, category_id)
VALUES (1, 'Telewizor', 'Super telewizor o przekątnej 55 cali', 'http://blabla2.jpg', 1600, 1);

INSERT INTO offer(id, title, description, image_url, price, category_id)
VALUES (2, 'Kino domowe', 'Wypasione kino domowe firmy Sony, gra tak, że można robić festyn', 'http://blabla3.jpg', 799, 1);

INSERT INTO offer(id, title, description, image_url, price, category_id)
VALUES (3, 'Stół drewniany', 'Idealny stół drewniany dla rodziny, 6 krzeseł gratis', 'http://blabla3.jpg', 2899, 2);