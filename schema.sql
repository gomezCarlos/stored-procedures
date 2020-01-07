--
-- PostgreSQL database dump
--

-- Dumped from database version 12.1
-- Dumped by pg_dump version 12.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: carlos; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA carlos;


ALTER SCHEMA carlos OWNER TO postgres;

--
-- Name: fetch_empty_courses(refcursor); Type: FUNCTION; Schema: carlos; Owner: postgres
--

CREATE FUNCTION carlos.fetch_empty_courses(course_cursor refcursor) RETURNS refcursor
    LANGUAGE plpgsql
    AS $$
BEGIN
OPEN course_cursor FOR SELECT * FROM carlos.course c WHERE c.id NOT IN (SELECT course_id FROM carlos.course_students);
RETURN course_cursor;
END; 
$$;


ALTER FUNCTION carlos.fetch_empty_courses(course_cursor refcursor) OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: course; Type: TABLE; Schema: carlos; Owner: postgres
--

CREATE TABLE carlos.course (
    id bigint NOT NULL,
    code character varying(255),
    name character varying(255)
);


ALTER TABLE carlos.course OWNER TO postgres;

--
-- Name: course_students; Type: TABLE; Schema: carlos; Owner: postgres
--

CREATE TABLE carlos.course_students (
    course_id bigint NOT NULL,
    students_id bigint NOT NULL
);


ALTER TABLE carlos.course_students OWNER TO postgres;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: carlos; Owner: postgres
--

CREATE SEQUENCE carlos.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE carlos.hibernate_sequence OWNER TO postgres;

--
-- Name: student; Type: TABLE; Schema: carlos; Owner: postgres
--

CREATE TABLE carlos.student (
    id bigint NOT NULL,
    address character varying(255),
    first_name character varying(255) NOT NULL,
    last_name character varying(255) NOT NULL,
    rut character varying(255) NOT NULL
);


ALTER TABLE carlos.student OWNER TO postgres;

--
-- Data for Name: course; Type: TABLE DATA; Schema: carlos; Owner: postgres
--

COPY carlos.course (id, code, name) FROM stdin;
4	P04	Non Lineal Programming
5	P01	Programming
6	P02	Programming II
\.


--
-- Data for Name: course_students; Type: TABLE DATA; Schema: carlos; Owner: postgres
--

COPY carlos.course_students (course_id, students_id) FROM stdin;
6	3
\.


--
-- Data for Name: student; Type: TABLE DATA; Schema: carlos; Owner: postgres
--

COPY carlos.student (id, address, first_name, last_name, rut) FROM stdin;
1	Santiago	Carlos	Gomez	26.048.305-6
2	Santiago	Carlos Manuel	Gomez	27.000.621-3
3	Independencia	Janiret	Valerio	26.120.609-9
\.


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: carlos; Owner: postgres
--

SELECT pg_catalog.setval('carlos.hibernate_sequence', 6, true);


--
-- Name: course course_pkey; Type: CONSTRAINT; Schema: carlos; Owner: postgres
--

ALTER TABLE ONLY carlos.course
    ADD CONSTRAINT course_pkey PRIMARY KEY (id);


--
-- Name: student student_pkey; Type: CONSTRAINT; Schema: carlos; Owner: postgres
--

ALTER TABLE ONLY carlos.student
    ADD CONSTRAINT student_pkey PRIMARY KEY (id);


--
-- Name: course_students uk_mbgdvunvf0vnr9e2e8k8yvu0s; Type: CONSTRAINT; Schema: carlos; Owner: postgres
--

ALTER TABLE ONLY carlos.course_students
    ADD CONSTRAINT uk_mbgdvunvf0vnr9e2e8k8yvu0s UNIQUE (students_id);


--
-- Name: course_students fk532dg5ikp3dvbrbiiqefdoe6m; Type: FK CONSTRAINT; Schema: carlos; Owner: postgres
--

ALTER TABLE ONLY carlos.course_students
    ADD CONSTRAINT fk532dg5ikp3dvbrbiiqefdoe6m FOREIGN KEY (students_id) REFERENCES carlos.student(id);


--
-- Name: course_students fkgut5xj4l8sk6hg3l0t2su2pnc; Type: FK CONSTRAINT; Schema: carlos; Owner: postgres
--

ALTER TABLE ONLY carlos.course_students
    ADD CONSTRAINT fkgut5xj4l8sk6hg3l0t2su2pnc FOREIGN KEY (course_id) REFERENCES carlos.course(id);


--
-- PostgreSQL database dump complete
--

