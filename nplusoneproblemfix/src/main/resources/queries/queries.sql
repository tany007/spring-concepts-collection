-- Create customer table
CREATE TABLE customer (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Insert dummy data into customer table
INSERT INTO customer (name) VALUES
('John Doe'),
('Jane Smith'),
('Alice Johnson'),
('Bob Brown');

-- Create address table
CREATE TABLE address (
    id SERIAL PRIMARY KEY,
    city VARCHAR(255) NOT NULL,
    state VARCHAR(255) NOT NULL,
    zip_code VARCHAR(20) NOT NULL,
    customer_id BIGINT NOT NULL,
    CONSTRAINT fk_customer FOREIGN KEY (customer_id) REFERENCES customer (id) ON DELETE CASCADE
);

-- Insert dummy data into address table
INSERT INTO address (city, state, zip_code, customer_id) VALUES
('New York', 'NY', '10001', 1),
('Los Angeles', 'CA', '90001', 2),
('Chicago', 'IL', '60601', 3),
('Houston', 'TX', '77001', 4);


-- Insert additional dummy data into address table
INSERT INTO address (city, state, zip_code, customer_id) VALUES
('San Francisco', 'CA', '94101', 1), -- Additional address for customer 1
('Brooklyn', 'NY', '11201', 1),      -- Additional address for customer 1
('Austin', 'TX', '73301', 2),        -- Additional address for customer 2
('Dallas', 'TX', '75201', 2),        -- Additional address for customer 2
('Seattle', 'WA', '98101', 3),       -- Additional address for customer 3
('Boston', 'MA', '02101', 4);        -- Additional address for customer 4