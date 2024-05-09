import { useState } from "react";
import Products from "./routes/Products";
import Main from "./routes/Main";

function App() {
  const [isMain, setIsMain] = useState<boolean>(true);
  if (isMain) return <Main onClick={() => setIsMain(false)} />;
  else return <Products onMain={() => setIsMain(true)} />;
}

export default App;
