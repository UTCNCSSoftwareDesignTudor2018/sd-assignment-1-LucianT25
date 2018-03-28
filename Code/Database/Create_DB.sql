--
-- PostgreSQL database dump
--

-- Dumped from database version 10.3
-- Dumped by pg_dump version 10.3

-- Started on 2018-03-28 15:23:19

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
-- TOC entry 1 (class 3079 OID 12924)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2840 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 199 (class 1259 OID 16413)
-- Name: Course; Type: TABLE; Schema: public; Owner: Lucian Turcu
--

CREATE TABLE public."Course" (
    id integer NOT NULL,
    name text NOT NULL,
    year integer,
    credits integer
);


ALTER TABLE public."Course" OWNER TO "Lucian Turcu";

--
-- TOC entry 198 (class 1259 OID 16411)
-- Name: Course_id_seq; Type: SEQUENCE; Schema: public; Owner: Lucian Turcu
--

CREATE SEQUENCE public."Course_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Course_id_seq" OWNER TO "Lucian Turcu";

--
-- TOC entry 2841 (class 0 OID 0)
-- Dependencies: 198
-- Name: Course_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Lucian Turcu
--

ALTER SEQUENCE public."Course_id_seq" OWNED BY public."Course".id;


--
-- TOC entry 201 (class 1259 OID 16424)
-- Name: Enrollment; Type: TABLE; Schema: public; Owner: "Lucian Turcu"
--

CREATE TABLE public."Enrollment" (
    id integer NOT NULL,
    student_id integer NOT NULL,
    course_id integer NOT NULL,
    grade double precision
);


ALTER TABLE public."Enrollment" OWNER TO "Lucian Turcu";

--
-- TOC entry 196 (class 1259 OID 16395)
-- Name: Student; Type: TABLE; Schema: public; Owner: Lucian Turcu
--

CREATE TABLE public."Student" (
    id integer NOT NULL,
    name name NOT NULL,
    address text,
    email text,
    pnc bigint,
    year integer
);


ALTER TABLE public."Student" OWNER TO "Lucian Turcu";

--
-- TOC entry 197 (class 1259 OID 16403)
-- Name: Teacher; Type: TABLE; Schema: public; Owner: Lucian Turcu
--

CREATE TABLE public."Teacher" (
    id integer NOT NULL,
    name name NOT NULL,
    address text,
    email text,
    course_id integer
);


ALTER TABLE public."Teacher" OWNER TO "Lucian Turcu";

--
-- TOC entry 203 (class 1259 OID 16444)
-- Name: User; Type: TABLE; Schema: public; Owner: Lucian Turcu
--

CREATE TABLE public."User" (
    id integer NOT NULL,
    username text NOT NULL,
    password text NOT NULL,
    usertype text NOT NULL
);


ALTER TABLE public."User" OWNER TO "Lucian Turcu";

--
-- TOC entry 202 (class 1259 OID 16442)
-- Name: User_id_seq; Type: SEQUENCE; Schema: public; Owner: Lucian Turcu
--

CREATE SEQUENCE public."User_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."User_id_seq" OWNER TO "Lucian Turcu";

--
-- TOC entry 2842 (class 0 OID 0)
-- Dependencies: 202
-- Name: User_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: "Lucian Turcu"
--

ALTER SEQUENCE public."User_id_seq" OWNED BY public."User".id;


--
-- TOC entry 200 (class 1259 OID 16422)
-- Name: enrollment_id_seq; Type: SEQUENCE; Schema: public; Owner: "Lucian Turcu"
--

CREATE SEQUENCE public.enrollment_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.enrollment_id_seq OWNER TO "Lucian Turcu";

--
-- TOC entry 2843 (class 0 OID 0)
-- Dependencies: 200
-- Name: enrollment_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: "Lucian Turcu"
--

ALTER SEQUENCE public.enrollment_id_seq OWNED BY public."Enrollment".id;


--
-- TOC entry 2694 (class 2604 OID 16416)
-- Name: Course id; Type: DEFAULT; Schema: public; Owner: Lucian Turcu
--

ALTER TABLE ONLY public."Course" ALTER COLUMN id SET DEFAULT nextval('public."Course_id_seq"'::regclass);


--
-- TOC entry 2695 (class 2604 OID 16427)
-- Name: Enrollment id; Type: DEFAULT; Schema: public; Owner: "Lucian Turcu"
--

ALTER TABLE ONLY public."Enrollment" ALTER COLUMN id SET DEFAULT nextval('public.enrollment_id_seq'::regclass);


--
-- TOC entry 2696 (class 2604 OID 16447)
-- Name: User id; Type: DEFAULT; Schema: public; Owner: "Lucian Turcu"
--

ALTER TABLE ONLY public."User" ALTER COLUMN id SET DEFAULT nextval('public."User_id_seq"'::regclass);


--
-- TOC entry 2702 (class 2606 OID 16421)
-- Name: Course Course_pkey; Type: CONSTRAINT; Schema: public; Owner: Lucian Turcu
--

ALTER TABLE ONLY public."Course"
    ADD CONSTRAINT "Course_pkey" PRIMARY KEY (id);


--
-- TOC entry 2698 (class 2606 OID 16402)
-- Name: Student Student_pkey; Type: CONSTRAINT; Schema: public; Owner: Lucian Turcu
--

ALTER TABLE ONLY public."Student"
    ADD CONSTRAINT "Student_pkey" PRIMARY KEY (id);


--
-- TOC entry 2700 (class 2606 OID 16410)
-- Name: Teacher Teacher_pkey; Type: CONSTRAINT; Schema: public; Owner: Lucian Turcu
--

ALTER TABLE ONLY public."Teacher"
    ADD CONSTRAINT "Teacher_pkey" PRIMARY KEY (id);


--
-- TOC entry 2708 (class 2606 OID 16452)
-- Name: User User_pkey; Type: CONSTRAINT; Schema: public; Owner: "Lucian Turcu"
--

ALTER TABLE ONLY public."User"
    ADD CONSTRAINT "User_pkey" PRIMARY KEY (id);


--
-- TOC entry 2704 (class 2606 OID 16429)
-- Name: Enrollment enrollment_pkey; Type: CONSTRAINT; Schema: public; Owner: "Lucian Turcu"
--

ALTER TABLE ONLY public."Enrollment"
    ADD CONSTRAINT enrollment_pkey PRIMARY KEY (id);


--
-- TOC entry 2705 (class 1259 OID 16441)
-- Name: fki_fk_course_id; Type: INDEX; Schema: public; Owner: "Lucian Turcu"
--

CREATE INDEX fki_fk_course_id ON public."Enrollment" USING btree (course_id);


--
-- TOC entry 2706 (class 1259 OID 16435)
-- Name: fki_pk_student_id; Type: INDEX; Schema: public; Owner: "Lucian Turcu"
--

CREATE INDEX fki_pk_student_id ON public."Enrollment" USING btree (student_id);


--
-- TOC entry 2711 (class 2606 OID 16436)
-- Name: Enrollment fk_course_id; Type: FK CONSTRAINT; Schema: public; Owner: "Lucian Turcu"
--

ALTER TABLE ONLY public."Enrollment"
    ADD CONSTRAINT fk_course_id FOREIGN KEY (course_id) REFERENCES public."Course"(id);


--
-- TOC entry 2709 (class 2606 OID 16453)
-- Name: Teacher fk_course_id; Type: FK CONSTRAINT; Schema: public; Owner: "Lucian Turcu"
--

ALTER TABLE ONLY public."Teacher"
    ADD CONSTRAINT fk_course_id FOREIGN KEY (course_id) REFERENCES public."Course"(id);


--
-- TOC entry 2710 (class 2606 OID 16430)
-- Name: Enrollment fk_student_id; Type: FK CONSTRAINT; Schema: public; Owner: "Lucian Turcu"
--

ALTER TABLE ONLY public."Enrollment"
    ADD CONSTRAINT fk_student_id FOREIGN KEY (student_id) REFERENCES public."Student"(id);


-- Completed on 2018-03-28 15:23:19

--
-- PostgreSQL database dump complete
--

