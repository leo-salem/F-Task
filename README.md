# 📦 Quantum Supermarket Checkout System

This is a **Java console-based supermarket checkout system** that simulates a real-world shopping experience. It supports different types of products (shippable, expirable, digital) and models a checkout process with stock management, validation, shipping weight calculation, and customer payment handling.

---

---

## 📦 Product Types

- **Product**: Base product (e.g., scratch cards)
- **ExpirableProduct**: Cannot be sold if expired
- **ShippableProduct**: Requires shipping, has weight
- **ExpirableAndShippableProduct**: Combination of both
- **Digital Products**: No shipping or expiration

---

## 🧾 Features

- Add items to a shopping cart
- Validates product existence, quantity, expiration
- Prevents expired purchases
- Calculates shipping weight for physical products
- Displays shipping notice and checkout receipt
- Deducts amount from customer balance
- Dynamically updates inventory stock

---

## 🚚 Shipping Logic

For each `Shippable` item, the system:

- Adds it to a shipping list
- Calculates and displays total package weight
- Shows quantity and weight per product

---

## 💸 Checkout Flow

1. Customer adds items to cart
2. System validates:
   - Item is available
   - Quantity is valid
   - Product is not expired
3. Calculates total + shipping (30 units)
4. Deducts balance if enough
5. Prints receipt and updated balance

---

## 💡 Sample Output

![Sample Run Output]


![Screenshot 2025-07-08 225427](https://github.com/user-attachments/assets/604e5954-bba9-430d-b995-8151d7cded42)

