import { useState } from "react";
import TestGroupContainer from "../components/product/TestGroupContainer";
import GroupType from "../types/GroupType";
import Modal from "../components/common/Modal";
import ItemSelector from "../components/product/ItemSelector";
import CartList from "../components/cart/CartList";
import LocalItemType from "../types/local/LocalItemType";
import { VStack } from "../components/common/Stack";

function Products() {
  const [selectedGroup, setSelectedGroup] = useState<GroupType | null>();
  const [cartItems, setCartItems] = useState<LocalItemType[]>([]);
  const appendCartItem = (item: LocalItemType) => {
    setCartItems([...cartItems, item]);
  };
  const changeItem = (item: LocalItemType, index: number) => {
    const cartItemsDraft = [...cartItems];
    cartItemsDraft[index] = item;
    setCartItems(cartItemsDraft);
  };
  const deleteItem = (index: number) => {
    const cartItemsDraft = [...cartItems];
    cartItemsDraft.splice(index, 1);
    setCartItems(cartItemsDraft);
  };

  return (
    <VStack className="items-center w-full">
      <TestGroupContainer onSelect={setSelectedGroup} />
      {selectedGroup && (
        <Modal onClose={() => setSelectedGroup(null)}>
          <ItemSelector
            onClose={() => setSelectedGroup(null)}
            group={selectedGroup}
            onSelect={appendCartItem}
          />
        </Modal>
      )}
      <CartList items={cartItems} onChange={changeItem} onDelete={deleteItem} />
    </VStack>
  );
}

export default Products;
