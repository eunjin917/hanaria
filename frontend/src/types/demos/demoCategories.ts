import CategoryType from "../CategoryType";
import GroupType from "../GroupType";
import {
  demoBurgerGroups,
  demoDessertGroups,
  demoDrinkGroups,
  demoDrinkGroups2,
} from "./demoGroupPages";

const demoCategories: CategoryType[] = [
  {
    id: 0,
    name: "햄버거",
    nameEn: "Burger",
    pageCnt: 1,
    startIndex: 0,
  },
  {
    id: 1,
    name: "디저트",
    nameEn: "Dessert",
    pageCnt: 1,
    startIndex: 1,
  },
  {
    id: 2,
    name: "음료",
    nameEn: "Drink",
    pageCnt: 2,
    startIndex: 2,
  },
];

export const demoCategoryPages: GroupType[][] = [
  demoBurgerGroups,
  demoDessertGroups,
  demoDrinkGroups,
  demoDrinkGroups2,
];

export default demoCategories;
