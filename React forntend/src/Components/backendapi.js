const API_URL = 'http://localhost:8030';

export const getCustomers = async () => {
    const response = await fetch(`${API_URL}/findAllCustomers`, {
        method: 'GET',
        headers: { 'Content-Type': 'application/json' }
    });
    return response.json();
};

export const addCustomer = async (customer) => {
    await fetch(`${API_URL}/AddCustomer`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(customer)
    });
};

export const updateCustomer = async (customer) => {
    await fetch(`${API_URL}/update`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(customer)
    });
};

export const deleteCustomer = async (id) => {
    await fetch(`${API_URL}/deleteById/${id}`, {
        method: 'DELETE',
        headers: { 'Content-Type': 'application/json' }
    });
};

export const syncCustomers = async () => {
    await fetch(`${API_URL}/sync`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' }
    });
};
