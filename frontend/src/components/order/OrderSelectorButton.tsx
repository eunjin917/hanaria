import { memo } from "react";

interface OrderSelectorButtonParams
  extends React.ButtonHTMLAttributes<HTMLButtonElement> {
  text: string;
  selected: boolean;
}

function OrderSelectorButtonNoMemo({
  text,
  selected,
  ...attributes
}: OrderSelectorButtonParams) {
  return (
    <button
      className={
        "m-3 text-2xl w-48 h-48 shadowed rounded-lg p-2 font-bold transition-all " +
        (selected ? "text-blue-400 bg-blue-50 " : "bg-white text-gray-400 ") +
        attributes.className
      }
      {...attributes}
    >
      {text}
    </button>
  );
}

const OrderSelectorButton = memo(
  OrderSelectorButtonNoMemo,
  ({ selected: a }, { selected: b }) => a === b
);

export default OrderSelectorButton;
