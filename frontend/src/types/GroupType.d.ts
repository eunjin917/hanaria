import ProductType from "./ProductType";

type GroupType = {
  id: number;
  name: string;
  nameEn: string;
  products: ProductType[];
};
export default GroupType;
