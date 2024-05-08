type ProductType = {
  id: number;
  price: number;
  name: string;
  nameEn: string;
  image: string; //url
  recommended: boolean;

  //추가 필드
  dessertOptionAvailable: boolean; // 세트라면 true
  drinkOptionAvailable: boolean; // 콤보나 세트라면 true
};

export default ProductType;
