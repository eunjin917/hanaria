import GroupType from "./GroupType";

type CategoryType = {
  id: number; // Category enum의 index
  name: string; // Category enum의 valueKo
  nameEn: string; // Category enum의 valueEn
  pageCnt: number; //  페이지들의 갯수
  startIndex: number; // 시작번호(0부터)
};

export default CategoryType;
