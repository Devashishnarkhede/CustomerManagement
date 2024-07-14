import React, { useState, useEffect } from 'react';
import { getCustomers, deleteCustomer, syncCustomers } from '../services/api';

const CustomerList = ({ token }) => {
    const [customers, setCustomers] = useState([]);

    useEffect(() => {
        fetchCustomers();
    }, []);

    const fetchCustomers = async () => {
        const data = await getCustomers(token);
        setCustomers(data);
    };

    const handleDelete = async (id) => {
        await deleteCustomer(id, token);
        fetchCustomers();
    };

    const handleSync = async () => {
        await syncCustomers(token);
        fetchCustomers();
    };

    return (
        <div>
            <button onClick={handleSync}>Sync</button>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {customers.map(customer => (
                        <tr key={customer.id}>
                            <td>{customer.id}</td>
                            <td>{customer.first_name}</td>
                            <td>{customer.last_name}</td>
                            <td>
                                <button onClick={() => handleDelete(customer.id)}>Delete</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default CustomerList;
