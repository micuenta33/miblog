INSERT INTO posts (title, url_img, description, created_date) VALUES ('Cuatro recetas de preparar Tortitas de avena', 'http://localhost:63342/ejemploweb/static/img/huevo.jpg', 'Descripción del primer post', DATE '2022-01-01')
INSERT INTO posts (title, url_img, description, created_date) VALUES ('Título del primer post', 'https://3.bp.blogspot.com/-s2MezUWS2Xs/WqRv9mjmjJI/AAAAAAAABXc/RZ2SEikIh8shQ-WcoG6Uogb3T8XN8YluQCLcBGAs/s1600/avena-cabello.jpg', 'Descripción del primer post', DATE '2022-01-01')
INSERT INTO posts (title, url_img, description, created_date) VALUES ('Título del primer post', '', 'Descripción del primer post', DATE '2022-01-01')
INSERT INTO posts (title, url_img, description, created_date) VALUES ('Título del primer post', 'https://example.com/imagen1.jpg', 'Descripción del primer post', DATE '2022-01-01')
INSERT INTO posts (title, url_img, description, created_date) VALUES ('Título del primer post', 'http://localhost:63342/ejemploweb/static/img/huevo.jpg', 'Descripción del primer post', DATE '2022-01-01')

-- Insertar registros en la tabla users
INSERT INTO users (user_name, last_name, first_name, password, email, user_rol, register_date) VALUES('johndoe', 'Doe', 'John', '123456', 'johndoe@example.com', 'ADMIN', '2022-05-11')
INSERT INTO users (user_name, last_name, first_name, password, email, user_rol, register_date) VALUES('janedoe', 'Doe', 'Jane', '654321', 'janedoe@example.com', 'USER', '2022-05-12')


-- Insertar registros en la tabla category_posts
INSERT INTO category_posts (description) VALUES ('Deportes')
INSERT INTO category_posts (description) VALUES ('Nutrición')
INSERT INTO category_posts (description) VALUES ('Entrenamiento')