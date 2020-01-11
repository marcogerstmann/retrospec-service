create table user_account (
    id uuid primary key,
    email varchar unique not null,
    first_name varchar,
    last_name varchar,
    created_at timestamptz,
    created_by varchar,
    changed_at timestamptz,
    changed_by varchar
);

create table user_setting (
    id uuid primary key,
    user_id uuid references user_account(id) unique not null,
    language varchar,
    created_at timestamptz,
    created_by varchar,
    changed_at timestamptz,
    changed_by varchar
);

create table habit (
    id uuid primary key,
    user_id uuid references user_account(id) not null,
    name varchar,
    created_at timestamptz,
    created_by varchar,
    changed_at timestamptz,
    changed_by varchar
);

create table daily_journal (
    id uuid primary key,
    user_id uuid references user_account(id) not null,
    log_date date not null default current_date,
    mood_points smallint,
    habits json,
    created_at timestamptz,
    created_by varchar,
    changed_at timestamptz,
    changed_by varchar
);

create table daily_bullet (
    id uuid primary key,
    daily_journal_id uuid references daily_journal(id) not null,
    text text not null,
    created_at timestamptz,
    created_by varchar,
    changed_at timestamptz,
    changed_by varchar
);

create table weekly_retrospective (
    id uuid primary key,
    user_id uuid references user_account(id) not null,
    log_date date not null default current_date,
    created_at timestamptz,
    created_by varchar,
    changed_at timestamptz,
    changed_by varchar
);
