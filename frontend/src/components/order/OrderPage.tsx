import { HStack, VStack } from "../common/Stack";
import OrderSelectorButton from "./OrderSelectorButton";

interface OrderPageParams {
  title: string;
  textLeft: string;
  textRight: string;
  isLeftSelected: boolean | null;
  onSelect: (b: boolean, s: string) => void;
  onNext: () => void;
}

function OrderPage({
  title,
  textLeft,
  textRight,
  isLeftSelected,
  onSelect,
  onNext,
}: OrderPageParams) {
  return (
    <VStack className="items-center h-96 justify-center">
      <span className="font-bold text-3xl mb-3">
        <span className="text-blue-600">{title}</span>을 선택해 주세요.
      </span>
      <HStack className="gap-10">
        <OrderSelectorButton
          text={textLeft}
          selected={isLeftSelected == true}
          onClick={() => onSelect(true, textLeft)}
        />
        <OrderSelectorButton
          text={textRight}
          selected={isLeftSelected == false}
          onClick={() => onSelect(false, textRight)}
        />
      </HStack>
      <button
        className={`text-3xl w-24 h-8 text-blue-500 font-bold transition-opacity 
            ${isLeftSelected != null ? "opacity-100" : "opacity-0"}`}
        onClick={onNext}
      >
        <div className="animate-bounce">⌄</div>
      </button>
    </VStack>
  );
}

export default OrderPage;
