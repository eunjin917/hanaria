import LocalItemType from "../../types/local/LocalItemType";
import { HStack, VStack } from "../common/Stack";

interface CartItemCellProps {
  item: LocalItemType;
  index: number;
  onChange: (item: LocalItemType, index: number) => void;
  onDelete: (index: number) => void;
}

function CartItemCell({ item, index, onChange, onDelete }: CartItemCellProps) {
  const countUp = () => {
    onChange({ ...item, count: item.count + 1 }, index);
  };
  const countDown = () => {
    if (item.count == 1) return;
    onChange({ ...item, count: item.count - 1 }, index);
  };
  const deleteItem = () => {
    onDelete(index);
  };
  return (
    <VStack className="items-center w-32 hover:scale-105 transition-all cursor-pointer ">
      <div className="flex flex-col justify-center items-center bg-white w-24 h-24 rounded-xl shadowed">
        <button
          className="absolute translate-x-12 -translate-y-12 rounded-full shadowed w-6 h-6 font-bold leading-none bg-red-500 text-white"
          onClick={deleteItem}
        >
          X
        </button>
        <img src={item.product.image ?? ""} />
      </div>
      <span className="text-center truncate font-bold">
        {item.product.name}
      </span>
      <HStack className="font-bold leading-none text-center">
        <button
          className="rounded shadowed w-4 h-4 bg-white"
          onClick={countDown}
        >
          -
        </button>
        <span className="w-4 h-4">{item.count}</span>
        <button className="rounded shadowed w-4 h-4 bg-white" onClick={countUp}>
          +
        </button>
      </HStack>
    </VStack>
  );
}
export default CartItemCell;
