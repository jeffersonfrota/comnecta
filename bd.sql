
-- Estrutura BD

CREATE TABLE cartao
(
    numero bigint NOT NULL,
    cod_seguranca integer NOT NULL,
    data_vencimento date NOT NULL,
    cpf_cnpj_conta VARCHAR(15) NOT NULL
);

CREATE TABLE categoria
(
    url_live character varying(100) COLLATE pg_catalog."default" NOT NULL,
    nome character varying(100) COLLATE pg_catalog."default" NOT NULL
);

CREATE TABLE comentario
(
    url_live character varying(100) COLLATE pg_catalog."default" NOT NULL,
    comentario character varying(200) COLLATE pg_catalog."default",
    cpf_cnpj_viewer VARCHAR(15) NOT NULL
);


CREATE TABLE conta
(
    cpf_cnpj VARCHAR(15) NOT NULL,
    nome character varying(100) COLLATE pg_catalog."default" NOT NULL,
    email character varying(80) COLLATE pg_catalog."default" NOT NULL,
    nacionalidade character varying(40) COLLATE pg_catalog."default" NOT NULL,
    num_seguidores integer,
    status character varying(5) COLLATE pg_catalog."default" NOT NULL,
    descricao character varying(500) COLLATE pg_catalog."default"NOT NULL
);

CREATE TABLE conta_bancaria
(
    cpf_cnpj_streamer VARCHAR(15) NOT NULL,
    agencia integer NOT NULL,
    conta bigint NOT NULL,
    banco character varying(40) COLLATE pg_catalog."default" NOT NULL
);

CREATE TABLE conta_live
(
    cpf_cnpj_conta VARCHAR(15) NOT NULL,
    url_live character varying(100) COLLATE pg_catalog."default" NOT NULL
);

CREATE TABLE conta_streamer
(
    cpf_cnpj_streamer VARCHAR(15) NOT NULL,
    cpf_cnpj_conta VARCHAR(15) NOT NULL
);

CREATE TABLE live
(
    url character varying(100) COLLATE pg_catalog."default" NOT NULL,
    titulo character varying(100) COLLATE pg_catalog."default" NOT NULL,
    num_visualizacoes integer,
    data_live date NOT NULL,
    duracao integer NOT NULL,
    cpf_cnpj_streamer VARCHAR(15) NOT NULL
);

CREATE TABLE patrocinador
(
    cnpj VARCHAR(15) NOT NULL,
    razao_social character varying(100) COLLATE pg_catalog."default" NOT NULL
);

CREATE TABLE patrocinador_streamer
(
    cnpj_patrocinador VARCHAR(15) NOT NULL,
    cpf_cnpj_streamer VARCHAR(15) NOT NULL,
    valor_investido double precision
);

CREATE TABLE presente
(
    url_live character varying(100) COLLATE pg_catalog."default" NOT NULL,
    nome_presente character varying(50) COLLATE pg_catalog."default" NOT NULL,
    valor double precision NOT NULL
);

CREATE TABLE rede_social
(
    cpf_cnpj_conta VARCHAR(15) NOT NULL,
    link character varying(100) COLLATE pg_catalog."default" NOT NULL,
    nome_redesocial character varying(100) COLLATE pg_catalog."default" NOT NULL
);

CREATE TABLE seguir
(
    seguido VARCHAR(15) NOT NULL,
    seguidor VARCHAR(15) NOT NULL
);

CREATE TABLE streamer
(
    cpf_cnpj_streamer VARCHAR(15) NOT NULL,
    cpf_cnpj_conta VARCHAR(15) NOT NULL,
    num_visualizacoes integer NOT NULL
);

CREATE TABLE viewer
(
    cpf_cnpj_viewer VARCHAR(15) NOT NULL,
    cpf_cnpj_conta VARCHAR(15) NOT NULL
);


-- PRIMARYS KEYS
ALTER TABLE patrocinador
    ADD CONSTRAINT cnpj_pkey PRIMARY KEY(cnpj);

ALTER TABLE patrocinador_streamer
    ADD CONSTRAINT cnpj_patrocinador_cpf_cnpj_streamer_pkey PRIMARY KEY(cnpj_patrocinador, cpf_cnpj_streamer);

ALTER TABLE presente
    ADD CONSTRAINT url_live_nome_presente_pkey PRIMARY KEY(url_live, nome_presente);

ALTER TABLE rede_social
    ADD CONSTRAINT cpf_cnpj_conta_link_pkey PRIMARY KEY(cpf_cnpj_conta, link);

ALTER TABLE viewer
    ADD CONSTRAINT cpf_cnpj_viewer_pkey PRIMARY KEY(cpf_cnpj_viewer);

ALTER TABLE streamer
    ADD CONSTRAINT cpf_cnpj_streamer_pkey PRIMARY KEY(cpf_cnpj_streamer);

ALTER TABLE seguir
    ADD CONSTRAINT seguido_seguidor_pkey PRIMARY KEY(seguido, seguidor);

ALTER TABLE  cartao
    ADD CONSTRAINT numero_cpf_cnpj_pkey PRIMARY KEY(numero, cpf_cnpj_conta);

ALTER TABLE categoria
    ADD CONSTRAINT url_live_nome_pkey PRIMARY KEY(url_live, nome);

ALTER TABLE comentario
    ADD CONSTRAINT url_live_comentario_pkey PRIMARY KEY (url_live, comentario);
    
ALTER TABLE conta
    ADD CONSTRAINT cnpj_cnpj_pkey PRIMARY KEY (cpf_cnpj);

ALTER TABLE conta_bancaria
    ADD CONSTRAINT cnpj_cnpj_streamer_conta_pkey PRIMARY KEY (cpf_cnpj_streamer, conta);

ALTER TABLE live
    ADD CONSTRAINT url_pkey PRIMARY KEY(url);



-- FOREIGNS KEYS


ALTER TABLE  cartao
    ADD CONSTRAINT cartao_cpf_cnpj_conta_fkey FOREIGN KEY (cpf_cnpj_conta)
    REFERENCES conta (cpf_cnpj);


ALTER TABLE  categoria
    ADD CONSTRAINT categoria_url_live_fkey FOREIGN KEY (url_live)
    REFERENCES live (url) ;


ALTER TABLE  comentario
    ADD CONSTRAINT comentarios_url_live_fkey FOREIGN KEY (url_live)
    REFERENCES live (url) ;


ALTER TABLE  conta_bancaria
    ADD CONSTRAINT conta_bancaria_cpf_cnpj_streamer_fkey FOREIGN KEY (cpf_cnpj_streamer)
    REFERENCES streamer (cpf_cnpj_streamer) ;


ALTER TABLE  conta_live
    ADD CONSTRAINT conta_live_url_live_fkey FOREIGN KEY (url_live)
    REFERENCES live (url) ;


ALTER TABLE  conta_streamer
    ADD CONSTRAINT conta_streamer_cpf_cnpj_conta_fkey FOREIGN KEY (cpf_cnpj_conta)
    REFERENCES conta(cpf_cnpj) ;


ALTER TABLE  conta_streamer
    ADD CONSTRAINT conta_streamer_cpfcnpj_streamer_fkey FOREIGN KEY (cpf_cnpj_streamer)
    REFERENCES streamer (cpf_cnpj_streamer) ;


ALTER TABLE  live
    ADD CONSTRAINT live_cpf_cnpj_streamer_fkey FOREIGN KEY (cpf_cnpj_streamer)
    REFERENCES streamer(cpf_cnpj_streamer) ;


ALTER TABLE  patrocinador_streamer
    ADD CONSTRAINT patrocinador_streamer_cnpj_patrocinador_fkey FOREIGN KEY (cnpj_patrocinador)
    REFERENCES patrocinador (cnpj) ;


ALTER TABLE  patrocinador_streamer
    ADD CONSTRAINT patrocinador_streamer_cpf_cnpj_streamer_fkey FOREIGN KEY (cpf_cnpj_streamer)
    REFERENCES streamer(cpf_cnpj_streamer) ;


ALTER TABLE  presente
    ADD CONSTRAINT presentes_url_live_fkey FOREIGN KEY (url_live)
    REFERENCES live (url) ;


ALTER TABLE  rede_social
    ADD CONSTRAINT redes_sociais_cpf_cnpj_conta_fkey FOREIGN KEY (cpf_cnpj_conta)
    REFERENCES conta (cpf_cnpj) ;


ALTER TABLE  seguir
    ADD CONSTRAINT seguir_seguido_fkey FOREIGN KEY (seguido)
    REFERENCES conta (cpf_cnpj);


ALTER TABLE  seguir
    ADD CONSTRAINT seguir_seguidor_fkey FOREIGN KEY (seguidor)
    REFERENCES conta (cpf_cnpj);

ALTER TABLE  streamer
    ADD CONSTRAINT streamer_cpf_cnpj_fkey FOREIGN KEY (cpf_cnpj_streamer)
    REFERENCES conta (cpf_cnpj) ;


ALTER TABLE  viewer
    ADD CONSTRAINT viewer_cpf_cnpj_fkey FOREIGN KEY (cpf_cnpj_viewer)
    REFERENCES conta (cpf_cnpj) ;
