import { useEffect, useState } from "react";
import Item from "./Item";
import axios from "axios";

function ItemContainer() {
    const [items, setItems] = useState([]);

    const getItems = async () => {
        try {
            const { data } = await axios.get("http://localhost:8080/item/read");
            setItems(data);
        } catch (err) {
            console.error(err);
        }
    }

    useEffect(() => {
        getItems();
    })


    return (<table style={{maxWidth: '500px', margin: 'auto'}}  className="table table-striped">
        <thead>
            <tr>
                <th>
                    Name
                </th>
                <th>
                    Price
                </th>
                <th>
                    In Cart
                </th>
            </tr>
        </thead>
        <tbody>
            {items.map(({ id, name, price, inCart }) => (
                <Item
                    key={id}
                    id={id}
                    name={name}
                    price={price}
                    inCart={inCart}
                    getItems={getItems}
                />))}
        </tbody>
    </table>);
}

export default ItemContainer;