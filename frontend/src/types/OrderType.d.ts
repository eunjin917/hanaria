import ItemType from "./ItemType";

type OrderType = {
  price: number;
  isForHere: boolean;
  memberId: number;
  items: ItemType[];
};
export default OrderType;
