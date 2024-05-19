CREATE TABLE tt_tasks (
    id UUID NOT NULL,
    task VARCHAR NOT NULL,
    important BOOLEAN NOT NULL,
    checked BOOLEAN NOT NULL,
    date TIMESTAMP NOT NULL,
    PRIMARY KEY (id)
);
