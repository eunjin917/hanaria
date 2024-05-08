import OptionType from "../../types/OptionType";

interface OptionCellProps
  extends React.ButtonHTMLAttributes<HTMLButtonElement> {
  option: OptionType;
  selected: boolean;
}

function GroupCell({ option, selected, ...attributes }: OptionCellProps) {
  return (
    <button
      className="flex flex-col text-start hover:scale-105 m-2 transition-all cursor-pointer "
      {...attributes}
    >
      <img
        className={`bg-white w-24 h-24 object-contain rounded-xl shadowed mb-2 ${selected ? "border border-blue-500" : ""}`}
        src={option.productImage ?? ""}
      />
      <span className="w-24 truncate font-bold">{option.productName}</span>
      <span className="font-semibold text-">
        +{(option.price ?? 0).toLocaleString()}원
      </span>
    </button>
  );
}

export default GroupCell;
