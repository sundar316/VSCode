# IMPORTANT: Create DB with this same name "food_ordering_system", before running this script

import mysql.connector

# Establishing a connection to the MySQL database
db = mysql.connector.connect(
    host="localhost",
    user="root", # Enter username of MySql DB
    password="Sundar@16", # Enter password of MySql DB
    database="food_ordering_system"
)

# Creating a cursor object to interact with the database
cursor = db.cursor()

# Create tables if they don't exist
def create_tables():
    cursor.execute("""
                    CREATE TABLE IF NOT EXISTS customers (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(100), address VARCHAR(100)
                    )
                """)

    cursor.execute("""
                    CREATE TABLE IF NOT EXISTS menu (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        food_item VARCHAR(100),
                        rate INT
                    )
                """)

    cursor.execute("""
                    CREATE TABLE IF NOT EXISTS orders (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        customer_id INT,
                        food_id INT,
                        quantity INT,
                        rate INT,
                        FOREIGN KEY (customer_id) REFERENCES customers(id),
                        FOREIGN KEY (food_id) REFERENCES menu(id)
                        )
                    """)

def display_menu():
    print("\n--------- Food Ordering System ---------\n")
    print("1. Add Customer")
    print("2. Add Menu")
    print("3. View Menu")
    print("4. Place Order")
    print("5. View Customers")
    print("6. View Orders")
    print("7. Exit")

def add_customer():
    print("\n--------- Add Customer ---------\n")
    name = input("Enter customer name: ")
    address = input("Enter customer address: ")

    cursor.execute("INSERT INTO customers (name, address) VALUES (%s, %s)", (name, address))
    db.commit()
    print("\nCustomer added successfully.")

def add_menu():
    print("\n--------- Add Menu ---------\n")
    name = input("Enter Food name: ")
    rate = input("Enter Rate: ")

    cursor.execute("INSERT INTO menu (food_item, rate) VALUES (%s, %s)", (name, rate))
    db.commit()
    print("\nMenu added successfully.")

def place_order():
    print("\n--------- Place Order ---------\n")
    view_customers()
    customer_id = input("Enter customer ID: ")
    view_menu()
    food_item = input("Enter food id: ")
    quantity = int(input("Enter quantity: "))

    cursor.execute("SELECT rate FROM menu WHERE id = %s", (food_item,))
    rate = cursor.fetchone()

    if rate:
        rate = rate[0] * quantity
    else:
        print("Menu not available")
        return

    cursor.execute("INSERT INTO orders (customer_id, food_id, quantity, rate) VALUES (%s, %s, %s, %s)", (customer_id, food_item, quantity, rate))
    db.commit()
    print("\nOrder placed successfully, Your Bill amount is Rs.", rate, " Only")

def view_menu():
    cursor.execute("SELECT id, food_item, rate FROM menu")
    menus = cursor.fetchall()

    if menus:
        print("\n--------- Menu ---------\n")
        print("{:<5} {:<15} {:<5}".format("ID", "Food Item", "Rate"))
        print("----------------------------")
        for menu in menus:
            id, food_item, rate = menu
            print("{:<5} {:<15} {:<5}".format(id, food_item, rate))
        print("----------------------------")
    else:
        print("\nNo Menu Item.")

def view_customers():
    cursor.execute("SELECT id, name, address FROM customers")
    customers = cursor.fetchall()

    if customers:
        print("\n--------- Customer's ---------\n")
        print("{:<5} {:<15} {:<10}".format("ID", "Customer", "Address"))
        print("----------------------------------")

        for customer in customers:
            customer_id, customer_name, address = customer
            print("{:<5} {:<15} {:<10}".format(customer_id, customer_name, address))
        print("----------------------------------")
    else:
        print("\nNo customers found.")


def view_orders():
    cursor.execute("""
                    SELECT O.id, C.name, M.food_item, O.quantity, O.rate
                    FROM orders O
                    INNER JOIN customers C ON O.customer_id = C.id
                    INNER JOIN menu M ON M.id = O.food_id
                """)
    orders = cursor.fetchall()

    if orders:
        print("\n--------- ORDERS ---------\n")
        print("{:<5} {:<15} {:<15} {:<10} {:<5}".format("ID", "Customer", "Food Item", "Quantity", "Rate"))
        print("-----------------------------------------------------")

        for order in orders:
            order_id, customer_name, food_item, quantity, rate = order
            print("{:<5} {:<15} {:<15} {:<10} Rs.{:<5}".format(order_id, customer_name, food_item, quantity, rate))

        print("-----------------------------------------------------")
    else:
        print("\nNo orders found.")


#Main Method
def main():
    create_tables()

    while True:
        display_menu()
        choice = input("\nEnter your choice (1-3): ")

        if choice == "1":
            add_customer()
        elif choice == "2":
            add_menu()
        elif choice == "3":
            view_menu()
        elif choice == "4":
            place_order()
        elif choice == "5":
            view_customers()
        elif choice == "6":
            view_orders()
        elif choice == "7":
            break
        else:
            print("\nInvalid choice. Please try again.")

    cursor.close()
    db.close()
    print("Program terminated.")

if __name__ == '__main__':
    main()
