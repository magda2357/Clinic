CREATE TABLE procedure
(
    id                 BIGSERIAL PRIMARY KEY,
    chapter_id          VARCHAR(4),
    chapter            VARCHAR(100),
    subchapter_id       VARCHAR(5),
    subchapter         VARCHAR(200),
    main_category_id     VARCHAR(8),
    main_category       VARCHAR(300),
    detailed_category_id VARCHAR(8),
    detailed_category   VARCHAR(300)
);