 CREATE TABLE IF NOT EXISTS livros (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    titulo TEXT NOT NULL,
                    autor TEXT NOT NULL,
                    dataPublicacao DATE NOT NULL,
                    editora TEXT NOT NULL,
                    numeroPaginas INTEGER ,
                    edicao INTEGER NOT NULL
                );