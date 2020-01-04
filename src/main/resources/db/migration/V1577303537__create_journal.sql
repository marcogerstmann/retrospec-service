CREATE TABLE journal (
    id uuid PRIMARY KEY,
    name varchar,
    created_at timestamptz,
    created_by varchar,
    changed_at timestamptz,
    changed_by varchar
);
