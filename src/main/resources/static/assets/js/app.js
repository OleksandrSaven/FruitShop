document.addEventListener('DOMContentLoaded', () => {
    // Функція для отримання даних з JSON-файлу
    function fetchData(url, callback) {
        fetch(url)
            .then(response => response.json())
            .then(data => callback(data))
            .catch(error => console.error('Error:', error));
    }

// Функція для відображення даних у таблиці
    function displayDataInTable(cartData) {
        const tableBody = document.getElementById('tableBody');

        // Очищаємо поточний вміст таблиці
        tableBody.innerHTML = '';

        // Додаємо рядки до таблиці для кожного товару в корзині
        cartData.cartItems.forEach(cartItem => {
            const row = document.createElement('tr');

            // Remove Button
            const removeCell = document.createElement('td');
            const removeLink = document.createElement('a');
            const removeIcon = document.createElement('i');
            //removeLink.href = '#';
            removeLink.onclick = function() {
                console.log("helloworld", cartItem)
            deleteItem(cartItem.id)

            };
            removeIcon.classList.add('far', 'fa-window-close');
            removeLink.appendChild(removeIcon);
            removeCell.appendChild(removeLink);
            row.appendChild(removeCell);

            // Product Image
            const imageCell = document.createElement('td');
            const productImage = document.createElement('img');
            productImage.src = cartItem.image; // Replace with actual image source
            productImage.alt = cartItem.name;
            imageCell.classList.add('product-image');
            imageCell.appendChild(productImage);
            row.appendChild(imageCell);


            // Product Name
            const nameCell = document.createElement('td');
            nameCell.textContent = cartItem.name;
            row.appendChild(nameCell);

            // Product Price
            const priceCell = document.createElement('td');
            priceCell.textContent = `$${cartItem.price}`;
            row.appendChild(priceCell);

            // Product Quantity
            const quantityCell = document.createElement('td');
            const quantityInput = document.createElement('input');
            quantityInput.type = 'number';
            quantityInput.min = 1;
            quantityInput.placeholder = '0';
            quantityInput.onchange = function (e) {
                console.log("e", e)
                changeItem(cartItem.id, e.target.value);

            }
            quantityInput.value = cartItem.quantity;
            quantityCell.appendChild(quantityInput);
            row.appendChild(quantityCell);

            // Product Total
            const totalCell = document.createElement('td');
            totalCell.textContent = cartItem.quantity * cartItem.price;
            row.appendChild(totalCell);


            tableBody.appendChild(row);
        });
    }

    const jsonUrl = 'http://localhost:8080/api/cart\\1'; // request
    fetchData(jsonUrl, displayDataInTable);
});