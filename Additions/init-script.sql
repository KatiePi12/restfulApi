CREATE SEQUENCE public.note_id_sequence
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

CREATE TABLE public.note (
	id           INTEGER NOT NULL DEFAULT nextval('note_id_sequence'),
  title        VARCHAR(30) NOT NULL,
  content      VARCHAR(50) NOT NULL,
  created      TIMESTAMP,
  modified     TIMESTAMP,
	CONSTRAINT note_id_pk PRIMARY KEY ( id )
 );	

CREATE OR REPLACE FUNCTION insert_note_creation_time()
    RETURNS trigger AS
$BODY$
BEGIN
    UPDATE note
		SET created = now()
		WHERE id = NEW.id;
    RETURN NEW;
END;
$BODY$

LANGUAGE plpgsql;

CREATE TRIGGER insert_note 
	AFTER INSERT ON note
		FOR EACH ROW
			EXECUTE PROCEDURE insert_note_creation_time();

CREATE OR REPLACE FUNCTION update_note_modified_time()
    RETURNS trigger AS
$BODY$
BEGIN
	IF NEW.title <> OLD.title OR NEW.content <> OLD.content THEN
    UPDATE note
		SET modified = now()
		WHERE id = NEW.id;
    END IF;
	
	RETURN NEW;
END;
$BODY$

LANGUAGE plpgsql;

CREATE TRIGGER update_note 
	AFTER UPDATE ON note
		FOR EACH ROW
			EXECUTE PROCEDURE update_note_modified_time();
