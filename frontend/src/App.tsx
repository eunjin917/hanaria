import { useState } from "react";
import PinkBox from "./components/common/PinkBox";
import { HStack, Spacer, VStack } from "./components/common/Stack";

function App() {
  const [count, setCount] = useState(0);

  return (
    <div className="w-full h-full">
      <h1>하나리아</h1>
      <div className="card">
        <button
          className="border border-red-500 "
          onClick={() => setCount((count) => count + 1)}
        >
          count is {count}
        </button>
        <HStack>
          <VStack>
            <PinkBox />
            <PinkBox />
            <PinkBox />
            <PinkBox />
          </VStack>

          <VStack>
            <PinkBox />
            <PinkBox />
            <Spacer />
            <PinkBox />
          </VStack>

          <VStack>
            <Spacer />
            <PinkBox />
            <PinkBox />
            <PinkBox />
          </VStack>

          <VStack>
            <PinkBox />
            <PinkBox />
            <PinkBox />
            <Spacer />
          </VStack>

          <VStack>
            <Spacer />
            <PinkBox />
          </VStack>
        </HStack>
        <div className="flex flex-col items-center w-48 h-48 rounded-xl shadowed font-bold leading-none">
          <img src="https://img.lotteeatz.com/upload/product/2023/02/10/20230210102118259_1.png" />
          <span className="mb-2">한우불고기</span>
          <HStack>
            <button className="rounded shadowed w-4 h-4">-</button>
            <span className="w-4 text-center">1</span>
            <button className="rounded shadowed w-4 h-4">+</button>
          </HStack>
        </div>
      </div>
    </div>
  );
}

export default App;
