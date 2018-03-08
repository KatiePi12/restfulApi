RESTFUL APPLICATION EXAMPLE
===========================
1. Requirements for running the project
---------------------------------------
	- instalation of postgres server v.10
	- instalation of jdk v.1.8
	- instalation of IntellijIdea
	- instalation of Curl
2. Setting up database
----------------------
	- run psql
	- use standard settings to connect postgres server via psql
	- create database for application by script: 
	```bash
	CREATE DATABASE note_db;
	```
	- create connection to database by command: 
	```bash
	\c note_db
	```
	- run script to initialize database schema by copying it from "init-script.sql" and paste into psql
3. Building and running project
-------------------------------
	- import project to IntellijIdea (use schema of maven project)
	- let IntellijIdea automatically download project dependencies
	- compile project using maven to generate .class files
	- run project using command "Run '{application_name}'" from menu bar or use keyboard shortcut - "shift + F10"
4. Example usages (using Curl)
------------------------------
First of all, open terminal to work with Curl.
	- add new note:
	```bash
	curl -i -H "Content-Type: application/json" --data @addNote.json http://localhost:8080/addNote
	```
	- get all added notes:
	```bash
	curl -i http://localhost:8080/getAllNotes
	```
	- update note: 
	```bash
	curl -i -H "Content-Type: application/json" -X PUT --data @updateNote.json http://localhost:8080/updateNote
	```
	- delete note:
	```bash
	curl -i -X DELETE http://localhost:8080/deleteNote/1
	```
! Files from 'JSON' folder (addNote.json and updateNote.json) should be copied into path where curl program is working. !
