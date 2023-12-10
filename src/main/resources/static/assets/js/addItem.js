function handleAddItem(itemId, quantity, cartId) {
    console.log('item quantity, cart', itemId, quantity, cartId);
    const jsonData = {
        fruitId: itemId,
        quantity: quantity,
        shoppingCartId: cartId
    }


    return fetch('http://localhost:8080/api/cart', {
        method: 'POST',
        credentials:"omit",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },

        body:JSON.stringify(jsonData),
    })
        .then(response => response.json())
        .then(response => console.log(JSON.stringify(response)))
        .catch(error => console.log('Something went wrong' +  error))
}
