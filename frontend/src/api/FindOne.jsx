import { useEffect, useState } from "react";

const FindOne = () => {
  const id = 1;
  const url ='http://localhost:8080/items/';
  const [item, setItem] = useState([]);

  useEffect(() => {
    fetch(`${url}${id}`, {method: 'GET'})
    .then(res => res.json())
    .then(data => setItem(data))
  },[]);

  return (
    <>
      <div>
        <p key={item.id}>{item.itemName}</p>
      </div>
    </>
  );
};

export default FindOne;
