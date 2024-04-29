# Create database

run --name abcelectronics -e POSTGRES_USER=abcelectronics -e POSTGRES_PASSWORD=password -e POSTGRES_DB=abcelectronics_customers_orders -p 5434:5432 -d postgres