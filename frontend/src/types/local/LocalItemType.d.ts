import OptionType from "./OptionType";
import ProductType from "./ProductType";

type LocalItemType = {
  price: number;
  count: number;
  request: number;
  product: ProductType;
  dessertOption: OptionType;
  drinkOption: OptionType;
};
export default LocalItemType;
