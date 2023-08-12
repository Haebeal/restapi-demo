import DoDelete from "./api/DoDelete";
import DoPost from "./api/DoPost";
import DoPut from "./api/DoPut";
import FindOne from "./api/FindOne";
import FindAll from "./api/FindeAll";

const App = () => {
  return (
    <>
      <FindOne />
      <FindAll />
      <DoPost />
      <DoPut />
      <DoDelete />
    </>
  );
};

export default App;
