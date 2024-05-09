import RequestType from "../RequestType";

export const demoBurgerReqeusts: RequestType[] = [
  {
    id: 0,
    body: "데모버거: 양파 빼주세요",
    bit: 2 ** 0,
  },
  {
    id: 1,
    body: "데모버거: 피클 빼주세요",
    bit: 2 ** 1,
  },
  {
    id: 2,
    body: "데모버거: 토마토 빼주세요",
    bit: 2 ** 2,
  },
  {
    id: 3,
    body: "데모버거: 양상추 빼주세요",
    bit: 2 ** 3,
  },
  {
    id: 4,
    body: "데모버거: 양심 빼주세요",
    bit: 2 ** 4,
  },
];

export const demoDessertReqeusts: RequestType[] = [
  {
    id: 20,
    body: "감자튀김: 케첩 하나 더 주세요",
    bit: 2 ** 20,
  },
  {
    id: 21,
    body: "감자튀김: 소금 빼주세요",
    bit: 2 ** 21,
  },
];
export const demoDrinkReqeusts: RequestType[] = [
  {
    id: 30,
    body: "콜라: 얼음 빼주세요",
    bit: 2 ** 30,
  },
  {
    id: 31,
    body: "콜라: 빨대 필요 없어요",
    bit: 2 ** 31,
  },
];
