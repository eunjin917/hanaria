import GroupType from "../../types/GroupType";
import GroupCell from "./GroupCell";

interface TestGroupPageProps {
  groups: GroupType[];
  onSelect: (group: GroupType) => void;
}

function TestGroupPage({ groups, onSelect }: TestGroupPageProps) {
  return (
    <div className="grid grid-cols-3 mx-12 mb-6">
      {groups.length == 0 ? (
        <span>상품 로딩 중 ...</span>
      ) : (
        groups.map((group, index) => (
          <GroupCell
            key={index}
            group={group}
            onClick={() => onSelect(group)}
          />
        ))
      )}
    </div>
  );
}
export default TestGroupPage;
