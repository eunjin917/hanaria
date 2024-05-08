type CategoryType = {
  id: number; // Category enum의 index
  name: string; // Category enum의 valueKo
  nameEn: string; // Category enum의 valueEn
  pages: GroupPageType[][]; // 최대 6개의 그룹으로 이루어 진 페이지들의 배열
};

export default CategoryType;
