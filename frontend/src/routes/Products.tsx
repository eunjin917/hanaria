import TestGroupContainer from "../components/product/TestGroupContainer";
import ItemSelector from "../components/product/ItemSelector";
import { HStack, VStack } from "../components/common/Stack";
import LocalItemType from "../types/local/LocalItemType";
import CartList from "../components/cart/CartList";
import Button from "../components/common/Button";
import Modal from "../components/common/Modal";
import GroupType from "../types/GroupType";
import { useState } from "react";
import OrderBuilder from "../components/order/OrderBuilder";
import OrderType from "../types/OrderType";
import PaymentBuilder from "../components/order/PaymentBuilder";
import LocalUserType from "../types/local/LocalUserType";
import AuthPage from "../components/login/AuthPage";
interface ProductsProps {
  onMain: () => void;
}
function Products({ onMain }: ProductsProps) {
  // TODO: useContext,useReducer,세션스토리지로 상태들 옮기고 라우팅하기
  const [selectedGroup, setSelectedGroup] = useState<GroupType | null>();
  const [cartItems, setCartItems] = useState<LocalItemType[]>([]);
  const [isCartDone, setIsCartDone] = useState<boolean>(false);
  const [isOrderDone, setIsOrderDone] = useState<boolean>(false);
  const [isLumpSum, setIsLumpSum] = useState<boolean>(true);
  const [orderId, setOrderId] = useState<number | null>(null);
  const [orderCode, setOrderCode] = useState<string>("");
  const [isLogining, setIsLogining] = useState<boolean>(false);
  const [user, setUser] = useState<LocalUserType | null>(null);
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
  const completeCart = () => {
    if (cartItems.length > 0) setIsCartDone(true);
  };
  const completeOrder = (order: OrderType, isLumpSum: boolean) => {
    setIsOrderDone(true);
    //TODO: 서버통신
    setOrderId(0);
    setOrderCode("asdf-asdf-asdf-1234");
    setIsLumpSum(isLumpSum);
  };
  // 일단은 라우팅 안하고 이 안에서 해결
  return (
    <>
      {isCartDone && isOrderDone && (
        <Modal onClose={() => {}} closeButton={false}>
          {orderId == null ? (
            <>주문정보 전송 중 ...</>
          ) : (
            <PaymentBuilder
              orderId={orderId}
              totalPrice={totalPrice}
              isLumpSum={isLumpSum}
              orderCode={orderCode}
            />
          )}
        </Modal>
      )}
      {isCartDone && !isOrderDone && (
        <Modal onClose={() => {}} closeButton={false}>
          <OrderBuilder
            cartItems={cartItems}
            totalPrice={totalPrice}
            onClose={() => setIsCartDone(false)}
            onLogin={() => {}}
            currentPoint={0}
            earningPoint={Math.floor(totalPrice / 10)}
            onOrderDone={completeOrder}
          />
        </Modal>
      )}
      {isLogining && (
        <Modal
          onClose={() => {
            setIsLogining(false);
          }}
        >
          <AuthPage onLogin={setUser} />
        </Modal>
      )}
      <VStack className="items-center w-full gap-0">
        {user == null ? (
          <Button
            className="absolute right-0 top-0 bg-red-300 font-bold py-1 rounded-md m-2"
            onClick={() => setIsLogining(true)}
          >
            로그인하여 쿠폰 사용하기
          </Button>
        ) : (
          <Button className="absolute right-0 top-0 bg-red-300 font-bold py-1 rounded-md m-2">
            쿠폰 목록
          </Button>
        )}
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
        <CartList
          items={cartItems}
          onChange={changeItem}
          onDelete={deleteItem}
        />
        <HStack className="">
          <Button
            className="!w-64 mx-2 bg-yellow-200 text-xl font-bold"
            onClick={onMain}
          >
            메인으로
          </Button>
          <Button
            className={`!w-64 mx-2 text-xl font-bold ${cartItems.length > 0 ? "bg-yellow-200" : "bg-gray-200"}`}
            onClick={completeCart}
          >
            주문하기
            {cartItems.length > 0 ? ` (${totalPrice.toLocaleString()}원)` : ""}
          </Button>
        </HStack>
      </VStack>
    </>
  );
}

export default Products;
