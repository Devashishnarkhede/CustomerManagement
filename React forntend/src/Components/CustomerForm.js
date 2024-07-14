import React, { useState, useEffect } from 'react';
import { addCustomer, updateCustomer } from '../services/api';

const CustomerForm = ({ token, customer, fetchCustomers }) => {
    const [formData, setFormData] = useState({
        id: customer ? customer.id : '',
        first_name: customer ? customer.first_name : '',
        last_name: customer ? customer.last_name : '',
        street: customer ? customer.street : '',
        address: customer ? customer.address : '',
        city: customer ? customer.city : '',
        state: customer ? customer.state : '',
        email: customer ? customer.email : '',
        phone: customer ? customer.phone : ''
    });

    const handleChange = (e) => {
        setFormData({ ...formData, [e.target.name]: e.target.value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        if (customer) {
            await updateCustomer(formData, token);
        } else {
            await addCustomer(formData, token);
        }
        fetchCustomers();
    };

    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label>First Name:</label>
                <input type="text" name="first_name" value={formData.first_name} onChange={handleChange} required />
            </div>
            <div>
                <label>Last Name:</label>
                <input type="text" name="last_name" value={formData.last_name} onChange={handleChange} required />
            </div>
            <div>
                <label>Street:</label>
                <input type="text" name="street" value={formData.street} onChange={handleChange} />
            </div>
            <div>
                <label>Address:</label>
                <input type="text" name="address" value={formData.address} onChange={handleChange} />
            </div>
            <div>
                <label>City:</label>
                <input type="text" name="city" value={formData.city} onChange={handleChange} />
            </div>
            <div>
                <label>State:</label>
                <input type="text" name="state" value={formData.state} onChange={handleChange} />
            </div>
            <div>
                <label>Email:</label>
                <input type="email" name="email" value={formData.email} onChange={handleChange} />
            </div>
            <div>
                <label>Phone:</label>
                <input type="text" name="phone" value={formData.phone} onChange={handleChange} />
            </div>
            <button type="submit">{customer ? 'Update' : 'Add'} Customer</button>
        </form>
    );
};

export default CustomerForm;
