--
-- PostgreSQL database cluster dump
--

-- Started on 2016-03-31 21:43:01

SET default_transaction_read_only = off;

SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;

--
-- Roles
--

CREATE ROLE postgres;
ALTER ROLE postgres WITH SUPERUSER INHERIT CREATEROLE CREATEDB LOGIN REPLICATION BYPASSRLS PASSWORD 'md59df270eb52907fff723d9b8b7436113a';






--
-- Database creation
--

CREATE DATABASE "myDatabase" WITH TEMPLATE = template0 OWNER = postgres;
REVOKE ALL ON DATABASE template1 FROM PUBLIC;
REVOKE ALL ON DATABASE template1 FROM postgres;
GRANT ALL ON DATABASE template1 TO postgres;
GRANT CONNECT ON DATABASE template1 TO PUBLIC;


\connect "myDatabase"

SET default_transaction_read_only = off;

--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.2
-- Dumped by pg_dump version 9.5.2

-- Started on 2016-03-31 21:43:01

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 8 (class 2615 OID 16394)
-- Name: Daytrips; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA "Daytrips";


ALTER SCHEMA "Daytrips" OWNER TO postgres;

--
-- TOC entry 1 (class 3079 OID 12355)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2125 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = "Daytrips", pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 184 (class 1259 OID 16621)
-- Name: BookInfo; Type: TABLE; Schema: Daytrips; Owner: postgres
--

CREATE TABLE "BookInfo" (
    "user" "char",
    trip "char",
    seats integer
);


ALTER TABLE "BookInfo" OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 16610)
-- Name: Daytrips; Type: TABLE; Schema: Daytrips; Owner: postgres
--

CREATE TABLE "Daytrips" (
    name "char" NOT NULL,
    comp "char",
    "PickupLocation" "char",
    "desc" "char",
    ratings integer[],
    "toRating" numeric,
    price integer,
    indiv "char"[],
    "keyWords" "char"[],
    category "char"[]
);


ALTER TABLE "Daytrips" OWNER TO postgres;

--
-- TOC entry 182 (class 1259 OID 16395)
-- Name: IndivDayTrips; Type: TABLE; Schema: Daytrips; Owner: postgres
--

CREATE TABLE "IndivDayTrips" (
    "Parent" "char" NOT NULL,
    "numSeatsAvail" integer,
    "Start" date,
    "End" date
);


ALTER TABLE "IndivDayTrips" OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 16624)
-- Name: Rating; Type: TABLE; Schema: Daytrips; Owner: postgres
--

CREATE TABLE "Rating" (
    "Daytrip" "char",
    "rateTime" date,
    rating integer,
    comment "char",
    "user" "char"
);


ALTER TABLE "Rating" OWNER TO postgres;

--
-- TOC entry 2116 (class 0 OID 16621)
-- Dependencies: 184
-- Data for Name: BookInfo; Type: TABLE DATA; Schema: Daytrips; Owner: postgres
--

COPY "BookInfo" ("user", trip, seats) FROM stdin;
\.


--
-- TOC entry 2115 (class 0 OID 16610)
-- Dependencies: 183
-- Data for Name: Daytrips; Type: TABLE DATA; Schema: Daytrips; Owner: postgres
--

COPY "Daytrips" (name, comp, "PickupLocation", "desc", ratings, "toRating", price, indiv, "keyWords", category) FROM stdin;
\.


--
-- TOC entry 2114 (class 0 OID 16395)
-- Dependencies: 182
-- Data for Name: IndivDayTrips; Type: TABLE DATA; Schema: Daytrips; Owner: postgres
--

COPY "IndivDayTrips" ("Parent", "numSeatsAvail", "Start", "End") FROM stdin;
\.


--
-- TOC entry 2117 (class 0 OID 16624)
-- Dependencies: 185
-- Data for Name: Rating; Type: TABLE DATA; Schema: Daytrips; Owner: postgres
--

COPY "Rating" ("Daytrip", "rateTime", rating, comment, "user") FROM stdin;
\.


--
-- TOC entry 1997 (class 2606 OID 16614)
-- Name: Daytrips_pkey; Type: CONSTRAINT; Schema: Daytrips; Owner: postgres
--

ALTER TABLE ONLY "Daytrips"
    ADD CONSTRAINT "Daytrips_pkey" PRIMARY KEY (name);


--
-- TOC entry 1995 (class 2606 OID 16631)
-- Name: IndivDayTrips_pkey; Type: CONSTRAINT; Schema: Daytrips; Owner: postgres
--

ALTER TABLE ONLY "IndivDayTrips"
    ADD CONSTRAINT "IndivDayTrips_pkey" PRIMARY KEY ("Parent");


--
-- TOC entry 1998 (class 2606 OID 16636)
-- Name: IndivDayTrips_Parent_fkey; Type: FK CONSTRAINT; Schema: Daytrips; Owner: postgres
--

ALTER TABLE ONLY "IndivDayTrips"
    ADD CONSTRAINT "IndivDayTrips_Parent_fkey" FOREIGN KEY ("Parent") REFERENCES "Daytrips"(name);


--
-- TOC entry 1999 (class 2606 OID 16647)
-- Name: Rating_Daytrip_fkey; Type: FK CONSTRAINT; Schema: Daytrips; Owner: postgres
--

ALTER TABLE ONLY "Rating"
    ADD CONSTRAINT "Rating_Daytrip_fkey" FOREIGN KEY ("Daytrip") REFERENCES "Daytrips"(name);


--
-- TOC entry 2124 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-03-31 21:43:01

--
-- PostgreSQL database dump complete
--

\connect postgres

SET default_transaction_read_only = off;

--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.2
-- Dumped by pg_dump version 9.5.2

-- Started on 2016-03-31 21:43:01

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2095 (class 1262 OID 12373)
-- Dependencies: 2094
-- Name: postgres; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE postgres IS 'default administrative connection database';


--
-- TOC entry 2 (class 3079 OID 12355)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2098 (class 0 OID 0)
-- Dependencies: 2
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- TOC entry 1 (class 3079 OID 16384)
-- Name: adminpack; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;


--
-- TOC entry 2099 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION adminpack; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';


--
-- TOC entry 2097 (class 0 OID 0)
-- Dependencies: 7
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-03-31 21:43:01

--
-- PostgreSQL database dump complete
--

\connect template1

SET default_transaction_read_only = off;

--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.2
-- Dumped by pg_dump version 9.5.2

-- Started on 2016-03-31 21:43:01

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2094 (class 1262 OID 1)
-- Dependencies: 2093
-- Name: template1; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE template1 IS 'default template for new databases';


--
-- TOC entry 1 (class 3079 OID 12355)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2097 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- TOC entry 2096 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-03-31 21:43:01

--
-- PostgreSQL database dump complete
--

-- Completed on 2016-03-31 21:43:01

--
-- PostgreSQL database cluster dump complete
--

