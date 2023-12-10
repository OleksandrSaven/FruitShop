function deleteItem(CartItemId) {

    // URL for the delete item endpoint
    const apiUrl = `http://localhost:8080/api/cart/${CartItemId}`;

    // Send a DELETE request to delete the item
    fetch(apiUrl, {
        method: 'DELETE',
    })
        .then(response => {
            if (response.ok) {
                // Handle success, e.g., remove the product row from the UI
                return window.location.reload();
                console.log('Item deleted successfully.');
            } else {
                // Handle errors, e.g., display an error message
                console.error('Error deleting item:', response.statusText);
            }
        })
        .catch(error => {
            // Handle errors, e.g., display an error message
            console.error('Error deleting item:', error.message);
        });
}
