CREATE OR REPLACE PROCEDURE create_person(
    name_param VARCHAR(255),
    age_param INT
)
LANGUAGE plpgsql
AS $$
DECLARE
    next_id INT;
BEGIN
    -- Obter o próximo valor da sequência
    SELECT NEXTVAL('public.person_seq') INTO next_id;
    
    -- Inserir na tabela usando o próximo valor da sequência
    INSERT INTO public.person(id, "name", age)
    VALUES (next_id, name_param, age_param);
END;
$$;