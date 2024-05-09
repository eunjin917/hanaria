import { memo } from "react";

interface CategorySelectorProps
  extends React.ButtonHTMLAttributes<HTMLButtonElement> {
  text: string;
  selected: boolean;
}

function CategorySelectorNoMemo({
  text,
  selected,
  ...attributes
}: CategorySelectorProps) {
  if (selected)
    return (
      <button
        className="bg-blue-400 rounded-lg p-2 mr-1 font-bold text-white"
        {...attributes}
      >
        {text}
      </button>
    );
  else
    return (
      <button
        className="bg-blue-50 rounded-lg p-2 mr-1 font-bold text-blue-400"
        {...attributes}
      >
        {text}
      </button>
    );
}

const CategorySelector = memo(
  CategorySelectorNoMemo,
  ({ selected: a }, { selected: b }) => a === b
);

export default CategorySelector;
