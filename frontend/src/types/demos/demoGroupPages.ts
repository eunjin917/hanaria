import GroupType from "../GroupType";
import {
  demoBurgerCombo,
  demoBurgerSet,
  demoBurgerSingle,
  demoDessert1,
  demoDessert2,
  demoDrink1,
  demoDrink2,
} from "./demoProducts";

export const demoBurgerGroups: GroupType[] = [
  {
    id: 0,
    name: "왕돈까스버거",
    nameEn: "Big Katsu Burger",
    productList: [demoBurgerSingle, demoBurgerCombo, demoBurgerSet],
  },
  {
    id: 1,
    name: "매운왕돈까스버거",
    nameEn: "Big Spicy Katsu Burger",
    productList: [demoBurgerSingle, demoBurgerCombo, demoBurgerSet],
  },
  {
    id: 2,
    name: "새우베이컨버거",
    nameEn: "Shrimp Bacon Burger",
    productList: [demoBurgerSingle, demoBurgerCombo, demoBurgerSet],
  },
  {
    id: 3,
    name: "불고기베이컨버거",
    nameEn: "Bulgogi Bacon Burger",
    productList: [demoBurgerSingle, demoBurgerSet],
  },
];

export const demoDessertGroups: GroupType[] = [
  {
    id: 30,
    name: "치즈스틱",
    nameEn: "",
    productList: [demoDessert1, demoDessert2],
  },
  {
    id: 31,
    name: "롱치즈스틱",
    nameEn: "",
    productList: [demoDessert1, demoDessert2],
  },
  {
    id: 32,
    name: "치킨너겟",
    nameEn: "",
    productList: [demoDessert1, demoDessert2],
  },
  {
    id: 33,
    name: "통오징어링",
    nameEn: "",
    productList: [demoDessert1, demoDessert2],
  },
  {
    id: 34,
    name: "콘샐러드",
    nameEn: "",
    productList: [demoDessert1],
  },
];
export const demoDrinkGroups: GroupType[] = [
  {
    id: 44,
    name: "캐모마일 티",
    nameEn: "",
    productList: [demoDrink1, demoDrink2],
  },
  {
    id: 45,
    name: "애플 캐모마일 티",
    nameEn: "",
    productList: [demoDrink1, demoDrink2],
  },
  {
    id: 46,
    name: "콜라",
    nameEn: "",
    productList: [demoDrink1, demoDrink2],
  },
  {
    id: 47,
    name: "사이다",
    nameEn: "",
    productList: [demoDrink1, demoDrink2],
  },
  {
    id: 48,
    name: "제로슈거콜라",
    nameEn: "",
    productList: [demoDrink1, demoDrink2],
  },
  {
    id: 49,
    name: "자두쿨 에이드",
    nameEn: "",
    productList: [demoDrink1, demoDrink2],
  },
];

export const demoDrinkGroups2: GroupType[] = [
  {
    id: 50,
    name: "복숭아 홍차 에이드(R)",
    nameEn: "",
    productList: [demoDrink1, demoDrink2],
  },
  {
    id: 51,
    name: "아이스티",
    nameEn: "",
    productList: [demoDrink1, demoDrink2],
  },
];
