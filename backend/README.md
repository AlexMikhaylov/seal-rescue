# Seal Rescue Project: Backend

## Look into the PostgreSQL Container

To access the PostgreSQL container and inspect the database, follow these steps:

1. **Execute the following command to get into the PostgreSQL container:**

    ```bash
    docker exec -ti CONTAINER_NAME psql -U seal sealrescue
    ```

   or

    ```bash
    docker exec -it CONTAINER_NAME psql -d sealrescue -U seal
    ```

2. **Once inside the PostgreSQL prompt, you can run the following commands:**

    - To list all tables:
        ```sql
        \dt
        ```

    - To view the data in the `regions` table:
        ```sql
        SELECT * FROM regions;
        ```

    - To view the data in the `countries` table:
        ```sql
        SELECT * FROM countries;
        ```
