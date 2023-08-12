import { useEffect, useState } from "react";
import DoPut from "./DoPut";

const DoDelete = () => {
  const [state, setState] = useState();
  const url = 'http://localhost:8080/items/3';

  useEffect(() => {

    fetch(url, {method: 'DELETE'})
    .then(function(response) {

    }, function(err) {

    });
  },[]);

  return (
    <>
    </>
  );
};

export default DoDelete;
