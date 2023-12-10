function changeItem(CartItemId, quantity) {

    // URL for the delete item endpoint
    const apiUrl = `http://localhost:8080/api/cart/${CartItemId}`;
    const jsonData = {
        "quantity": quantity
    }

    // Send a DELETE request to delete the item
    fetch(apiUrl, {
        method: 'PUT',
        credentials:"omit",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body:JSON.stringify(jsonData),
    })
        .then(response => {
            if (response.ok) {
                // Handle success, e.g., remove the product row from the UI
                return window.location.reload();
            } else {
                // Handle errors, e.g., display an error message
                console.error('Error changed item:', response.statusText);
            }
        })
        .catch(error => {
            // Handle errors, e.g., display an error message
            console.error('Error changed item:', error.message);
        });
}