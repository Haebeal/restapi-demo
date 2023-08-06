import { useEffect, useState } from "react";

const App = () => {
  const url = 'http://localhost:8080/items';
  const [items, setItems] = useState([]);
  
  useEffect(() => {
    fetch(url,{method: 'GET'})
    .then(res => res.json())
    .then(data => {
      setItems(data)
    })
  },[]);

  return (
    <>
      <div className="App">
        <p>{console.log(items)}</p>
        <ul>
          {
            items.map(item => 
              <li key={item.id}>{item.itemName}</li>
            )
          }
        </ul>
      </div>
    </>
  );
};

export default App;
