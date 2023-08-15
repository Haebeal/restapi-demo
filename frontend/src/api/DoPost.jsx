import { useEffect, useState } from "react"

const DoPost = () => {
  const url = 'http://localhost:8080/items';
  const [state, setState] = useState();

  useEffect(() => {

    fetch(url, {
      method: 'POST',
      headers: {'Content-Type': 'application/json'},
      body: JSON.stringify({
        itemName: 'PostTest',
      })
    })
    .then(res => res.json())
    .then(data => setState(data))
  },[]);

  return (
    <>
    </>
  );
};

export default DoPost;
