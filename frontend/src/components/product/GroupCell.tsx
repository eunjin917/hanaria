import GroupType from "../../types/GroupType";

interface GroupCellProps extends React.ButtonHTMLAttributes<HTMLButtonElement> {
  group: GroupType;
}

function GroupCell({ group, ...attributes }: GroupCellProps) {
  return (
    <button
      className="flex flex-col text-start hover:scale-105 m-2 transition-all cursor-pointer "
      {...attributes}
    >
      <img
        className="bg-white w-36 h-36 object-contain rounded-xl shadowed mb-2"
        src={group.productList[0]?.image ?? ""}
      />
      <span className="w-36 truncate font-bold">{group.name}</span>
      <span className="font-semibold text-">
        {(group.productList[0].price ?? 0).toLocaleString()}원
        {group.productList.length > 1 ? " ~" : ""}
      </span>
    </button>
  );
}

export default GroupCell;
