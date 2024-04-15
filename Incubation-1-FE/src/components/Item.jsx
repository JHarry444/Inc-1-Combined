import axios from "axios";

function Item({id, name, price, inCart, getItems}) {
    const addToCart = async () => {
        try {
            await axios.patch("http://localhost:8080/item/addCart/" + id);
            getItems();
        } catch(err) {
            console.error(err);
        }
    }

    const removeFromCart = async () => {
        try {
            await axios.patch("http://localhost:8080/item/removeCart/" + id);
            getItems();
        } catch(err) {
            console.error(err);
        }
    }


    return ( <tr>
        <td>
            {name}
        </td>
        <td>
            {price}
        </td>
        <td>
            {inCart ? 
            <button type="button" style={{width: '200px'}} className="btn btn-danger" onClick={removeFromCart}>Remove From Cart</button> 
            : 
            <button type="button" style={{width: '200px'}} className="btn btn-success" onClick={addToCart}>Add To Cart</button>}
        </td>
    </tr> );
}

export default Item;