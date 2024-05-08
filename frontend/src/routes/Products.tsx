import { useState } from "react";
import TestGroupContainer from "../components/product/TestGroupContainer";
import GroupType from "../types/GroupType";
import Modal from "../components/common/Modal";
import ItemSelector from "../components/product/ItemSelector";

function Products() {
  const [selectedGroup, setSelectedGroup] = useState<GroupType | null>();

  return (
    <div className="w-full h-full">
      <TestGroupContainer onSelect={setSelectedGroup} />
      {selectedGroup && (
        <Modal onClose={() => setSelectedGroup(null)}>
          <ItemSelector
            onClose={() => setSelectedGroup(null)}
            group={selectedGroup}
            onSelect={console.log}
          />
        </Modal>
      )}
    </div>
  );
}

export default Products;
