import { useState } from "react";
import TestGroupContainer from "../components/product/TestGroupContainer";
import GroupType from "../types/GroupType";
import Modal from "../components/common/Modal";
import ItemSelector from "../components/product/ItemSelector";
import CartList from "../components/cart/CartList";
import LocalItemType from "../types/local/LocalItemType";
import { HStack, VStack } from "../components/common/Stack";
import Button from "../components/common/Button";

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
  const totalPrice: number = cartItems.reduce(
    (sum, item) => (sum += item.price),
    0
  );

  return (
    <VStack className="items-center w-full gap-0">
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
      <HStack>
        <Button className="w-64 mx-2 bg-yellow-200 text-xl font-bold">
          메인으로
        </Button>
        <Button className="w-64 mx-2 bg-yellow-200 text-xl font-bold">
          주문하기
          {cartItems.length > 0 ? ` (${totalPrice.toLocaleString()}원)` : ""}
        </Button>
      </HStack>
    </VStack>
  );
}

export default Products;
