(async() => {
    const url = 'http://localhost:8080/restaurants';
    const response = await fetch(url)
    const restaurants = await response.json();
    const ele = document.getElementById('app');

    ele.innerHTMP = `
        ${restaurants.map(restaurant => `
                <p>
                    ${restaurant.id}
                    ${restaurant.name}
                    ${restaurant.address}
                </p>
        `).join('')}
    `;

    console.log(restaurants)
})();

