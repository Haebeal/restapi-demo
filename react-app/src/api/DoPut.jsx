import { useEffect, useState } from "react";

const DoPut = () => {
  const [state, setState] = useState()
  const url = 'http://localhost:8080/items/2';

  useEffect(() => {

    fetch(url, {
      method: 'PUT',
      headers: {'Content-Type': 'application/json'},
      body: JSON.stringify({
        itemName: 'PutTest'
      })
    })
    .then(res => res.json())
    .then(data => setState(data))
  },[]);

  return (
    <>
    </>
  )
};

export default DoPut;
