--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.9
-- Dumped by pg_dump version 9.6.9

-- Started on 2018-06-03 21:56:50

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE ics1175;
--
-- TOC entry 2123 (class 1262 OID 16384)
-- Name: ics1175; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE ics1175 WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252' LC_CTYPE = 'English_United States.1252';


ALTER DATABASE ics1175 OWNER TO postgres;

\connect ics1175

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12387)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2126 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 185 (class 1259 OID 16391)
-- Name: literals; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.literals (
    literal text
);


ALTER TABLE public.literals OWNER TO postgres;

--
-- TOC entry 2117 (class 0 OID 16391)
-- Dependencies: 185
-- Data for Name: literals; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.literals (literal) FROM stdin;
North Atlantic Ocean
Scorpio scorpio
Mediterranean Sea
Doplhinus aurius
Pacific Ocean
Pacific Ocean
Greece
Brazil
Yellowfin Tuna
Thunnus alalunga
China
Mediterranean Sea
USA
South Atlantic Ocean
Dolphin
Thunnus albacares
\.


--
-- TOC entry 2125 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2018-06-03 21:56:50

--
-- PostgreSQL database dump complete
--

